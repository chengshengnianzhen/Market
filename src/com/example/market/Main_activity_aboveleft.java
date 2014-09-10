package com.example.market;

import org.apache.http.impl.client.TunnelRefusedException;

import com.example.market.activity.BaseActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Main_activity_aboveleft extends BaseActivity
{
	ActionBar actionBar;
	private boolean ture;
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_activity_aboveleft);
		
		actionBar =getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.show();	
		setTitle("��Ϣ��ѯ");
		ImageButton imageButton=(ImageButton)findViewById(R.id.main_activity_aboveleft_findbotton);//��ѯ��ť
		final EditText editText=(EditText)findViewById(R.id.main_activity_aboveleft_findedit);
		imageButton.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(editText.getText().toString().length()==0)
				{
					editText.setHint("������");//�ж��Ƿ�Ϊ��
				}
				else {
					Intent intent=new Intent(Main_activity_aboveleft.this,Main_activity_aboveleft_result.class);
					intent.putExtra("name", editText.getText().toString());//��������Ҫ��ѯ������
					startActivity(intent);
				}
			}
		});
				
	}
	 public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        super.onCreateOptionsMenu(menu);
	        MenuInflater inflater = getMenuInflater();  
	        inflater.inflate(R.menu.erwei, menu);          
	        return true;
	    }
	  public boolean onOptionsItemSelected(MenuItem item) {  
	        switch (item.getItemId()) {  
	        case android.R.id.home:  
	            // ��ActionBarͼ�걻���ʱ����  
	        	// TODO Auto-generated method stub
				Intent intent=new Intent(this,Main_activity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				finish();
				return true;
	        case R.id.menu_erwei:
	        	Intent intent1=new Intent(Main_activity_aboveleft.this,Main_activity_aboveleft_qr.class);
				startActivity(intent1);//�����ά���ҳ��
				return ture;
			default:
				return super.onOptionsItemSelected(item);
	        }  
	    } 
}