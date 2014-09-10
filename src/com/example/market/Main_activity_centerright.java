package com.example.market;

import com.example.market.activity.BaseActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class Main_activity_centerright extends BaseActivity
{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_centerright);
		setTitle("Ñ²²é¼ÇÂ¼");
		Button buttonreutrn=(Button)findViewById(R.id.main_activity_centerright_return);
		Button buttonstart=(Button)findViewById(R.id.main_activity_centerright_start);
		buttonreutrn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent =  new Intent(Main_activity_centerright.this,Main_activity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}