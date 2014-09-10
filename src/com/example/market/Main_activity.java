package com.example.market;

import com.example.market.activity.MenuActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

 public class Main_activity extends MenuActivity
{
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_activity);
		init();
	}
	private void init(){
		ImageButton imageButton_aboveleft=(ImageButton)findViewById(R.id.main_activity_aboveleft);
		imageButton_aboveleft.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Main_activity.this,Main_activity_aboveleft.class);
				startActivity(intent);
			}
		});
		ImageButton imageButton_above=(ImageButton)findViewById(R.id.main_activtiy_above);
		imageButton_above.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Main_activity.this,Main_activity_above.class);
				startActivity(intent);
			}
		});
		ImageButton imageButton_aboveright=(ImageButton)findViewById(R.id.main_activity_aboveright);
		imageButton_aboveright.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Main_activity.this,Main_activity_aboveright.class);
				startActivity(intent);
			}
		});
		ImageButton imageButton_centerleft=(ImageButton)findViewById(R.id.main_activity_centerleft);
		imageButton_centerleft.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Main_activity.this,Main_activity_centerleft.class);
				startActivity(intent);
			}
		});
		ImageButton imageButton_center=(ImageButton)findViewById(R.id.main_activity_center);
		imageButton_center.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Main_activity.this,Main_activity_center.class);
				startActivity(intent);
			}
		});
		ImageButton imageButton_centerright=(ImageButton)findViewById(R.id.main_activity_centerright);
		imageButton_centerright.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Main_activity.this,Main_activity_centerright.class);
				startActivity(intent);
			}
		});
		ImageButton imageButton_bottomright=(ImageButton)findViewById(R.id.main_activity_index_c);
		imageButton_bottomright.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Main_activity.this,Main_activity_bottomright.class);
				startActivity(intent);
			}
		});
		ImageButton imageButton_bottom=(ImageButton)findViewById(R.id.main_activity_bottom);
		imageButton_bottom.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Main_activity.this,Main_activity_bottom.class);
				startActivity(intent);
			}
		});
		ImageButton imageButton_bottomleft=(ImageButton)findViewById(R.id.main_activity_bottomleft);
		imageButton_bottomleft.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Main_activity.this,Main_activity_bottomleft.class);
				startActivity(intent);
			}
		});
	}
	private boolean isExit;
    @Override  
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {  
        	
                 exit();  

                 return false;  

             } else {  

                 return super.onKeyDown(keyCode, event);  

             }  
    }  

    public void exit()
    {
    	if(!isExit)
    	{
    		isExit=true;
    		Toast.makeText(getApplicationContext(), "�ٰ�һ���˳�����", Toast.LENGTH_SHORT).show();
    		mHandler.sendEmptyMessageDelayed(0,2000);
 
    	}
    	else {  
    		
    		//sp.edit().putBoolean("AUTO_ISCHECK", false).commit();
    		
            Intent intent = new Intent(Intent.ACTION_MAIN);  

            intent.addCategory(Intent.CATEGORY_HOME);  

            startActivity(intent);  

            System.exit(0);  

        }  
    }


    	Handler mHandler = new Handler(){  

  

        @Override  

        public void handleMessage(Message msg) {  

            // TODO Auto-generated method stub   

            super.handleMessage(msg);  

            isExit = false;  

        }  

  

    };
    public void onResume(){
     super.onResume();
     init();
    }

}
