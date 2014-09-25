package com.example.market;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.market.activity.MyApplication;
import com.example.market.db.Userinfo;
import com.example.market.web.HttpUtil;
import com.example.market.web.NetWorkHelper;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.DbUtils.DbUpgradeListener;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.util.LogUtils;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Main_LoginActivity extends Activity {
	private EditText userName, password;
	private Button btn_login;
	private ImageButton btnQuit;
	private String userNameValue, passwordValue;
	//private SharedPreferences sp;
	private int resCode = -1;
	private int userId = 0;
	private String resMsg;
	private String rootPath;
	private ProgressDialog pDialog;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 去除标题
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		DbUtils dbUtils=DbUtils.create(Main_LoginActivity.this, "market");
		if(dbUtils!=null)
		{
			if(dbUtils.getDaoConfig().getDbVersion()!=1)
			{
				try {
					dbUtils.dropDb();
					dbUtils=DbUtils.create(Main_LoginActivity.this,"matket",1,null);
					LogUtils.d("更新数据库到版本1");
				} catch (DbException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		
		rootPath =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/MyMarketApp";
		password = (EditText) findViewById(R.id.et_mima);
		btn_login = (Button) findViewById(R.id.btn_login);
		btnQuit = (ImageButton) findViewById(R.id.img_btn);
		//判断有网就从这里进入
		if(NetWorkHelper.checkNetState(this))
		{
			LogUtils.d("NetWorkHelper");
			GetMessage();
			btn_login.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					if(TextUtils.isEmpty(userName.getText())||TextUtils.isEmpty(password.getText()))
					{
						Toast.makeText(Main_LoginActivity.this, "账号或密码为空，请输入",
								Toast.LENGTH_LONG).show();
					}else{
						userNameValue = userName.getText().toString();
						passwordValue = password.getText().toString();
						// 从服务器获取数据
						GetFromservice(userNameValue, passwordValue);
						LogUtils.d("GetFromservice");
					}
				}
			});
		}
		else {	//没网的入口	
				LogUtils.d("NoNetWorkHelper");
			    btn_login.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					if(TextUtils.isEmpty(userName.getText())||TextUtils.isEmpty(password.getText()))
					{
						Toast.makeText(Main_LoginActivity.this, "账号或密码为空，请输入",
								Toast.LENGTH_LONG).show();
					}else{
						userNameValue = userName.getText().toString();
						passwordValue = password.getText().toString();
						//从数据库里面取出数据，如果没有就是第一次登录
						DbUtils dbUtils=DbUtils.create(Main_LoginActivity.this,"market");
						try {
							Userinfo userinfo=dbUtils.findFirst(Selector.from(Userinfo.class).where("username", "=", userNameValue).and("password", "=", passwordValue));
							if(userinfo!=null)
							{
								userinfo.setIsnetwork(false);
								dbUtils.update(userinfo);
								LogUtils.d(userinfo.getUsername());
								LogUtils.d(userinfo.toString());
								Intent intent = new Intent(Main_LoginActivity.this,
										Main_logoActivity.class);
								startActivity(intent);
								finish();
							}else {
								Toast.makeText(Main_LoginActivity.this, "第一次登录，请联网登录",
										Toast.LENGTH_LONG).show();
							}
							
						} catch (DbException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			
		}

		btnQuit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
				System.exit(0);
			}
		});

	}
	private int GetFromservice(String name, String password) {
		System.out.println("GetFromservice");
		RequestParams params = new RequestParams(); // 绑定参数
		params.put("username", name);
		params.put("password", password);
		MyApplication application= (MyApplication)getApplication();		
		String url=application.getUrl()+"android/login.jsp";		
		HttpUtil.get(url ,params, new JsonHttpResponseHandler() {
					@Override
					public void onSuccess(JSONObject response) {
						System.out.println("success:"+response.toString());
						try {
							resCode = response.getInt("resCode");
							resMsg = response.getString("resMsg");
							userId = response.getInt("userId");
							System.out.println("resCode,resMsg,userId"+resCode+resMsg+userId);
							if (resCode == 0) {
								MyApplication application = (MyApplication)getApplication();
								application.setCurIndex(userId);
								System.out.println(String.valueOf(userId));
								DbUtils db=DbUtils.create(Main_LoginActivity.this,"market");
								Userinfo userinfo = null;
								if(db.findFirst(Userinfo.class) != null)
								{
									userinfo=db.findFirst(Userinfo.class);
									userinfo.setIsnetwork(NetWorkHelper.checkNetState(Main_LoginActivity.this));
									LogUtils.d(String.valueOf(NetWorkHelper.checkNetState(Main_LoginActivity.this)));
									LogUtils.d(String.valueOf(userinfo.isIsnetwork()));
									userinfo.setUsername(userNameValue);
									userinfo.setPassword(passwordValue);
									userinfo.setUserId(userId);
									userinfo.setId(1);
									db.update(userinfo);
								}else {
									userinfo=new Userinfo();
									userinfo.setIsnetwork(NetWorkHelper.checkNetState(Main_LoginActivity.this));
									LogUtils.d(String.valueOf(NetWorkHelper.checkNetState(Main_LoginActivity.this)));
									LogUtils.d(String.valueOf(userinfo.isIsnetwork()));
									userinfo.setUsername(userNameValue);
									userinfo.setPassword(passwordValue);
									userinfo.setUserId(userId);
									userinfo.setId(1);
									db.save(userinfo);
								}
								
								
								//db.update(userinfo, whereBuilder, updateColumnNames)
								LogUtils.d(db.toString()+userinfo.toString());
								// 跳转界面
								Intent intent = new Intent(Main_LoginActivity.this,
										Main_logoActivity.class);
								Main_LoginActivity.this.startActivity(intent);
								finish();
							}else {
								Toast.makeText(Main_LoginActivity.this, "用户名或密码错误，请重新登录",
										Toast.LENGTH_LONG).show();
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("Error:" + e.toString());
							resCode = -1;							
							Toast.makeText(Main_LoginActivity.this, "用户名或密码错误，请重新登录",
									Toast.LENGTH_LONG).show();
						}
					}

					@Override
					public void onFailure(Throwable rThrowable) {
						System.out.println(rThrowable);
						Toast.makeText(Main_LoginActivity.this, "登陆失败，请重新登录",
								Toast.LENGTH_LONG).show();
					}
				});
		System.out.println("resCode:" + resCode);
		return resCode;
	}
	private void isUpdate(String string)
	{
		 String urlString=string+"android/checkUpdate.jsp";
		 RequestParams qParams=new RequestParams();
		 String pkName = this.getPackageName();
		 String versionName = null;
		 try {
			versionName = this.getPackageManager().getPackageInfo(
			 	pkName, 0).versionName;
		 } catch (NameNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		 }
		 qParams.put("packageVersion", versionName);
		 Log.d("packageVersion", versionName);
		 HttpUtil.get(urlString,qParams, new JsonHttpResponseHandler() {
			
			@Override
			public void onSuccess(JSONObject response)  {
				// TODO Auto-generated method stub
				Log.d("download",response.toString());
                	try {
                		if(response.getInt("resCode")==0&&response.getBoolean("isUpdate"))
                		{
                			Log.d("isUpdate","要重新安装");
                			Download_and_update(response.getString("downloadUrl"));
                		}
                		else{
                			Log.d("download",response.getString("resMsg"));
                		}
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	//Toast.makeText(getApplicationContext(), "上传成功", Toast.LENGTH_SHORT).show();
               
                Log.d(getApplication().toString(), response.toString());
			}
	        });
	}
	private void Download_and_update(String url)
	{	
		pDialog = ProgressDialog.show(this, "请稍等", "更新中"); 
    	Log.d("Download_and_update", url);
    	pDialog.setCanceledOnTouchOutside(true);// 设置在点击Dialog外是否取消Dialog进度条
    	HttpUtil.get(url,new FileAsyncHttpResponseHandler(this) {  
    	    @Override  
    	    public void onSuccess(int statusCode, Header[] headers, File file) {  
    	        // Do something with the file `response`  
				// TODO Auto-generated method stub
				pDialog.dismiss();	
		    	try
		    	{   
		    		String filename=rootPath+File.separator+"MarketUpdate.apk";
		    		Log.d("filename", filename);
		    		File f = new File(filename);
		    		byte[] buffer = new byte[1024];
		    		int len = 0;
		    		FileInputStream inputStream = new FileInputStream(file);
			    	FileOutputStream ostFileOutputStream= new FileOutputStream(f);
			    	while((len = inputStream.read(buffer)) != -1)
			    	{
			    		ostFileOutputStream.write(buffer, 0, len);
			    	}
			    	ostFileOutputStream.flush();
			    	ostFileOutputStream.close();
			    	inputStream.close();
			    	openFile(f);
					Toast.makeText(Main_LoginActivity.this, "下载成功", Toast.LENGTH_SHORT).show();
			    }catch (Exception e){
		    		Toast.makeText(Main_LoginActivity.this, "下载失败", Toast.LENGTH_SHORT).show();
			    }
    	    }
    	});

	}
	private void openFile(File file) {
        // TODO Auto-generated method stub
        Log.e("OpenFile", file.getName());
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),
                        "application/vnd.android.package-archive");
        startActivity(intent);
}
	private void GetMessage()
	{
		String urlString="http://www.zjjd12315.cn/zjjdmarket/android/getBaseUrl.jsp";
		HttpUtil.get(urlString, new JsonHttpResponseHandler()
		{
			public void onSuccess(JSONObject response)  {
				// TODO Auto-generated method stub
					String urlString="http://www.zjjd12315.cn/zjjdmarket/";
				try {
					if(response.getInt("resCode")==0&&!TextUtils.isEmpty(response.getString("baseUrl")))
					{
					Log.d("isBaseurl", response.toString());
					urlString=response.getString("baseUrl");
					isUpdate(response.getString("baseUrl"));		
					}
					MyApplication application = (MyApplication)getApplication();
					application.setUrl(urlString);
				} catch (Exception e) {
					// TODO: handle exception
				}				
			}
			public void onFailure(Throwable throwable) {
				// TODO Auto-generated method stub
				String urlString="http://www.zjjd12315.cn/zjjdmarket/";
				MyApplication application = (MyApplication)getApplication();
				application.setUrl(urlString);
			}
			
		});
		
 	}
}