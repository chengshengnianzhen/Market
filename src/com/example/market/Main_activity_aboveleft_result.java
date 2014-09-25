package com.example.market;

import com.example.market.activity.BaseActivity;
import com.example.market.utils.Company;
import android.os.Bundle;
import android.widget.TextView;
import com.google.gson.Gson;

public class  Main_activity_aboveleft_result extends BaseActivity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_aboveleft_result);
		Bundle extras = getIntent().getExtras();
		String message=extras.getString("message");//得到要查询的数据
		Gson gson=new Gson();
		Company company = gson.fromJson(message, Company.class);
		//然后从网上获取要得到的各种数据显示出来。
		TextView textView=(TextView)findViewById(R.id.main_activity_aboveleft_result);		
		TextView textView1=(TextView)findViewById(R.id.main_activity_aboveleft_result_name);		
		TextView textView2=(TextView)findViewById(R.id.main_activity_aboveleft_result_number);
		TextView textView3=(TextView)findViewById(R.id.main_activity_aboveleft_result_type);		
		TextView textView4=(TextView)findViewById(R.id.main_activity_aboveleft_result_people);		
		TextView textView5=(TextView)findViewById(R.id.main_activity_aboveleft_result_address);		
		TextView textView6=(TextView)findViewById(R.id.main_activity_aboveleft_result_scope);		
		TextView textView7=(TextView)findViewById(R.id.main_activity_aboveleft_result_gear);		
		TextView textView8=(TextView)findViewById(R.id.main_activity_aboveleft_result_issuedate);		
		TextView textView9=(TextView)findViewById(R.id.main_activity_aboveleft_result_builddate);		
		TextView textView10=(TextView)findViewById(R.id.main_activity_aboveleft_result_status);
		textView.setText(company.getName());
		textView1.setText(company.getName());
		textView2.setText(company.getNumber());
		textView3.setText(company.getType());			
		textView4.setText(company.getOwner());
		textView5.setText(company.getAddress());
		textView6.setText(company.getScope());
		textView7.setText(company.getGear());
		textView8.setText(company.getIssueDate());
		textView9.setText(company.getBuildDate());
		textView10.setText(company.getType());
		}
	}