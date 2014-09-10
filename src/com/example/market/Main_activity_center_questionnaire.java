package com.example.market;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.market.R.color;
import com.example.market.R.id;
import com.example.market.activity.BaseActivity;

import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main_activity_center_questionnaire extends Activity
{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_center_questionnaire);
		Intent intent=this.getIntent();
		Bundle bundle=intent.getExtras();
		final String name=bundle.getString("name");
		final String number=bundle.getString("number");
		Button buttonupload=(Button)findViewById(R.id.main_activity_center_questionnaireupload);
		Button buttonreturn =(Button)findViewById(R.id.main_activity_center_questionnairereturn);
		buttonreturn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Main_activity_center_questionnaire.this,Main_activity_center.class);
				startActivity(intent);
				finish();
			}
		});//返回按钮，就是什么也没做。
		buttonupload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//先获取当前页面的数据
				try {
					FileOutputStream fos=openFileOutput(name+":"+number+"txt",Context.MODE_PRIVATE);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//保存到本地
				RadioGroup radioGroup1_1=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup1);
				RadioButton radioButton1_1=(RadioButton)findViewById(radioGroup1_1.getCheckedRadioButtonId());
				EditText editText1_1= (EditText)findViewById(R.id.main_activity_center_1radiogroup1_edit);
				//fos.write(("1、是否按规定办理营业执照并将营业执照置于住所或者营业场所醒目位置？："+radioButton1_1.getText().toString()
				//		+"\t"+editText1_1.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup1_2=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup2);
				RadioButton radioButton1_2=(RadioButton)findViewById(radioGroup1_2.getCheckedRadioButtonId());
				EditText editText1_2= (EditText)findViewById(R.id.main_activity_center_1radiogroup2_edit);
				//fos.write(("2、是否在核准的地址从事经营活动？："+radioButton1_2.getText().toString()
				//		+"\t"+editText1_2.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup1_3=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup3);
				RadioButton radioButton1_3=(RadioButton)findViewById(radioGroup1_3.getCheckedRadioButtonId());
				EditText editText1_3= (EditText)findViewById(R.id.main_activity_center_1radiogroup3_edit);
				//fos.write(("3、使用的公章、名称是否与营业执照上核准的名称一致："+radioButton1_3.getText().toString()
				//		+"\t"+editText1_3.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup1_4=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup4);
				RadioButton radioButton1_4=(RadioButton)findViewById(radioGroup1_4.getCheckedRadioButtonId());
				EditText editText1_4= (EditText)findViewById(R.id.main_activity_center_1radiogroup4_edit);
				//fos.write(("4、是否存在伪造、涂改、出租、出借、转让营业执照的行为？："+radioButton1_4.getText().toString()
				//		+"\t"+editText1_4.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup1_5=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup5);
				RadioButton radioButton1_5=(RadioButton)findViewById(radioGroup1_5.getCheckedRadioButtonId());
				EditText editText1_5= (EditText)findViewById(R.id.main_activity_center_1radiogroup5_edit);
				//fos.write(("5、是否进行年检验照？："+radioButton1_5.getText().toString()
				//		+"\t"+editText1_5.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup1_6=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup6);
				RadioButton radioButton1_6=(RadioButton)findViewById(radioGroup1_6.getCheckedRadioButtonId());
				EditText editText1_6= (EditText)findViewById(R.id.main_activity_center_1radiogroup6_edit);
				//fos.write(("6、是否超过营业执照上的经营期限从事生产经营活动？："+radioButton1_6.getText().toString()
				//		+"\t"+editText1_6.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup1_7=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup7);
				RadioButton radioButton1_7=(RadioButton)findViewById(radioGroup1_7.getCheckedRadioButtonId());
				EditText editText1_7= (EditText)findViewById(R.id.main_activity_center_1radiogroup7_edit);
				//fos.write(("7、是否擅自变更法定代表人、负责人或股东？："+radioButton1_7.getText().toString()
				//		+"\t"+editText1_7.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup1_8=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup8);
				RadioButton radioButton1_8=(RadioButton)findViewById(radioGroup1_8.getCheckedRadioButtonId());
				EditText editText1_8= (EditText)findViewById(R.id.main_activity_center_1radiogroup8_edit);
				//fos.write(("8、是否有虚报注册资本、抽逃注册资本以及注册登记时提交虚假注册文件的行为？："+radioButton1_8.getText().toString()
				//		+"\t"+editText1_8.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup2_1=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup1);
				RadioButton radioButton2_1=(RadioButton)findViewById(radioGroup2_1.getCheckedRadioButtonId());
				EditText editText2_1= (EditText)findViewById(R.id.main_activity_center_2radiogroup1_edit);
				//fos.write(("1、是否未取得专项审批而擅自从事该项经营；专项审批证件是否有效、内容与登记事项是否一致？："+radioButton2_1.getText().toString()
				//		+"\t"+editText2_1.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup2_2=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup2);
				RadioButton radioButton2_2=(RadioButton)findViewById(radioGroup2_2.getCheckedRadioButtonId());
				EditText editText2_2= (EditText)findViewById(R.id.main_activity_center_2radiogroup2_edit);
				//fos.write((" 2、是否超越核准登记的生产经营范围从事生产经营活动？："+radioButton2_2.getText().toString()
				//		+"\t"+editText2_2.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup2_3=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup3);
				RadioButton radioButton2_3=(RadioButton)findViewById(radioGroup2_3.getCheckedRadioButtonId());
				EditText editText2_3= (EditText)findViewById(R.id.main_activity_center_2radiogroup3_edit);
				//fos.write(("3、生产加工企业使用的商标是否注册或授权使用？："+radioButton2_3.getText().toString()
				//		+"\t"+editText2_3.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup2_4=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup4);
				RadioButton radioButton2_4=(RadioButton)findViewById(radioGroup2_4.getCheckedRadioButtonId());
				EditText editText2_4= (EditText)findViewById(R.id.main_activity_center_2radiogroup4_edit);
				//fos.write(("4、未注册商标使用情况，是否有商标侵权行为？："+radioButton2_4.getText().toString()
				//		+"\t"+editText2_4.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup2_5=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup5);
				RadioButton radioButton2_5=(RadioButton)findViewById(radioGroup2_5.getCheckedRadioButtonId());
				EditText editText2_5= (EditText)findViewById(R.id.main_activity_center_2radiogroup5_edit);
				//fos.write(("5、是否有销售伪造产品产地，伪造或者冒用他人厂名、厂址，假冒、仿冒他人知名商品商标、名称、包装、装璜，标识不全，过期失效、变质，数量不足，掺杂掺假商品的行为？："+radioButton2_5.getText().toString()
				//		+"\t"+editText2_5.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup2_6=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup6);
				RadioButton radioButton2_6=(RadioButton)findViewById(radioGroup2_6.getCheckedRadioButtonId());
				EditText editText2_6= (EditText)findViewById(R.id.main_activity_center_2radiogroup6_edit);
				//fos.write(("6、是否有虚假广告或对商品质量、服务、功效适用范围作虚假宣传的行为？："+radioButton2_6.getText().toString()
				//		+"\t"+editText2_6.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup3_1=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup1);
				RadioButton radioButton3_1=(RadioButton)findViewById(radioGroup3_1.getCheckedRadioButtonId());
				EditText editText3_1= (EditText)findViewById(R.id.main_activity_center_3radiogroup1_edit);
				//fos.write(("1、商品是否明码标价、填写是否规范、内容是否真实、货签是否对位？："+radioButton3_1.getText().toString()
				//		+"\t"+editText3_1.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup3_2=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup2);
				RadioButton radioButton3_2=(RadioButton)findViewById(radioGroup3_2.getCheckedRadioButtonId());
				EditText editText3_2= (EditText)findViewById(R.id.main_activity_center_3radiogroup2_edit);
				//fos.write(("2、是否从正规渠道进货？："+radioButton3_2.getText().toString()
				//		+"\t"+editText3_2.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup3_3=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup3);
				RadioButton radioButton3_3=(RadioButton)findViewById(radioGroup3_3.getCheckedRadioButtonId());
				EditText editText3_3= (EditText)findViewById(R.id.main_activity_center_3radiogroup3_edit);
				//fos.write(("3、是否建立商品进货查验制度？："+radioButton3_3.getText().toString()
				//		+"\t"+editText3_3.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup3_4=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup4);
				RadioButton radioButton3_4=(RadioButton)findViewById(radioGroup3_4.getCheckedRadioButtonId());
				EditText editText3_4= (EditText)findViewById(R.id.main_activity_center_3radiogroup4_edit);
				//fos.write(("4、农资、化学危险品、食品经营者是否索证索票存档备查，是否建立购销台帐；对售出的商品是否提供发票等售货凭证?："+radioButton3_4.getText().toString()
				//		+"\t"+editText3_4.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup3_5=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup5);
				RadioButton radioButton3_5=(RadioButton)findViewById(radioGroup3_5.getCheckedRadioButtonId());
				EditText editText3_5= (EditText)findViewById(R.id.main_activity_center_3radiogroup5_edit);
				//fos.write(("5、个体工商户是否少交、漏交、未交工商管理费?："+radioButton3_5.getText().toString()
				//		+"\t"+editText3_5.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup4_1=(RadioGroup)findViewById(R.id.main_activity_center_4radiogroup1);
				RadioButton radioButton4_1=(RadioButton)findViewById(radioGroup4_1.getCheckedRadioButtonId());
				EditText editText4_1= (EditText)findViewById(R.id.main_activity_center_4radiogroup1_edit);
				//fos.write(("1、各类商品交易市场、展销会、农村集市的主办单位是否依照国家有关法律、法规和规章，履行所办市场内部安全、卫生及商品质量管理等相应制度的职责?："+radioButton4_1.getText().toString()
				//		+"\t"+editText3_1.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup4_2=(RadioGroup)findViewById(R.id.main_activity_center_4radiogroup2);
				RadioButton radioButton4_2=(RadioButton)findViewById(radioGroup4_2.getCheckedRadioButtonId());
				EditText editText4_2= (EditText)findViewById(R.id.main_activity_center_4radiogroup2_edit);
				//fos.write(("1、各类商品交易市场、展销会、农村集市的主办单位是否依照国家有关法律、法规和规章，履行所办市场内部安全、卫生及商品质量管理等相应制度的职责?："+radioButton4_2.getText().toString()
				//		+"\t"+editText4_2.getText().toString()+"\t\n").getBytes());
				EditText editTextname=(EditText)findViewById(R.id.main_activity_center_questionnairename);
				EditText editTextunit=(EditText)findViewById(R.id.main_activity_center_questionnaireunit);
				//fos.write(("巡查人员："+editTextname.getText().toString()+"\t\n").getBytes());
				//fos.write(("巡查单位："+editTextunit.getText().toString()+"\t\n").getBytes());
				/*try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		});//上传按钮怎么上传？
		
	}
}