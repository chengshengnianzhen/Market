package com.example.market;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.market.activity.BaseActivity;
import com.example.market.activity.MyApplication;
import com.example.market.web.HttpUtil;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


@SuppressLint("SdCardPath")
public class Main_activity_above_upload  extends BaseActivity{	
    private List<String> items = null;  
    private List<String> paths = null;  
	private ProgressDialog pDialog;
    private String rootPath =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/MyMarketApp";
    public void onCreate(Bundle icicle) {  
        super.onCreate(icicle);  
        setContentView(R.layout.main_activity_above_upload);
        items = new ArrayList<String>();  
        paths = new ArrayList<String>();
        final ListView listView=(ListView)findViewById(R.id.main_activtiy_above_upload_listview);
        File f = new File(rootPath);
        
        File[] files = f.listFiles();  
        for (int i = 0; i < files.length; i++) {  
            File file = files[i];  
            items.add(file.getName());  
            paths.add(file.getPath());  
        }  
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));
        listView.setOnItemClickListener(new OnItemClickListener() {  
			@Override 
            public void onItemClick(AdapterView<?> arg0,View arg1, int arg2,  
                    long arg3) {  
				Intent intent=new Intent(Main_activity_above_upload.this,Main_activity_above_upload_photo.class);
				intent.putExtra("jpgname", items.get(arg2));
				startActivity(intent);
            }  
        }); 
    } 
  }