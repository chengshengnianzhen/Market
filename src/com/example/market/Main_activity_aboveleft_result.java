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
		String name=extras.getString("name");//得到要查询的数据
		//然后从网上获取要得到的各种数据显示出来。
		TextView textView=(TextView)findViewById(R.id.main_activity_aboveleft_result);
		textView.setText(name);
		TextView textView1=(TextView)findViewById(R.id.main_activity_aboveleft_result_name);
		textView1.setText("测试数据1");
		TextView textView2=(TextView)findViewById(R.id.main_activity_aboveleft_result_number);
		textView2.setText("测试数据2");
		TextView textView3=(TextView)findViewById(R.id.main_activity_aboveleft_result_type);
		textView3.setText("测试数据3");
		TextView textView4=(TextView)findViewById(R.id.main_activity_aboveleft_result_people);
		textView4.setText("测试数据4");
		TextView textView5=(TextView)findViewById(R.id.main_activity_aboveleft_result_address);
		textView5.setText("测试数据5");
		TextView textView6=(TextView)findViewById(R.id.main_activity_aboveleft_result_scope);
		textView6.setText("测试数据6");
		TextView textView7=(TextView)findViewById(R.id.main_activity_aboveleft_result_gear);
		textView7.setText("测试数据7");
		TextView textView8=(TextView)findViewById(R.id.main_activity_aboveleft_result_issuedate);
		textView8.setText("测试数据8");
		TextView textView9=(TextView)findViewById(R.id.main_activity_aboveleft_result_builddate);
		textView9.setText("测试数据9");
		TextView textView10=(TextView)findViewById(R.id.main_activity_aboveleft_result_status);
		textView10.setText("测试数据10");
	}
}