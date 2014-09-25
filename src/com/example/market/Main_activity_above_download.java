package com.example.market;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.market.activity.BaseActivity;
import com.example.market.activity.MyApplication;
import com.example.market.utils.Files;
import com.example.market.web.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


@SuppressLint("SdCardPath")
public class Main_activity_above_download  extends BaseActivity{	
    private List<String> items = null; 
	private ProgressDialog pDialog;
	private String rootPath =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/MyMarketApp";
    private ListView listView;
    private ArrayList<Files> askList = new ArrayList<Files>();
    private TextView textView;
    public void onCreate(Bundle icicle) {  
        super.onCreate(icicle);  
        setContentView(R.layout.main_activity_above_upload);
        items = new ArrayList<String>(); 
        Log.d("items",items.toString());
        listView=(ListView)findViewById(R.id.main_activtiy_above_upload_listview);
        textView =(TextView)findViewById(R.id.main_activity_above_upload_text);
        textView.setText("选择下载文件");
        GetDateFromServive();
        Log.d("GetDateFromServive","GetDateFromServive");
        Log.d("init","init");
      
} 
    public void init(){
    	if(askList.size()!=0)
    	{
    		  for(int i=0;i<askList.size();i++)
    			{
    				items.add(askList.get(i).getName());
    			}
    	    	listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));
    	    	listView.setOnItemClickListener(new OnItemClickListener() {
    				@Override
    				public void onItemClick(AdapterView<?> parent, View view,
    						int position, long id) {
    					// TODO Auto-generated method stub
    					//下载这个数据
    					downloadvedio(position);
    				}
    			});
    	}
    }
    public void GetDateFromServive(){
    	 pDialog = ProgressDialog.show(this, "请稍等", "数据下载中");
    	 pDialog.setCanceledOnTouchOutside(true);// 设置在点击Dialog外是否取消Dialog进度条
		 
		 RequestParams qParams=new RequestParams();
		 MyApplication application = (MyApplication)getApplication();
		 String urlString=application.getUrl()+"android/getFile.jsp";
		 int userId= application.getCurIndex();
		 qParams.put("userId", String.valueOf(userId));
		 HttpUtil.get(urlString,qParams, new JsonHttpResponseHandler() {
			
			@Override
			public void onSuccess(JSONObject response)  {
				// TODO Auto-generated method stub
				pDialog.dismiss();
				Log.d("download",response.toString());
                	try {
                		if(response.getInt("resCode")==0)
                		{
                			creat(response.getJSONArray("files"));
                			Log.d("Files",response.getJSONArray("files").toString());
                			
                		}
                		else{
                			Log.d("download",response.getString("resMsg"));
                		}
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}               
                Log.d(getApplication().toString(), response.toString());
			}
	        });
    }
    public void creat(JSONArray jsonArray)
    {
    	Log.d("jsonArray",jsonArray.toString());
    	GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = builder.create();
		Type type = new TypeToken<ArrayList<Files>>() {
		}.getType();
		ArrayList<Files> list = gson.fromJson(jsonArray.toString(), type);
		askList.addAll(list);
	    for(int i=0;i<askList.size();i++)
		{
			items.add(askList.get(i).getName());
		}
	    	listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));
	    	listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					//下载这个数据
					downloadvedio(position);
				}
			});
    }
    public void downloadvedio(final int postion) 
    {    	
    	pDialog = ProgressDialog.show(this, "请稍等", "数据下载中");
    	pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);// 设置水平进度条  
    	pDialog.setCanceledOnTouchOutside(true);// 设置在点击Dialog外是否取消Dialog进度条
    	MyApplication application = (MyApplication)getApplication();	
    	String url=application.getUrl()+askList.get(postion).getPath()+askList.get(postion).getName();
    	Log.d("url", url);
    	
    	HttpUtil.get(url,new FileAsyncHttpResponseHandler(this) {  
    	    @Override  
    	    public void onSuccess(int statusCode, Header[] headers, File file) {  
    	        // Do something with the file `response`  
				// TODO Auto-generated method stub
				pDialog.dismiss();	
		    	try
		    	{   
		    		String filename=rootPath+File.separator+askList.get(postion).getName();
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
					Toast.makeText(Main_activity_above_download.this, "下载成功", Toast.LENGTH_SHORT).show();
			    }catch (Exception e){
		    		Toast.makeText(Main_activity_above_download.this, "下载失败", Toast.LENGTH_SHORT).show();
			    }
    	    }
    	});
	}
  
}