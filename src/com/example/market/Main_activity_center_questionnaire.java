package com.example.market;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

import com.example.market.activity.BaseActivity;
import com.example.market.activity.MyApplication;
import com.example.market.db.question;
import com.example.market.dialog.Effectstype;
import com.example.market.dialog.NiftyDialogBuilder;
import com.example.market.utils.Questionnaire;
import com.example.market.web.HttpUtil;
import com.google.gson.Gson;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.util.LogUtils;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main_activity_center_questionnaire extends BaseActivity
{	
	private String name,number;
	private NiftyDialogBuilder niftyDialogBuilder;
	private RadioGroup radioGroup1_1,radioGroup1_2,radioGroup1_3,radioGroup1_4,radioGroup1_5,
	radioGroup1_6,radioGroup1_7,radioGroup1_8,radioGroup2_1,radioGroup2_2,radioGroup2_3,
	radioGroup2_4,radioGroup2_5,radioGroup2_6,radioGroup3_1,radioGroup3_2,radioGroup3_3,
	radioGroup3_4,radioGroup3_5,radioGroup4_1,radioGroup4_2,radioGroup4_3;
	private EditText editText1_1,editText1_2, editText1_3, editText1_4, editText1_5, editText1_6, 
	editText1_7, editText1_8, editText2_1, editText2_2, editText2_3, editText2_4, editText2_5, 
	editText2_6, editText3_1, editText3_2, editText3_3, editText3_4, editText3_5, editText4_1, 
	editText4_2,editText4_3,editTextname,editTextunit;
	private RadioButton radioButton1,radioButton2,radioButton3,radioButton4,radioButton5,radioButton6,
	radioButton7,radioButton8,radioButton21,radioButton22,radioButton23,radioButton24,radioButton25,
	radioButton26,radioButton31,radioButton32,radioButton33,radioButton34,radioButton35,radioButton41,
	radioButton42,radioButton43;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_center_questionnaire);
		Intent intent=this.getIntent();
		Bundle bundle=intent.getExtras();
		name=bundle.getString("name");
		number=bundle.getString("number");
		init();
		Button buttonupload=(Button)findViewById(R.id.main_activity_center_questionnaireupload);
		Button buttonreturn =(Button)findViewById(R.id.main_activity_center_questionnairereturn);
		buttonreturn.setText("保存");
		buttonreturn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				baocun();
			}
		});
		buttonupload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				shangchuang();
			}
		});//上传按钮怎么上传？		
	}
	public void init()
	{
		radioGroup1_1=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup1);
		editText1_1= (EditText)findViewById(R.id.main_activity_center_1radiogroup1_edit);
		 radioButton1=(RadioButton)findViewById(radioGroup1_1.getCheckedRadioButtonId());
    	radioGroup1_2=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup2);
		editText1_2= (EditText)findViewById(R.id.main_activity_center_1radiogroup2_edit);
	     radioButton2=(RadioButton)findViewById(radioGroup1_2.getCheckedRadioButtonId());
    	radioGroup1_3=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup3);
    	 radioButton3=(RadioButton)findViewById(radioGroup1_3.getCheckedRadioButtonId());
    	editText1_3= (EditText)findViewById(R.id.main_activity_center_1radiogroup3_edit);
    	radioGroup1_4=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup4);
    	editText1_4= (EditText)findViewById(R.id.main_activity_center_1radiogroup4_edit);
		 radioButton4=(RadioButton)findViewById(radioGroup1_4.getCheckedRadioButtonId());
		radioGroup1_5=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup5);
		editText1_5= (EditText)findViewById(R.id.main_activity_center_1radiogroup5_edit);
	     radioButton5=(RadioButton)findViewById(radioGroup1_5.getCheckedRadioButtonId());
		radioGroup1_6=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup6);
		editText1_6= (EditText)findViewById(R.id.main_activity_center_1radiogroup6_edit);
		 radioButton6=(RadioButton)findViewById(radioGroup1_6.getCheckedRadioButtonId());
		radioGroup1_7=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup7);
		editText1_7= (EditText)findViewById(R.id.main_activity_center_1radiogroup7_edit);
		 radioButton7=(RadioButton)findViewById(radioGroup1_7.getCheckedRadioButtonId());
		radioGroup1_8=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup8);
		editText1_8= (EditText)findViewById(R.id.main_activity_center_1radiogroup8_edit);
		 radioButton8=(RadioButton)findViewById(radioGroup1_8.getCheckedRadioButtonId());
		radioGroup2_1=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup1);
		editText2_1= (EditText)findViewById(R.id.main_activity_center_2radiogroup1_edit);
		 radioButton21=(RadioButton)findViewById(radioGroup2_1.getCheckedRadioButtonId());
		  radioGroup2_2=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup2);
		  editText2_2= (EditText)findViewById(R.id.main_activity_center_2radiogroup2_edit);
		   radioButton22=(RadioButton)findViewById(radioGroup2_2.getCheckedRadioButtonId());
		  radioGroup2_3=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup3);
		  editText2_3= (EditText)findViewById(R.id.main_activity_center_2radiogroup3_edit);
		   radioButton23=(RadioButton)findViewById(radioGroup2_3.getCheckedRadioButtonId());
		  radioGroup2_4=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup4);
		  editText2_4= (EditText)findViewById(R.id.main_activity_center_2radiogroup4_edit);
		  radioGroup2_5=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup5);
		  radioButton24=(RadioButton)findViewById(radioGroup2_4.getCheckedRadioButtonId());
		  editText2_5= (EditText)findViewById(R.id.main_activity_center_2radiogroup5_edit);
		   radioButton25=(RadioButton)findViewById(radioGroup2_5.getCheckedRadioButtonId());
		  radioGroup2_6=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup6);
		  editText2_6= (EditText)findViewById(R.id.main_activity_center_2radiogroup6_edit);
		   radioButton26=(RadioButton)findViewById(radioGroup2_6.getCheckedRadioButtonId());
		  radioGroup3_1=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup1);
		  editText3_1= (EditText)findViewById(R.id.main_activity_center_3radiogroup1_edit);
		   radioButton31=(RadioButton)findViewById(radioGroup3_1.getCheckedRadioButtonId());
		  radioGroup3_2=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup2);
		  editText3_2= (EditText)findViewById(R.id.main_activity_center_3radiogroup2_edit);
		   radioButton32=(RadioButton)findViewById(radioGroup3_2.getCheckedRadioButtonId());
		  radioGroup3_3=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup3);
		  editText3_3= (EditText)findViewById(R.id.main_activity_center_3radiogroup3_edit);
		   radioButton33=(RadioButton)findViewById(radioGroup3_3.getCheckedRadioButtonId());
		  radioGroup3_4=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup4);
		  editText3_4= (EditText)findViewById(R.id.main_activity_center_3radiogroup4_edit);
		   radioButton34=(RadioButton)findViewById(radioGroup3_4.getCheckedRadioButtonId());
		  radioGroup3_5=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup5);
		  editText3_5= (EditText)findViewById(R.id.main_activity_center_3radiogroup5_edit);
		   radioButton35=(RadioButton)findViewById(radioGroup3_5.getCheckedRadioButtonId());
		  radioGroup4_1=(RadioGroup)findViewById(R.id.main_activity_center_4radiogroup1);
		  editText4_1= (EditText)findViewById(R.id.main_activity_center_4radiogroup1_edit);
		   radioButton41=(RadioButton)findViewById(radioGroup4_1.getCheckedRadioButtonId());				
		  radioGroup4_2=(RadioGroup)findViewById(R.id.main_activity_center_4radiogroup2);
		  editText4_2= (EditText)findViewById(R.id.main_activity_center_4radiogroup2_edit);
		   radioButton42=(RadioButton)findViewById(radioGroup4_2.getCheckedRadioButtonId());
		  radioGroup4_3=(RadioGroup)findViewById(R.id.main_activity_center_4radiogroup3);
		  editText4_3=(EditText)findViewById(R.id.main_activity_center_4radiogroup3_edit);
		  radioButton43=(RadioButton)findViewById(radioGroup4_3.getCheckedRadioButtonId());
		  editTextname=(EditText)findViewById(R.id.main_activity_center_questionnairename);
		  editTextunit=(EditText)findViewById(R.id.main_activity_center_questionnaireunit);
		  Log.d("radio", "radioGroup1_1");
		}
	private void shangchuang()
	{
		if(!TextUtils.isEmpty(editTextname.getText())&&!TextUtils.isEmpty(editTextunit.getText()))
		{
			Log.d("onClick", "onClick");
			Effectstype effectstype=Effectstype.Slidetop;
			niftyDialogBuilder=NiftyDialogBuilder.getInstance(this);
			niftyDialogBuilder.withTitle("确认上传吗？")
								.withIcon(R.drawable.index_c)
								.withMessage(null)
								.withEffect(effectstype)
								.withNoEdit()
								.withButton1Text("上传")
								.withButton2Text("取消")
								.setButton1Click(new View.OnClickListener() {
									
									@Override
									public void onClick(View v) {
										// TODO Auto-generated method stub
										niftyDialogBuilder.dismiss();
										postToService();
										niftyDialogBuilder.dismiss();
									}
								})
								.setButton2Click(new View.OnClickListener() {
									
									@Override
									public void onClick(View v) {
										// TODO Auto-generated method stub
										niftyDialogBuilder.dismiss();
									}
								})
								.show();
		}			
	}
	private void postToService()
	{
		MyApplication application = (MyApplication)getApplication();
		int userId=application.getCurIndex();
		Log.d("userId",String.valueOf(userId));
		String url=application.getUrl()+"android/addRecord.jsp";
		Log.d("userId",String.valueOf(userId)+url);
		RequestParams params = new RequestParams(); // 绑定参数		
		String contont =initDate(userId);
		params.put("content", contont);
		Log.d("content", contont);
		params.put("userId",String.valueOf(userId));
		HttpUtil.post(url,params, new JsonHttpResponseHandler() {
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
						// 跳转界面
						Toast.makeText(Main_activity_center_questionnaire.this, "上传成功，返回主界面",
								Toast.LENGTH_LONG).show();
						
					}else {
						Log.d("resMsg", resMsg);
						Toast.makeText(Main_activity_center_questionnaire.this, "上传失败"+resMsg,
								Toast.LENGTH_LONG).show();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Error:" + e.toString());
					resCode = -1;							
					Toast.makeText(Main_activity_center_questionnaire.this, "上传失败",
							Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void onFailure(Throwable rThrowable) {
				System.out.println(rThrowable);
			}
		});
	}
	
	private String initDate(int userId)
	{
		Questionnaire questionnaire=new Questionnaire();
		questionnaire.setUserId(userId);
		questionnaire.setCompanyName(name);
		questionnaire.setCompanyNo(number);
		questionnaire.setPerson(editTextname.getText().toString());
		questionnaire.setUnit(editTextunit.getText().toString());
		questionnaire.setZgCertFlag(judge(radioButton1.getText().toString()));
		questionnaire.setZgCertDetail(editText1_1.getText().toString());
		questionnaire.setZgBusinessFlag(judge(radioButton2.getText().toString()));
		questionnaire.setZgBusinessDetail(editText1_2.getText().toString());
		questionnaire.setZgNameFlag(judge(radioButton3.getText().toString()));
		questionnaire.setZgNameDetail(editText1_3.getText().toString());
		questionnaire.setZgCertMissFlag(judge(radioButton4.getText().toString()));
		questionnaire.setZgCertMissDetail( editText1_4.getText().toString());				   
		questionnaire.setZgNianJianFlag(judge(radioButton5.getText().toString()));
		questionnaire.setZgNianJianDetail(editText1_5.getText().toString());
	    questionnaire.setZgQiXianFlag(judge(radioButton6.getText().toString()));
	    questionnaire.setZgQiXianDetail(editText1_6.getText().toString());
	    questionnaire.setZgBianGengFlag(judge(radioButton7.getText().toString()));
	    questionnaire.setZgBianGengDetail(editText1_7.getText().toString());
	   questionnaire.setZgXuBaoFlag(judge(radioButton8.getText().toString()));
	   questionnaire.setZgXuBaoDetail(editText1_8.getText().toString());
	   questionnaire.setXwShenPiFlag(judge(radioButton21.getText().toString()));
	   questionnaire.setXwShenPiDetail(editText2_1.getText().toString());
				   
	   questionnaire.setXwHeZhunFlag(judge(radioButton22.getText().toString()));
	   questionnaire.setXwHeZhunDetail(editText2_2.getText().toString());
					 
	   questionnaire.setXwShangBiaoFlag(judge(radioButton23.getText().toString()));
	   questionnaire.setXwShangBiaoDetail(editText2_3.getText().toString());
					
	   questionnaire.setXwQinQuanFlag(judge(radioButton24.getText().toString()));
	   questionnaire.setXwQinQuanDetail(editText2_4.getText().toString());
					  
	   questionnaire.setXwWeiZhaoFlag(judge(radioButton25.getText().toString()));
	   questionnaire.setXwWeiZhaoDetail(editText2_5.getText().toString());
					   
	   questionnaire.setXwWeiZhaoFlag(judge(radioButton26.getText().toString()));
	   questionnaire.setXwWeiZhaoDetail(editText2_6.getText().toString());
					   
	   questionnaire.setLxShangPinFlag(judge(radioButton31.getText().toString()));
	   questionnaire.setLxShangPinDetail(editText3_1.getText().toString());
					 
	   questionnaire.setLxJinHuoFlag(judge(radioButton32.getText().toString()));
	   questionnaire.setLxJinHuoDetail(editText3_2.getText().toString());
					  
	   questionnaire.setLxChaYanFlag(judge(radioButton33.getText().toString()));
	   questionnaire.setLxChaYanDetail(editText3_3.getText().toString());
					  
	   questionnaire.setLxPinZhengFlag(judge(radioButton34.getText().toString()));
	   questionnaire.setLxPinZhengDetail(editText3_4.getText().toString());
					  
	   questionnaire.setLxGuanLiFeiFlag(judge(radioButton35.getText().toString()));
	   questionnaire.setLxGuanLiFeiDetail(editText3_5.getText().toString());
					  
	   questionnaire.setGlZhiZeFlag(judge(radioButton41.getText().toString()));
	   questionnaire.setGlZhiZeDetail(editText4_1.getText().toString());
				
	   questionnaire.setGlLuoShiFlag(judge(radioButton42.getText().toString()));
	   questionnaire.setGlLuoShiDetail(editText4_2.getText().toString());
					 
	   questionnaire.setGlShouXuFlag(judge(radioButton43.getText().toString()));
       questionnaire.setGlShouXuDetail(editText4_3.getText().toString());
	   questionnaire.setId(userId);			   
	   Gson gson=new Gson();			   
	   String contont=gson.toJson(questionnaire);	   
	   return contont;
	}
	
	private boolean judge(String string)
	{
	    	 if(string.endsWith("是"))
	    	{
	    		return true;
	    	}
	    	else {
				return false;
			}
	 }
	 private void baocun()
	 {
		MyApplication application = (MyApplication)getApplication();
		int userId=application.getCurIndex();
		Log.d("userId",String.valueOf(userId));
		String content =initDate(userId);
		DbUtils dbUtils=DbUtils.create(this,"market");
		question question1=new question();
		question1.setUserId(userId);
		question1.setName(name);
		question1.setNumber(number);
		question1.setContent(content);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-D");
		String date=sdf.format(new java.util.Date());
		LogUtils.d(name+number+content+date);
		question1.setTime(date);
		try {
			dbUtils.saveBindingId(question1);
			Toast.makeText(this, "保存成功", Toast.LENGTH_LONG);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this, "保存失败", Toast.LENGTH_LONG);
		}
	 }
}