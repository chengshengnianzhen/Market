package com.example.market;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class Main_activity extends Activity
{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_activity);
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
}
