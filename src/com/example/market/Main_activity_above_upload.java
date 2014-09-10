package com.example.market;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.market.activity.BaseActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


@SuppressLint("SdCardPath")
public class Main_activity_above_upload  extends BaseActivity{	
    private List<String> items = null;  
    private List<String> paths = null;  
    private String rootPath = "/storage/sdcard0/Pictures/MyMarketApp";
    private TextView textView =null;
    public void onCreate(Bundle icicle) {  
        super.onCreate(icicle);  
        setContentView(R.layout.main_activity_above_upload);  
        items = new ArrayList<String>();  
        paths = new ArrayList<String>();
        final ListView listView=(ListView)findViewById(R.id.main_activtiy_above_upload_listview);
        textView=(TextView)findViewById(R.id.textview2);
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
            	textView.setText("你选择的文件："+items.get(arg2)+";路径:"+paths.get(arg2));            
            }  
        }); 
} 
}