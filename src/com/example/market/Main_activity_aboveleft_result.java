package com.example.market;

import com.example.market.activity.BaseActivity;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class  Main_activity_aboveleft_result extends BaseActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_aboveleft_result);
		Bundle extras = getIntent().getExtras();
		String name=extras.getString("name");//�õ�Ҫ��ѯ������
		//Ȼ������ϻ�ȡҪ�õ��ĸ���������ʾ������
		TextView textView=(TextView)findViewById(R.id.main_activity_aboveleft_result);
		textView.setText(name);
		TextView textView1=(TextView)findViewById(R.id.main_activity_aboveleft_result_name);
		textView1.setText("��������1");
		TextView textView2=(TextView)findViewById(R.id.main_activity_aboveleft_result_number);
		textView2.setText("��������2");
		TextView textView3=(TextView)findViewById(R.id.main_activity_aboveleft_result_type);
		textView3.setText("��������3");
		TextView textView4=(TextView)findViewById(R.id.main_activity_aboveleft_result_people);
		textView4.setText("��������4");
		TextView textView5=(TextView)findViewById(R.id.main_activity_aboveleft_result_address);
		textView5.setText("��������5");
		TextView textView6=(TextView)findViewById(R.id.main_activity_aboveleft_result_scope);
		textView6.setText("��������6");
		TextView textView7=(TextView)findViewById(R.id.main_activity_aboveleft_result_gear);
		textView7.setText("��������7");
		TextView textView8=(TextView)findViewById(R.id.main_activity_aboveleft_result_issuedate);
		textView8.setText("��������8");
		TextView textView9=(TextView)findViewById(R.id.main_activity_aboveleft_result_builddate);
		textView9.setText("��������9");
		TextView textView10=(TextView)findViewById(R.id.main_activity_aboveleft_result_status);
		textView10.setText("��������10");
	}
}