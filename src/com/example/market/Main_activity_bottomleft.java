package com.example.market;

import com.baidu.platform.comapi.map.l;
import com.example.market.R.id;
import com.example.market.activity.BaseActivity;

import android.app.Activity;
import android.content.Intent;
import android.drm.DrmStore.RightsStatus;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main_activity_bottomleft extends BaseActivity{
	private EditText editTextname;
	private EditText editTextnumber;
	private Spinner mSpinner;
	private EditText editTextbody;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_bottomleft);
		setTitle("违规程度");
		editTextname=(EditText)findViewById(R.id.main_activity_bottomleft_name);
		editTextnumber=(EditText)findViewById(R.id.main_activity_bottomleft_number);
		mSpinner=(Spinner)findViewById(R.id.main_activity_bottomleft_spinner);
		editTextbody=(EditText)findViewById(R.id.main_activity_bottomleft_body);
		//String[] cspinner={"一级","二级","三级"};
		Button buttonreturnactivity=(Button)findViewById(R.id.main_activity_bottomleft_return);
		buttonreturnactivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Main_activity_bottomleft.this,Main_activity.class);
				startActivity(intent);
				finish();
			}
		});
		ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(
				this,R.array.countries,android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpinner.setAdapter(adapter);
		Button buttonupload= (Button)findViewById(R.id.main_activity_bottomleft_upload);
		}
}
