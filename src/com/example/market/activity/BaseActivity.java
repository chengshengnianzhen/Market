package com.example.market.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.example.market.Main_activity;
import com.example.market.R;

public class BaseActivity extends MenuActivity
{
	ActionBar actionBar;
	public  void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		actionBar =getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_gradient_bg));
		actionBar.show();		
	}
	   public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        super.onCreateOptionsMenu(menu);
	        //��Ӳ˵���	        
	        return true;
	    }
	   public boolean onOptionsItemSelected(MenuItem item) {  
	        switch (item.getItemId()) {  
	        case android.R.id.home:  
	            // ��ActionBarͼ�걻���ʱ����  
	        	// TODO Auto-generated method stub
				Intent intent=new Intent(this,Main_activity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				finish();
	            break;  
	        }  
	        return super.onOptionsItemSelected(item);  
	    }  
	  
}

