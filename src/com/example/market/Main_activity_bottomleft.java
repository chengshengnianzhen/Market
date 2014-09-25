package com.example.market;

import org.json.JSONObject;

import com.example.market.activity.BaseActivity;
import com.example.market.activity.MyApplication;
import com.example.market.web.HttpUtil;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Main_activity_bottomleft extends BaseActivity{
	private EditText editTextname;
	private EditText editTextnumber;
	private Spinner mSpinner;
	private EditText editTextbody;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_bottomleft);
		setTitle("Υ��̶�");
		Log.d("Υ��̶�", "Υ��̶�");
		
		editTextname=(EditText)findViewById(R.id.main_activity_bottomleft_name);
		editTextnumber=(EditText)findViewById(R.id.main_activity_bottomleft_number);
		mSpinner=(Spinner)findViewById(R.id.main_activity_bottomleft_spinner);
		editTextbody=(EditText)findViewById(R.id.main_activity_bottomleft_body);
		//String[] cspinner={"һ��","����","����"};
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
		Log.d("adapter", "adapter");
		Button buttonupload= (Button)findViewById(R.id.main_activity_bottomleft_upload);
		buttonupload.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!TextUtils.isEmpty(editTextname.getText())&&!TextUtils.isEmpty(editTextnumber.getText())&&!TextUtils.isEmpty(editTextbody.getText()))
				{
					Log.d("onClick", "onClick");
					AlertDialog.Builder builder = new Builder(Main_activity_bottomleft.this);
					builder.setTitle("��ʾ");
					builder.setMessage("ȷ���ϴ���");
					Log.d("builder", "builder");
					builder.setNegativeButton("ȡ��",new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}	
					});
					builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.dismiss();
							postToService();
						}
					});
					builder.create().show();
				}			
			}
		});
	}
	private void postToService() {
		// TODO Auto-generated method stub
		//s1.getSelectedItem()).toString()
		MyApplication application = (MyApplication)getApplication();
		int userId=application.getCurIndex();
		Log.d("userId",String.valueOf(userId));
		RequestParams params = new RequestParams(); // �󶨲���
		params.put("CompanyName", editTextname.getText().toString());
		params.put("CompanyNumber", editTextnumber.getText().toString());
		params.put("CompanyRank", String.valueOf(mSpinner.getSelectedItemPosition()+1));
		params.put("userId",String.valueOf(userId));
		params.put("CompanyContent",editTextbody.getText().toString());
		String url=application.getUrl()+"android/addPunishItem.jsp";
		Log.d("userId+name",String.valueOf(mSpinner.getSelectedItemPosition()+1)+String.valueOf(userId));
		HttpUtil.get(url ,params, new JsonHttpResponseHandler() {
					@Override
					public void onSuccess(JSONObject response) {
						int resCode = -1;
						String resMsg;
						System.out.println("success:"+response.toString());
						try {
							
							resCode= response.getInt("resCode");
							resMsg = response.getString("resMsg");
							if (resCode == 0) {
								System.out.println("end");
								// ��ת����
								Toast.makeText(Main_activity_bottomleft.this, "�ϴ��ɹ�������������",
										Toast.LENGTH_LONG).show();
								Intent intent =new Intent(Main_activity_bottomleft.this,Main_activity.class);
								startActivity(intent);
								finish();
							}else {
								Toast.makeText(Main_activity_bottomleft.this, "�ϴ�ʧ��"+resMsg,
										Toast.LENGTH_LONG).show();
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("Error:" + e.toString());
							resCode = -1;							
							Toast.makeText(Main_activity_bottomleft.this, "�ϴ�ʧ��",
									Toast.LENGTH_LONG).show();
						}
					}

					@Override
					public void onFailure(Throwable rThrowable) {
						System.out.println(rThrowable);
					}
				});
	}
	
}
