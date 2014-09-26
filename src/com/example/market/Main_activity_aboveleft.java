package com.example.market;

import com.example.market.activity.BaseActivity;
import com.example.market.db.Userinfo;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.util.LogUtils;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Main_activity_aboveleft extends BaseActivity
{
	ActionBar actionBar;
	private boolean ture;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.main_activity_aboveleft);		
		actionBar =getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.show();	
		setTitle("信息查询");
		ImageButton imageButton=(ImageButton)findViewById(R.id.main_activity_aboveleft_findbotton);//查询按钮
		final EditText editText=(EditText)findViewById(R.id.main_activity_aboveleft_findedit);
		imageButton.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DbUtils dbUtil=DbUtils.create(Main_activity_aboveleft.this,"market");
		    	Userinfo userinfo = null;
				try {
					userinfo = dbUtil.findFirst(Userinfo.class);
					if (userinfo!=null) {
						LogUtils.d(userinfo.toString());
					}
					else {
						LogUtils.d("null");
					}
				} catch (DbException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LogUtils.d(userinfo.getUsername());
				LogUtils.d(userinfo.getPassword());				
				LogUtils.d(String.valueOf(userinfo.isIsnetwork()));
				if(userinfo.isIsnetwork())
				{
					if(editText.getText().toString().length()==0)
					{
						editText.setHint("请输入");//判断是否为空
					}
					else {
						Intent intent=new Intent(Main_activity_aboveleft.this,Main_activity_aboveleft_list.class);
						intent.putExtra("company", editText.getText().toString());
						startActivity(intent);
					}
				}else {
					Toast.makeText(Main_activity_aboveleft.this,"登录时没有联网，请重新登录" ,Toast.LENGTH_LONG ).show();
				}
				
			}
		});				
	}
	 public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        super.onCreateOptionsMenu(menu);
	        MenuInflater inflater = getMenuInflater();  
	        inflater.inflate(R.menu.er, menu);          
	        return true;
	    }
	  public boolean onOptionsItemSelected(MenuItem item) {  
	        switch (item.getItemId()) {  
	        case android.R.id.home:  
	            // 当ActionBar图标被点击时调用  
	        	// TODO Auto-generated method stub
				Intent intent=new Intent(this,Main_activity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				finish();
				return true;
	        case R.id.menu_erwei:
				DbUtils dbUtil=DbUtils.create(Main_activity_aboveleft.this,"market");
		    	Userinfo userinfo = null;
				try {
					userinfo = dbUtil.findById(Userinfo.class, 1);
					if (userinfo!=null) {
						LogUtils.d(userinfo.toString());
					}else {
						LogUtils.d("null");
					}
				} catch (DbException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(userinfo.isIsnetwork())
				{
			        Intent intent1=new Intent(Main_activity_aboveleft.this,Main_activity_aboveleft_qr.class);
					startActivity(intent1);//进入二维码的页面
				}else {
					Toast.makeText(Main_activity_aboveleft.this,"登录时没有联网，请重新登录" ,Toast.LENGTH_LONG ).show();
				}
				return true;
			default:
				return super.onOptionsItemSelected(item);
	        }  
	    } 
}