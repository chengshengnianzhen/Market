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
		});//���ذ�ť������ʲôҲû����
		buttonupload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//�Ȼ�ȡ��ǰҳ�������
				try {
					FileOutputStream fos=openFileOutput(name+":"+number+"txt",Context.MODE_PRIVATE);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//���浽����
				RadioGroup radioGroup1_1=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup1);
				RadioButton radioButton1_1=(RadioButton)findViewById(radioGroup1_1.getCheckedRadioButtonId());
				EditText editText1_1= (EditText)findViewById(R.id.main_activity_center_1radiogroup1_edit);
				//fos.write(("1���Ƿ񰴹涨����Ӫҵִ�ղ���Ӫҵִ������ס������Ӫҵ������Ŀλ�ã���"+radioButton1_1.getText().toString()
				//		+"\t"+editText1_1.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup1_2=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup2);
				RadioButton radioButton1_2=(RadioButton)findViewById(radioGroup1_2.getCheckedRadioButtonId());
				EditText editText1_2= (EditText)findViewById(R.id.main_activity_center_1radiogroup2_edit);
				//fos.write(("2���Ƿ��ں�׼�ĵ�ַ���¾�Ӫ�����"+radioButton1_2.getText().toString()
				//		+"\t"+editText1_2.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup1_3=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup3);
				RadioButton radioButton1_3=(RadioButton)findViewById(radioGroup1_3.getCheckedRadioButtonId());
				EditText editText1_3= (EditText)findViewById(R.id.main_activity_center_1radiogroup3_edit);
				//fos.write(("3��ʹ�õĹ��¡������Ƿ���Ӫҵִ���Ϻ�׼������һ�£�"+radioButton1_3.getText().toString()
				//		+"\t"+editText1_3.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup1_4=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup4);
				RadioButton radioButton1_4=(RadioButton)findViewById(radioGroup1_4.getCheckedRadioButtonId());
				EditText editText1_4= (EditText)findViewById(R.id.main_activity_center_1radiogroup4_edit);
				//fos.write(("4���Ƿ����α�졢Ϳ�ġ����⡢���衢ת��Ӫҵִ�յ���Ϊ����"+radioButton1_4.getText().toString()
				//		+"\t"+editText1_4.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup1_5=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup5);
				RadioButton radioButton1_5=(RadioButton)findViewById(radioGroup1_5.getCheckedRadioButtonId());
				EditText editText1_5= (EditText)findViewById(R.id.main_activity_center_1radiogroup5_edit);
				//fos.write(("5���Ƿ����������գ���"+radioButton1_5.getText().toString()
				//		+"\t"+editText1_5.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup1_6=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup6);
				RadioButton radioButton1_6=(RadioButton)findViewById(radioGroup1_6.getCheckedRadioButtonId());
				EditText editText1_6= (EditText)findViewById(R.id.main_activity_center_1radiogroup6_edit);
				//fos.write(("6���Ƿ񳬹�Ӫҵִ���ϵľ�Ӫ���޴���������Ӫ�����"+radioButton1_6.getText().toString()
				//		+"\t"+editText1_6.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup1_7=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup7);
				RadioButton radioButton1_7=(RadioButton)findViewById(radioGroup1_7.getCheckedRadioButtonId());
				EditText editText1_7= (EditText)findViewById(R.id.main_activity_center_1radiogroup7_edit);
				//fos.write(("7���Ƿ����Ա�����������ˡ������˻�ɶ�����"+radioButton1_7.getText().toString()
				//		+"\t"+editText1_7.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup1_8=(RadioGroup)findViewById(R.id.main_activity_center_1radiogroup8);
				RadioButton radioButton1_8=(RadioButton)findViewById(radioGroup1_8.getCheckedRadioButtonId());
				EditText editText1_8= (EditText)findViewById(R.id.main_activity_center_1radiogroup8_edit);
				//fos.write(("8���Ƿ����鱨ע���ʱ�������ע���ʱ��Լ�ע��Ǽ�ʱ�ύ���ע���ļ�����Ϊ����"+radioButton1_8.getText().toString()
				//		+"\t"+editText1_8.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup2_1=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup1);
				RadioButton radioButton2_1=(RadioButton)findViewById(radioGroup2_1.getCheckedRadioButtonId());
				EditText editText2_1= (EditText)findViewById(R.id.main_activity_center_2radiogroup1_edit);
				//fos.write(("1���Ƿ�δȡ��ר�����������Դ��¸��Ӫ��ר������֤���Ƿ���Ч��������Ǽ������Ƿ�һ�£���"+radioButton2_1.getText().toString()
				//		+"\t"+editText2_1.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup2_2=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup2);
				RadioButton radioButton2_2=(RadioButton)findViewById(radioGroup2_2.getCheckedRadioButtonId());
				EditText editText2_2= (EditText)findViewById(R.id.main_activity_center_2radiogroup2_edit);
				//fos.write((" 2���Ƿ�Խ��׼�Ǽǵ�������Ӫ��Χ����������Ӫ�����"+radioButton2_2.getText().toString()
				//		+"\t"+editText2_2.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup2_3=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup3);
				RadioButton radioButton2_3=(RadioButton)findViewById(radioGroup2_3.getCheckedRadioButtonId());
				EditText editText2_3= (EditText)findViewById(R.id.main_activity_center_2radiogroup3_edit);
				//fos.write(("3�������ӹ���ҵʹ�õ��̱��Ƿ�ע�����Ȩʹ�ã���"+radioButton2_3.getText().toString()
				//		+"\t"+editText2_3.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup2_4=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup4);
				RadioButton radioButton2_4=(RadioButton)findViewById(radioGroup2_4.getCheckedRadioButtonId());
				EditText editText2_4= (EditText)findViewById(R.id.main_activity_center_2radiogroup4_edit);
				//fos.write(("4��δע���̱�ʹ��������Ƿ����̱���Ȩ��Ϊ����"+radioButton2_4.getText().toString()
				//		+"\t"+editText2_4.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup2_5=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup5);
				RadioButton radioButton2_5=(RadioButton)findViewById(radioGroup2_5.getCheckedRadioButtonId());
				EditText editText2_5= (EditText)findViewById(R.id.main_activity_center_2radiogroup5_edit);
				//fos.write(("5���Ƿ�������α���Ʒ���أ�α�����ð�����˳�������ַ����ð����ð����֪����Ʒ�̱ꡢ���ơ���װ��װ諣���ʶ��ȫ������ʧЧ�����ʣ��������㣬���Ӳ�����Ʒ����Ϊ����"+radioButton2_5.getText().toString()
				//		+"\t"+editText2_5.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup2_6=(RadioGroup)findViewById(R.id.main_activity_center_2radiogroup6);
				RadioButton radioButton2_6=(RadioButton)findViewById(radioGroup2_6.getCheckedRadioButtonId());
				EditText editText2_6= (EditText)findViewById(R.id.main_activity_center_2radiogroup6_edit);
				//fos.write(("6���Ƿ�����ٹ������Ʒ���������񡢹�Ч���÷�Χ�������������Ϊ����"+radioButton2_6.getText().toString()
				//		+"\t"+editText2_6.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup3_1=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup1);
				RadioButton radioButton3_1=(RadioButton)findViewById(radioGroup3_1.getCheckedRadioButtonId());
				EditText editText3_1= (EditText)findViewById(R.id.main_activity_center_3radiogroup1_edit);
				//fos.write(("1����Ʒ�Ƿ������ۡ���д�Ƿ�淶�������Ƿ���ʵ����ǩ�Ƿ��λ����"+radioButton3_1.getText().toString()
				//		+"\t"+editText3_1.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup3_2=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup2);
				RadioButton radioButton3_2=(RadioButton)findViewById(radioGroup3_2.getCheckedRadioButtonId());
				EditText editText3_2= (EditText)findViewById(R.id.main_activity_center_3radiogroup2_edit);
				//fos.write(("2���Ƿ������������������"+radioButton3_2.getText().toString()
				//		+"\t"+editText3_2.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup3_3=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup3);
				RadioButton radioButton3_3=(RadioButton)findViewById(radioGroup3_3.getCheckedRadioButtonId());
				EditText editText3_3= (EditText)findViewById(R.id.main_activity_center_3radiogroup3_edit);
				//fos.write(("3���Ƿ�����Ʒ���������ƶȣ���"+radioButton3_3.getText().toString()
				//		+"\t"+editText3_3.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup3_4=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup4);
				RadioButton radioButton3_4=(RadioButton)findViewById(radioGroup3_4.getCheckedRadioButtonId());
				EditText editText3_4= (EditText)findViewById(R.id.main_activity_center_3radiogroup4_edit);
				//fos.write(("4��ũ�ʡ���ѧΣ��Ʒ��ʳƷ��Ӫ���Ƿ���֤��Ʊ�浵���飬�Ƿ�������̨�ʣ����۳�����Ʒ�Ƿ��ṩ��Ʊ���ۻ�ƾ֤?��"+radioButton3_4.getText().toString()
				//		+"\t"+editText3_4.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup3_5=(RadioGroup)findViewById(R.id.main_activity_center_3radiogroup5);
				RadioButton radioButton3_5=(RadioButton)findViewById(radioGroup3_5.getCheckedRadioButtonId());
				EditText editText3_5= (EditText)findViewById(R.id.main_activity_center_3radiogroup5_edit);
				//fos.write(("5�����幤�̻��Ƿ��ٽ���©����δ�����̹����?��"+radioButton3_5.getText().toString()
				//		+"\t"+editText3_5.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup4_1=(RadioGroup)findViewById(R.id.main_activity_center_4radiogroup1);
				RadioButton radioButton4_1=(RadioButton)findViewById(radioGroup4_1.getCheckedRadioButtonId());
				EditText editText4_1= (EditText)findViewById(R.id.main_activity_center_4radiogroup1_edit);
				//fos.write(("1��������Ʒ�����г���չ���ᡢũ�弯�е����쵥λ�Ƿ����չ����йط��ɡ�����͹��£����������г��ڲ���ȫ����������Ʒ�����������Ӧ�ƶȵ�ְ��?��"+radioButton4_1.getText().toString()
				//		+"\t"+editText3_1.getText().toString()+"\t\n").getBytes());
				RadioGroup radioGroup4_2=(RadioGroup)findViewById(R.id.main_activity_center_4radiogroup2);
				RadioButton radioButton4_2=(RadioButton)findViewById(radioGroup4_2.getCheckedRadioButtonId());
				EditText editText4_2= (EditText)findViewById(R.id.main_activity_center_4radiogroup2_edit);
				//fos.write(("1��������Ʒ�����г���չ���ᡢũ�弯�е����쵥λ�Ƿ����չ����йط��ɡ�����͹��£����������г��ڲ���ȫ����������Ʒ�����������Ӧ�ƶȵ�ְ��?��"+radioButton4_2.getText().toString()
				//		+"\t"+editText4_2.getText().toString()+"\t\n").getBytes());
				EditText editTextname=(EditText)findViewById(R.id.main_activity_center_questionnairename);
				EditText editTextunit=(EditText)findViewById(R.id.main_activity_center_questionnaireunit);
				//fos.write(("Ѳ����Ա��"+editTextname.getText().toString()+"\t\n").getBytes());
				//fos.write(("Ѳ�鵥λ��"+editTextunit.getText().toString()+"\t\n").getBytes());
				/*try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		});//�ϴ���ť��ô�ϴ���
		
	}
}