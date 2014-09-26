package com.example.market;



import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import com.example.market.Main_activity_centerleft.Main_activity_centerleft_Myadapter_usermessage;
import com.example.market.R.color;
import com.example.market.activity.BaseActivity;
import com.example.market.db.question;
import com.example.market.dialog.Effectstype;
import com.example.market.dialog.NiftyDialogBuilder;
import com.example.market.utils.Questionnaire;
import com.google.gson.Gson;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.util.LogUtils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewDebug.IntToString;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main_activity_center extends BaseActivity
{
	private ListView listView;
	private TextView textView;
	private List<question> list;
	private ArrayList<Questionnaire> questionnaires;//保存本地数据读取到listview
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_above_upload);
		setTitle("企业巡查");
		//初始化控件
		init();
	}
	
	private void init()
	{
		listView=(ListView)findViewById(R.id.main_activtiy_above_upload_listview);
		textView=(TextView)findViewById(R.id.main_activity_above_upload_text);
		textView.setVisibility(View.GONE);
		DbUtils db=DbUtils.create(this,"market");
		//question entity = db.findById(question.class, parent.getId());
		try {
		    list = db.findAll(question.class);
		    
			if (list!=null) 
			{
				LogUtils.d(list.toString());
				mAdapter mAdapter1=new mAdapter(this);
				listView.setAdapter(mAdapter1);
			}
			else{
				LogUtils.d("null");
				Toast.makeText(this,"没有本地问卷" ,Toast.LENGTH_LONG);
			}
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//通过类型查找
		//加载数据  
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();  
        inflater.inflate(R.menu.question, menu);          
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
        case R.id.menu_build:
            final NiftyDialogBuilder dialogBuilder=NiftyDialogBuilder.getInstance(this);
            Effectstype effect=Effectstype.Slidetop;
            dialogBuilder.withTitle("")
            .withTitleColor("#FFFFFF")
            .withIcon(getResources().getDrawable(R.drawable.ic_launcher))
            .withEffect(effect)
            .withButton1Text("新建")
            .withButton2Text("返回")
            .setButton1Click(new View.OnClickListener() {
                 @Override
                public void onClick(View v) {
                	 //Toast.makeText(v.getContext(),"i'm btn1",Toast.LENGTH_SHORT).show();
                	//保存到数据库还是?本地，先回去想想
 					if(TextUtils.isEmpty(dialogBuilder.getEditText().getText())||TextUtils.isEmpty(dialogBuilder.getEditText2().getText()))
 					{
 						if(TextUtils.isEmpty(dialogBuilder.getEditText().getText()))
 						{
 							dialogBuilder.getEditText().setHint("请输入企业名称");
 							dialogBuilder.getEditText().setHintTextColor(color.red);
 						}
 						if(TextUtils.isEmpty(dialogBuilder.getEditText2().getText()))
 						{
 							dialogBuilder.getEditText2().setHint("请输入注册号");
 							dialogBuilder.getEditText2().setHintTextColor(color.red);
 						}
 					}
 					else {
 						LogUtils.d("chenggong");
 						Intent intent1=new Intent(Main_activity_center.this,Main_activity_center_questionnaire.class);
 						intent1.putExtra("name", dialogBuilder.getEditText().getText().toString());
 						intent1.putExtra("number",dialogBuilder.getEditText2().getText().toString());
 						startActivity(intent1);
 						dialogBuilder.dismiss();
 					}
                }
            })
            .setButton2Click(new View.OnClickListener() {
                 @Override
                public void onClick(View v) {
                    //Toast.makeText(v.getContext(),"i'm btn2",Toast.LENGTH_SHORT).show();
                	 dialogBuilder.dismiss();
                	 
                }
            })
            .show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
        }  
  	}    
                
	public class mAdapter extends BaseAdapter {  
        	
            private LayoutInflater layoutInflater;  
            private Context context;   
            
            public mAdapter(Context context) {  
                  
                this.context = context;    
                this.layoutInflater = LayoutInflater.from(context);  
            }  
          
            /** 
             *获取列数  
             */  
            public int getCount() {  
                return list.size();  
            }  
            /** 
             *获取某一位置的数据  
             */  
            public Object getItem(int position) {  
                return position;  
            }  
            /** 
             *获取唯一标识 
             */  
            public long getItemId(int position) {  
                return position;  
            }  
          
            /** 
             * android绘制每一列的时候，都会调用这个方法 
             */  
            public View getView(int position, View convertView, ViewGroup parent) {  
            	item witem=new item();   
                if(convertView==null){  
                    // 获取组件布局  
                    convertView = layoutInflater.inflate(R.layout.listitem, null);    
                    witem.titleView = (TextView) convertView.findViewById(R.id.listviewitem1);  
                    witem.infoView = (TextView) convertView.findViewById(R.id.listviewitem2);  
                    witem.thirdView = (TextView) convertView.findViewById(R.id.listviewitem3);  
                    // 这里要注意，是使用的tag来存储数据的。  
                    convertView.setTag(witem);  
                }  
                else {  
                    witem = (item) convertView.getTag();  
                }  
                witem.titleView.setText(list.get(position).getName());
                witem.infoView.setText(list.get(position).getNumber());
                witem.thirdView.setText(list.get(position).getTime());
                return convertView;  
            }   
          
    } 
    public final class item {  
            
            public TextView titleView;  
            public TextView infoView;  
            public TextView thirdView;  
              
              
    }  
}
