package com.example.market;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import ru.truba.touchgallery.GalleryWidget.FilePagerAdapter;
import ru.truba.touchgallery.GalleryWidget.GalleryViewPager;
import ru.truba.touchgallery.GalleryWidget.BasePagerAdapter.OnItemChangeListener;

import com.example.market.activity.BaseActivity;
import com.example.market.activity.MyApplication;
import com.example.market.db.Userinfo;
import com.example.market.web.HttpUtil;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.util.LogUtils;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.JsPromptResult;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


@SuppressLint("SdCardPath")
public class Main_activity_above_upload_photo  extends BaseActivity{	
    private List<String> items = null;  
    private List<String> paths = null;  
	private ProgressDialog pDialog;
	private GalleryViewPager mViewPager;
	private Button upload,ret;
	private int number=0,location=-1,displayjpg;
	private String jpgString;
	private TextView textView;
    private String rootPath =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/MyMarketApp";
    public void onCreate(Bundle icicle) {  
        super.onCreate(icicle);  
        setContentView(R.layout.main_activity_above2);        
        upload=(Button)findViewById(R.id.main_activity_above_upload1);
	    ret=(Button)findViewById(R.id.main_activity_above_return1);
	    textView=(TextView)findViewById(R.id.main_activity_above_name);
	    Bundle bundle=getIntent().getExtras();
	    jpgString=bundle.getString("jpgname");
        items = new ArrayList<String>();  
        paths = new ArrayList<String>();
        File f = new File(rootPath);        
        File[] files = f.listFiles();  
        for (int i = 0; i < files.length; i++) {  
            File file = files[i];
            if(file.getName().endsWith(".jpg")){
            	 items.add(file.getName());  
                 paths.add(file.getPath());
                 number++;
                 if (jpgString.equals(file.getName()))
                 {
					displayjpg=number;
					LogUtils.d(String.valueOf(displayjpg));
                 }
                 LogUtils.d(file.getName()+file.getPath()+String.valueOf(number));
            }           
        } 	
	    FilePagerAdapter pagerAdapter = new FilePagerAdapter(this, paths);
	    pagerAdapter.setOnItemChangeListener(new OnItemChangeListener()
		{
			@Override
			public void onItemChange(int currentPosition)
			{
				location=currentPosition;
				textView.setText(items.get(currentPosition));
				LogUtils.d(items.get(currentPosition)+String.valueOf(location));
			}
		});        
	    mViewPager = (GalleryViewPager)findViewById(R.id.viewer);
	    mViewPager.setOffscreenPageLimit(1);
	    mViewPager.setAdapter(pagerAdapter);
	    mViewPager.setCurrentItem(displayjpg-1);
	    LogUtils.d("mViewPager"+String.valueOf(displayjpg));
	    
	    upload.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DbUtils dbUtil=DbUtils.create(Main_activity_above_upload_photo.this,"market");
		    	Userinfo userinfo = null;
				try {
					userinfo = dbUtil.findById(Userinfo.class, 1);
				} catch (DbException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(userinfo.isIsnetwork())
				{
				putToServive(paths.get(location));
				LogUtils.d("putToServive");
				LogUtils.d(paths.get(location));
				}else {
					Toast.makeText(Main_activity_above_upload_photo.this,"登录时没有联网，请重新登录" ,Toast.LENGTH_LONG ).show();
				}
			}
		});
	    ret.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Main_activity_above_upload_photo.this,Main_activity_above.class);
				startActivity(intent);
				finish();
			}
		});
    }    
    public void putToServive(String fielname){      	 
    	 pDialog = ProgressDialog.show(this, "请稍等", "数据上传中"); 
    	 pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);// 设置水平进度条  
    	 pDialog.setCanceledOnTouchOutside(true);// 设置在点击Dialog外是否取消Dialog进度条     	
		 try {
			 File myFile = new File(fielname);
			 RequestParams qParams=new RequestParams();
			 MyApplication application = (MyApplication)getApplication();
			 int userId= application.getCurIndex();
			 String urlString=application.getUrl()+"android/imageUpload.jsp";
			 qParams.put("userId", String.valueOf(userId));
			 qParams.put("FileName", myFile);
			 Log.d("FileName", myFile.toString());
			 Log.d("String.valueOf(userId)",String.valueOf(userId));
			 Log.d("urlString",urlString);
			 HttpUtil.post(urlString, qParams,new JsonHttpResponseHandler() {				
				@Override
				public void onSuccess(JSONObject response)  {
					// TODO Auto-generated method stub
				    pDialog.dismiss();
				    String resMsg = "";
	                try {
						int resCode=response.getInt("resCode");
						resMsg=response.getString("resMsg");
						Log.d("resCode:resMsg", resMsg);
		                if(resCode==0)
		                {
		                	Toast.makeText(Main_activity_above_upload_photo.this, "上传成功", Toast.LENGTH_SHORT).show();
		                }
		                Log.d(getApplication().toString(), response.toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Toast.makeText(Main_activity_above_upload_photo.this, "上传失败"+resMsg, Toast.LENGTH_SHORT).show();
					}
	                
				}
				public void onFailure(Throwable rThrowable){
					pDialog.dismiss();
					Toast.makeText(Main_activity_above_upload_photo.this, "上传失败", Toast.LENGTH_SHORT).show();
				}
		       });
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
    }
}