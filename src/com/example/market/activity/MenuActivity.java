package com.example.market.activity;

import org.json.JSONObject;
import com.example.market.Main_LoginActivity;
import com.example.market.db.Userinfo;
import com.example.market.web.HttpUtil;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.util.LogUtils;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends Activity { 

	private int mresCode;
	private String MresMsg;
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        MyApplication application = (MyApplication)getApplication();
        if(application.getCurIndex()==0)
        {
    	   DbUtils dbUtils=DbUtils.create(this);
    	   try {
			Userinfo userinfo=dbUtils.findById(Userinfo.class, 1);
			if(userinfo!=null)
			{
				application.setCurIndex(userinfo.getUserId());
				LogUtils.d(userinfo.toString());
			}
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
        }
    } 
     
    @Override
	public boolean onCreateOptionsMenu(Menu menu) { 
        menu.add(1, Menu.FIRST + 1, 1, "退出").setIcon(android.R.drawable.ic_menu_close_clear_cancel); 
        menu.add(1, Menu.FIRST + 2, 2, "注销").setIcon(android.R.drawable.ic_menu_delete);
        //menu.add(2, Menu.FIRST + 4, 1, "测试").setIcon(android.R.drawable.ic_menu_more);  
        return true; 
    }
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
    	DbUtils dbUtil=DbUtils.create(this);
    	Userinfo userinfo = null;
		try {
			userinfo = dbUtil.findById(Userinfo.class, 1);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        switch (item.getItemId()) {
		case Menu.FIRST+1:
			if(userinfo.isIsnetwork())
			{
					MyApplication application = (MyApplication)getApplication();
					int userId= application.getCurIndex();
					Log.d("userId",String.valueOf(userId));
					String uriString=application.getUrl();
					GetFromservice(userId,uriString);
			}
			else {
					LogUtils.d(String.valueOf(userinfo.isIsnetwork()));
					Intent intent = new Intent(Intent.ACTION_MAIN);			
		        	intent.addCategory(Intent.CATEGORY_HOME);  
		        	startActivity(intent); 
		        	System.exit(0);
			}
			break;
		case Menu.FIRST+2:
			if (userinfo.isIsnetwork()) {
					MyApplication application1 = (MyApplication)getApplication();
					int userId1= application1.getCurIndex();
					Log.d("userId",String.valueOf(userId1));
					String uriString1=application1.getUrl();
			    	GetFromservice1(userId1,uriString1);
			}else {
					LogUtils.d(String.valueOf(userinfo.isIsnetwork()));
					Intent intent1 = new Intent(MenuActivity.this,Main_LoginActivity.class);  
		        	intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
		        	startActivity(intent1);
		        	finish();
			}
		
        	break;
		default:
			break;
		}
        return true; 
    } 
    private int GetFromservice(int userId,String urlString) {
		System.out.println("GetFromservice");
		RequestParams params = new RequestParams(); // 绑定参数
		params.put("userId", String.valueOf(userId));
		String url=urlString+"android/logout.jsp";
		HttpUtil.get(url ,params, new JsonHttpResponseHandler() {
					@Override
					public void onSuccess(JSONObject response) {
						System.out.println("success:"+response.toString());
						try {
							mresCode = response.getInt("resCode");
							MresMsg = response.getString("resMsg");
							System.out.println("resCode,resMsg,userId"+MresMsg+MresMsg);
							if (mresCode == 0) {
								System.out.println("end");
								Intent intent = new Intent(Intent.ACTION_MAIN);			
					        	intent.addCategory(Intent.CATEGORY_HOME);  
					        	startActivity(intent); 
					        	System.exit(0);
							}else {
								Toast.makeText(MenuActivity.this, "退出失败，请返回主界面重新登录",
										Toast.LENGTH_LONG).show();
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("Error:" + e.toString());
							mresCode = -1;							
							Toast.makeText(MenuActivity.this, "退出失败，请返回主界面重新登录",
									Toast.LENGTH_LONG).show();
						}
					}

					@Override
					public void onFailure(Throwable rThrowable) {
						System.out.println(rThrowable);
					}
				});
		System.out.println("resCode:" + mresCode);
		return mresCode;
	}
    private void GetFromservice1(int userId,String uString) {
		System.out.println("GetFromservice");
		RequestParams params = new RequestParams(); // 绑定参数
		params.put("userId", String.valueOf(userId));
		Log.d("userId",String.valueOf(userId));
		String url=uString+"android/logout.jsp";
		HttpUtil.get(url ,params, new JsonHttpResponseHandler() {
					@Override
					public void onSuccess(JSONObject response) {
						System.out.println("success:"+response.toString());
						try {
							mresCode = response.getInt("resCode");
							MresMsg = response.getString("resMsg");
							System.out.println("resCode,resMsg,userId"+mresCode+MresMsg);
							if (mresCode == 0) {
								System.out.println("end");
								// 跳转界面
					        	Intent intent1 = new Intent(MenuActivity.this,Main_LoginActivity.class);  
					        	intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
					        	startActivity(intent1);  
							}else {
								Toast.makeText(MenuActivity.this, "注销失败，请返回主界面重新登录",
										Toast.LENGTH_LONG).show();
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("Error:" + e.toString());
							mresCode = -1;							
							Toast.makeText(MenuActivity.this, "注销失败，请返回主界面重新登录",
									Toast.LENGTH_LONG).show();
						}
					}

					@Override
					public void onFailure(Throwable rThrowable) {
						System.out.println(rThrowable);
					}
				});
	}
}