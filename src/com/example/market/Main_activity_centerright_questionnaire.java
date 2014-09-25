package com.example.market;
import com.example.market.activity.BaseActivity;

import com.example.market.utils.Questionnaire;
import com.google.gson.Gson;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main_activity_centerright_questionnaire extends BaseActivity
{	
	private LinearLayout layout;
	private Questionnaire questionnaire;
	private RadioGroup radioGroup1_1,radioGroup1_2,radioGroup1_3,radioGroup1_4,radioGroup1_5,
	radioGroup1_6,radioGroup1_7,radioGroup1_8,radioGroup2_1,radioGroup2_2,radioGroup2_3,
	radioGroup2_4,radioGroup2_5,radioGroup2_6,radioGroup3_1,radioGroup3_2,radioGroup3_3,
	radioGroup3_4,radioGroup3_5,radioGroup4_1,radioGroup4_2,radioGroup4_3;
	private EditText editText1_1,editText1_2, editText1_3, editText1_4, editText1_5, editText1_6, 
	editText1_7, editText1_8, editText2_1, editText2_2, editText2_3, editText2_4, editText2_5, 
	editText2_6, editText3_1, editText3_2, editText3_3, editText3_4, editText3_5, editText4_1, 
	editText4_2,editText4_3,editTextname,editTextunit;
	private RadioButton radioButton1_1,radioButton1_2,radioButton2_1,radioButton2_2,radioButton3_1,
	radioButton3_2,radioButton4_1,radioButton4_2,radioButton5_1,radioButton5_2,radioButton9_1,radioButton9_2,
	radioButton7_1,radioButton7_2,radioButton6_1,radioButton6_2,radioButton8_1,radioButton8_2,
	radioButton10_1,radioButton10_2,radioButton11_1,radioButton11_2,radioButton12_1,radioButton12_2,
	radioButton13_1,radioButton13_2,radioButton14_1,radioButton14_2,radioButton15_1,radioButton15_2,
	radioButton16_1,radioButton16_2,radioButton17_1,radioButton17_2,radioButton18_1,radioButton18_2,
	radioButton19_1,radioButton19_2,radioButton20_1,radioButton20_2,radioButton21_1,radioButton21_2,
	radioButton22_1,radioButton22_2,radioButton23_1,radioButton23_2,radioButton24_1,radioButton24_2,
	radioButton25_1,radioButton25_2,radioButton26_1,radioButton26_2,radioButton27_1,radioButton27_2,
	radioButton28_1,radioButton28_2,radioButton29_1,radioButton29_2,radioButton30_1,radioButton30_2,
	radioButton31_1,radioButton31_2,radioButton32_1,radioButton32_2,radioButton33_1,radioButton33_2,
	radioButton34_1,radioButton34_2,radioButton35_1,radioButton35_2,radioButton36_1,radioButton36_2,
	radioButton37_1,radioButton37_2,radioButton38_1,radioButton38_2,radioButton39_1,radioButton39_2,
	radioButton40_1,radioButton40_2,radioButton41_1,radioButton41_2,radioButton42_1,radioButton42_2,radioButton43_1,radioButton43_2;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_center_questionnaire);
		Bundle extras = getIntent().getExtras();
		String message=extras.getString("message");
		Log.d("String", message);//得到要查询的数据
		Gson gson=new Gson();
		questionnaire= gson.fromJson(message, Questionnaire.class);
		Log.d("questionnaire", message);
		layout =(LinearLayout)findViewById(R.id.linearLayout);
		layout.setVisibility(View.GONE);
		init();	
	}
	public void init()
	{
		radioGroup1_1=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup1);
		editText1_1= (EditText)findViewById(R.id.main_activity_center_1radiogroup1_edit);
		 radioButton1_1=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup1_chock1);
		 radioButton1_2=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup1_chock2);
		 if(judge(questionnaire.isZgCertFlag())) radioGroup1_1.check(radioButton1_1.getId());
		 else radioGroup1_1.check(radioButton1_2.getId());
		 editText1_1.setText(questionnaire.getZgCertDetail());
		 Log.d("editText1_1", String.valueOf(radioButton1_1.getId()));
		 radioGroup1_2=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup2);
		editText1_2= (EditText)findViewById(R.id.main_activity_center_1radiogroup2_edit);
		radioButton2_1=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup2_chock1);
		 radioButton2_2=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup2_chock2);
		 if(judge(questionnaire.isZgBusinessFlag())) radioGroup1_2.check(radioButton2_1.getId());
		 else radioGroup1_2.check(radioButton2_2.getId());
		 editText1_2.setText(questionnaire.getZgBusinessDetail());
		 Log.d("editText1_2", String.valueOf(radioButton2_1.getId()));
    	radioGroup1_3=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup3);
    	editText1_3= (EditText)findViewById(R.id.main_activity_center_1radiogroup3_edit);
    	radioButton3_1=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup3_chock1);
		 radioButton3_2=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup3_chock2);
		 if(judge(questionnaire.isZgNameFlag())) radioGroup1_3.check(radioButton3_1.getId());
		 else radioGroup1_3.check(radioButton3_2.getId());
		 editText1_3.setText(questionnaire.getZgNameDetail());
		 Log.d("3", String.valueOf(radioButton2_1.getId()));
    	radioGroup1_4=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup4);
    	editText1_4= (EditText)findViewById(R.id.main_activity_center_1radiogroup4_edit);
    	radioButton4_1=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup4_chock1);
		 radioButton4_2=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup4_chock2);
		 if(judge(questionnaire.isZgCertMissFlag())) radioGroup1_4.check(radioButton4_1.getId());
		 else radioGroup1_4.check(radioButton4_2.getId());
		 editText1_4.setText(questionnaire.getZgCertMissDetail());
		 Log.d("4", String.valueOf(radioButton2_1.getId()));
		 radioGroup1_5=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup5);
		editText1_5= (EditText)findViewById(R.id.main_activity_center_1radiogroup5_edit);
		radioButton5_1=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup5_chock1);
		 radioButton5_2=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup5_chock2);		
		 if(judge(questionnaire.isZgNianJianFlag())) radioGroup1_5.check(radioButton5_1.getId());
		 else radioGroup1_5.check(radioButton5_2.getId());
		 editText1_5.setText(questionnaire.getZgNianJianDetail());
		 Log.d("5", String.valueOf(radioButton2_1.getId()));
		 radioGroup1_6=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup6);
		editText1_6= (EditText)findViewById(R.id.main_activity_center_1radiogroup6_edit);
		radioButton6_1=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup6_chock1);
		 radioButton6_2=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup6_chock2);
		 if(judge(questionnaire.isZgQiXianFlag())) radioGroup1_6.check(radioButton6_1.getId());
		 else radioGroup1_6.check(radioButton6_2.getId());
		 editText1_6.setText(questionnaire.getZgQiXianDetail());
		 Log.d("6", String.valueOf(radioButton2_1.getId()));
		 radioGroup1_7=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup7);
		editText1_7= (EditText)findViewById(R.id.main_activity_center_1radiogroup7_edit);
		radioButton7_1=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup7_chock1);
		 radioButton7_2=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup7_chock2);
		 if(judge(questionnaire.isZgBianGengFlag())) radioGroup1_7.check(radioButton7_1.getId());
		 else radioGroup1_7.check(radioButton7_2.getId());
		 editText1_7.setText(questionnaire.getZgBianGengDetail());
		 Log.d("7", String.valueOf(radioButton2_1.getId()));
		 radioGroup1_8=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup8);
		editText1_8= (EditText)findViewById(R.id.main_activity_center_1radiogroup8_edit);
		radioButton8_1=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup8_chock1);
		 radioButton8_2=(RadioButton)findViewById(R.id.main_activity_center_1radiogroup8_chock2);
		 if(judge(questionnaire.isZgXuBaoFlag())) radioGroup1_8.check(radioButton8_1.getId());
		 else radioGroup1_8.check(radioButton8_2.getId());
		 editText1_8.setText(questionnaire.getZgXuBaoDetail());
		 Log.d("8", String.valueOf(radioButton2_1.getId()));
		 radioGroup2_1=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup1);
		editText2_1= (EditText)findViewById(R.id.main_activity_center_2radiogroup1_edit);
		radioButton21_1=(RadioButton)findViewById(R.id.main_activity_center_2radiogroup1_chock1);
		 radioButton21_2=(RadioButton)findViewById(R.id.main_activity_center_2radiogroup1_chock2);
		 if(judge(questionnaire.isXwShenPiFlag())) radioGroup2_1.check(radioButton21_1.getId());
		 else radioGroup2_1.check(radioButton21_2.getId());
		 editText2_1.setText(questionnaire.getXwShenPiDetail());
		 Log.d("9", String.valueOf(radioButton2_1.getId()));
		 
		 radioGroup2_2=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup2);
		  editText2_2= (EditText)findViewById(R.id.main_activity_center_2radiogroup2_edit);
		  radioButton22_1=(RadioButton)findViewById(R.id.main_activity_center_2radiogroup2_chock1);
			 radioButton22_2=(RadioButton)findViewById(R.id.main_activity_center_2radiogroup2_chock2);
			 if(judge(questionnaire.isXwHeZhunFlag())) radioGroup2_2.check(radioButton22_1.getId());
			 else radioGroup2_2.check(radioButton22_2.getId());
			 editText2_2.setText(questionnaire.getXwHeZhunDetail());
			 Log.d("11", String.valueOf(radioButton2_1.getId()));
			 
			 	 radioGroup2_3=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup3);
		  editText2_3= (EditText)findViewById(R.id.main_activity_center_2radiogroup3_edit);
		  radioButton23_1=(RadioButton)findViewById(R.id.main_activity_center_2radiogroup3_chock1);
			 radioButton23_2=(RadioButton)findViewById(R.id.main_activity_center_2radiogroup3_chock2);
			 if(judge(questionnaire.isXwShangBiaoFlag())) radioGroup2_3.check(radioButton23_1.getId());
			 else radioGroup2_3.check(radioButton23_2.getId());
			 editText2_3.setText(questionnaire.getXwShangBiaoDetail());
			 Log.d("12", String.valueOf(radioButton2_1.getId()));
			 radioGroup2_4=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup4);
		  editText2_4= (EditText)findViewById(R.id.main_activity_center_2radiogroup4_edit);
		  radioButton24_1=(RadioButton)findViewById(R.id.main_activity_center_2radiogroup4_chock1);
			 radioButton24_2=(RadioButton)findViewById(R.id.main_activity_center_2radiogroup4_chock2);
			 if(judge(questionnaire.isXwQinQuanFlag())) radioGroup2_4.check(radioButton24_1.getId());
			 else radioGroup2_4.check(radioButton24_2.getId());
			 editText2_4.setText(questionnaire.getXwQinQuanDetail());
			 Log.d("13", String.valueOf(radioButton2_1.getId()));
			 radioGroup2_5=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup5);
		  editText2_5= (EditText)findViewById(R.id.main_activity_center_2radiogroup5_edit);
		  radioButton25_1=(RadioButton)findViewById(R.id.main_activity_center_2radiogroup5_chock1);
			 radioButton25_2=(RadioButton)findViewById(R.id.main_activity_center_2radiogroup5_chock2);
			 if(judge(questionnaire.isXwWeiZhaoFlag())) radioGroup2_5.check(radioButton25_1.getId());
			 else radioGroup2_5.check(radioButton25_2.getId());
			 editText2_5.setText(questionnaire.getXwWeiZhaoDetail());
			 Log.d("14", String.valueOf(radioButton2_1.getId()));
			 radioGroup2_6=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup6);
		  editText2_6= (EditText)findViewById(R.id.main_activity_center_2radiogroup6_edit);
		  radioButton26_1=(RadioButton)findViewById(R.id.main_activity_center_2radiogroup6_chock1);
			 radioButton26_2=(RadioButton)findViewById(R.id.main_activity_center_2radiogroup6_chock2);
			 if(judge(questionnaire.isXwXuJiaFlag())) radioGroup2_6.check(radioButton26_1.getId());
			 else radioGroup2_6.check(radioButton26_2.getId());
			 editText2_6.setText(questionnaire.getXwXuJiaDetail());
			 Log.d("15", String.valueOf(radioButton2_1.getId()));
			 radioGroup3_1=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup1);
		  editText3_1= (EditText)findViewById(R.id.main_activity_center_3radiogroup1_edit);
		  radioButton31_1=(RadioButton)findViewById(R.id.main_activity_center_3radiogroup1_chock1);
			 radioButton31_2=(RadioButton)findViewById(R.id.main_activity_center_3radiogroup1_chock2);
			 if(judge(questionnaire.isLxShangPinFlag())) radioGroup3_1.check(radioButton31_1.getId());
			 else radioGroup3_1.check(radioButton31_2.getId());
			 editText3_1.setText(questionnaire.getLxShangPinDetail());
			 Log.d("16", String.valueOf(radioButton2_1.getId()));
			 radioGroup3_2=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup2);
		  editText3_2= (EditText)findViewById(R.id.main_activity_center_3radiogroup2_edit);
		  radioButton32_1=(RadioButton)findViewById(R.id.main_activity_center_3radiogroup2_chock1);
			 radioButton32_2=(RadioButton)findViewById(R.id.main_activity_center_3radiogroup2_chock2);
			 if(judge(questionnaire.isLxJinHuoFlag())) radioGroup3_2.check(radioButton32_1.getId());
			 else radioGroup3_2.check(radioButton32_2.getId());
			 editText3_2.setText(questionnaire.getLxJinHuoDetail());
			 Log.d("17", String.valueOf(radioButton2_1.getId()));
			 radioGroup3_3=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup3);
		  editText3_3= (EditText)findViewById(R.id.main_activity_center_3radiogroup3_edit);
		  radioButton33_1=(RadioButton)findViewById(R.id.main_activity_center_3radiogroup3_chock1);
			 radioButton33_2=(RadioButton)findViewById(R.id.main_activity_center_3radiogroup3_chock2);
			 if(judge(questionnaire.isLxChaYanFlag())) radioGroup3_3.check(radioButton33_1.getId());
			 else radioGroup3_3.check(radioButton33_2.getId());
			 editText3_3.setText(questionnaire.getLxChaYanDetail());
			 Log.d("18", String.valueOf(radioButton2_1.getId()));
			 radioGroup3_4=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup4);
		  editText3_4= (EditText)findViewById(R.id.main_activity_center_3radiogroup4_edit);
		  radioButton34_1=(RadioButton)findViewById(R.id.main_activity_center_3radiogroup4_chock1);
			 radioButton34_2=(RadioButton)findViewById(R.id.main_activity_center_3radiogroup4_chock2);
			 if(judge(questionnaire.isLxPinZhengFlag())) radioGroup3_4.check(radioButton34_1.getId());
			 else radioGroup3_4.check(radioButton34_2.getId());
			 editText3_4.setText(questionnaire.getZgQiXianDetail());
			 Log.d("19", String.valueOf(radioButton2_1.getId()));
			 radioGroup3_5=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup5);
		  editText3_5= (EditText)findViewById(R.id.main_activity_center_3radiogroup5_edit);
		  radioButton35_1=(RadioButton)findViewById(R.id.main_activity_center_3radiogroup5_chock1);
			 radioButton35_2=(RadioButton)findViewById(R.id.main_activity_center_3radiogroup5_chock2);
			 if(judge(questionnaire.isLxGuanLiFeiFlag())) radioGroup3_5.check(radioButton35_1.getId());
			 else radioGroup3_5.check(radioButton35_2.getId());
			 editText3_5.setText(questionnaire.getLxGuanLiFeiDetail());
			 Log.d("20", String.valueOf(radioButton2_1.getId()));
			 radioGroup4_1=(RadioGroup)findViewById(R.id.main_activity_center_4radiogroup1);
		  editText4_1= (EditText)findViewById(R.id.main_activity_center_4radiogroup1_edit);
		  radioButton41_1=(RadioButton)findViewById(R.id.main_activity_center_4radiogroup1_chock1);
			 radioButton41_2=(RadioButton)findViewById(R.id.main_activity_center_4radiogroup1_chock2);
			 if(judge(questionnaire.isGlZhiZeFlag())) radioGroup4_1.check(radioButton41_1.getId());
			 else radioGroup4_1.check(radioButton41_2.getId());
			 editText4_1.setText(questionnaire.getGlZhiZeDetail());
			 Log.d("21", String.valueOf(radioButton2_1.getId()));
			 radioGroup4_2=(RadioGroup)findViewById(R.id.main_activity_center_4radiogroup2);
		  editText4_2= (EditText)findViewById(R.id.main_activity_center_4radiogroup2_edit);
		  radioButton42_1=(RadioButton)findViewById(R.id.main_activity_center_4radiogroup2_chock1);
			 radioButton42_2=(RadioButton)findViewById(R.id.main_activity_center_4radiogroup2_chock2);
			 if(judge(questionnaire.isGlLuoShiFlag())) radioGroup4_2.check(radioButton42_1.getId());
			 else radioGroup4_2.check(radioButton42_2.getId());
			 editText4_2.setText(questionnaire.getGlLuoShiDetail());
			 Log.d("22", String.valueOf(radioButton2_1.getId()));
			 radioGroup4_3=(RadioGroup)findViewById(R.id.main_activity_center_4radiogroup3);
		  editText4_3=(EditText)findViewById(R.id.main_activity_center_4radiogroup3_edit);
		  radioButton43_1=(RadioButton)findViewById(R.id.main_activity_center_4radiogroup3_chock1);
			 radioButton43_2=(RadioButton)findViewById(R.id.main_activity_center_4radiogroup3_chock2);
			 if(judge(questionnaire.isGlShouXuFlag())) radioGroup4_3.check(radioButton43_1.getId());
			 else radioGroup4_3.check(radioButton43_2.getId());
			 editText4_3.setText(questionnaire.getGlShouXuDetail());
			 editTextname=(EditText)findViewById(R.id.main_activity_center_questionnairename);
			 editTextname.setText(questionnaire.getCompanyName());
			 Log.d("23", String.valueOf(radioButton2_1.getId()));
		  editTextunit=(EditText)findViewById(R.id.main_activity_center_questionnaireunit);
		  editTextunit.setText(questionnaire.getUnit());
		  Log.d("radio", "radioGroup1_1");
		}
	 private boolean judge(boolean bool)
	    {
		 	return bool;
	    }
}