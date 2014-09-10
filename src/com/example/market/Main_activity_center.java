package com.example.market;

import com.example.market.R.color;
import com.example.market.R.id;
import com.example.market.activity.BaseActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Main_activity_center extends BaseActivity
{
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_center);
		setTitle("企业巡查");
		final EditText editTextname=(EditText)findViewById(R.id.main_activity_center_name);
		final EditText editTextnumber=(EditText)findViewById(R.id.main_activity_center_numbner);
		Button buttonreutrn=(Button)findViewById(R.id.main_activity_center_return);
		Button buttonstart=(Button)findViewById(R.id.main_activity_center_start);
		buttonreutrn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent =  new Intent(Main_activity_center.this,Main_activity.class);
				startActivity(intent);
				finish();
			}
		});
		buttonstart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(editTextname.getText().toString().length()==0||editTextnumber.getText().toString().length()==0)
				{
					if(editTextname.getText().toString().length()==0)
					{
						editTextname.setHint("请输入企业名称");
						editTextname.setHintTextColor(color.red);
					}
					if(editTextnumber.getText().toString().length()==0)
					{
						editTextnumber.setHint("请输入注册号");
						editTextnumber.setHintTextColor(color.red);
					}
				}
				else {
					Intent intent=new Intent(Main_activity_center.this,Main_activity_center_questionnaire.class);
					intent.putExtra("name", editTextname.getText().toString());
					intent.putExtra("number", editTextnumber.getText().toString());
					startActivity(intent);
					finish();
				}
			}
		});
	}
}