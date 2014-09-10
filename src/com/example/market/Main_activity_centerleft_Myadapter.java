package com.example.market;
import java.util.ArrayList;  
import java.util.HashMap;  
  
import android.app.AlertDialog;  
import android.content.Context;  
import android.content.DialogInterface;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.view.View.OnClickListener;  
import android.widget.BaseAdapter;  
import android.widget.Button;  
import android.widget.ImageView;  
import android.widget.TextView;  
/** 
 * @author chenzheng_java 
 * @description ����Ĳ���ʵ��ģ����SimpleAdapter 
 */  
public class Main_activity_centerleft_Myadapter extends BaseAdapter {  
      
    private ArrayList<HashMap<String, Object>> data;  
    /** 
     * LayoutInflater ���Ǵ���ʵ���л�ȡ�����ļ�����Ҫ��ʽ 
     *LayoutInflater layoutInflater = LayoutInflater.from(context); 
     *View convertView = layoutInflater.inflate(); 
     *LayoutInflater��ʹ��,��ʵ�ʿ�����LayoutInflater����໹�Ƿǳ����õ�,�������������� findViewById(), 
    ��ͬ����LayoutInflater��������layout��xml�����ļ�������ʵ������ 
    ��findViewById()���Ҿ���xml�µľ��� widget�ؼ�(��:Button,TextView��)�� 
     */  
    private LayoutInflater layoutInflater;  
    private Context context;  
      
      
    public Main_activity_centerleft_Myadapter(Context context,ArrayList<HashMap<String, Object>> data) {  
          
        this.context = context;  
        this.data = data;  
        this.layoutInflater = LayoutInflater.from(context);  
    }  
  
    /** 
     *��ȡ����  
     */  
    public int getCount() {  
        return data.size();  
    }  
    /** 
     *��ȡĳһλ�õ�����  
     */  
    public Object getItem(int position) {  
        return data.get(position);  
    }  
    /** 
     *��ȡΨһ��ʶ 
     */  
    public long getItemId(int position) {  
        return position;  
    }  
  
    /** 
     * android����ÿһ�е�ʱ�򣬶������������� 
     */  
    public View getView(int position, View convertView, ViewGroup parent) {  
    	Main_activity_centerleft_Myadapter_usermessage user = null;  
        if(convertView==null){  
            user = new Main_activity_centerleft_Myadapter_usermessage();  
            // ��ȡ�������  
            convertView = layoutInflater.inflate(R.layout.main_activity_centerleft_listview, null);    
            user.titleView = (TextView) convertView.findViewById(R.id.main_activity_centerleft_listview_name);  
            user.infoView = (TextView) convertView.findViewById(R.id.main_activity_centerleft_listview_reduce);  
            user.button = (Button) convertView.findViewById(R.id.main_activity_centerleft_listview_button);  
            // ����Ҫע�⣬��ʹ�õ�tag���洢���ݵġ�  
            convertView.setTag(user);  
        }  
        else {  
            user = (Main_activity_centerleft_Myadapter_usermessage) convertView.getTag();  
        }  
        // �����ݡ��Լ��¼�����    
        user.titleView.setText((String)data.get(position).get("name"));  
        user.infoView.setText((String)data.get(position).get("reduce"));  
        user.button.setOnClickListener(new OnClickListener(){  
  
            public void onClick(View v) {  
                showInfo();  
            }  
              
        });  
        return convertView;  
    }  
  
    /** 
     *���û������ťʱ�������¼����ᵯ��һ��ȷ�϶Ի��� 
     */  
     public void showInfo(){    
  
                 new AlertDialog.Builder(context)    
  
                 .setTitle("�ҵ�listview")    
  
                .setMessage("����...")    
  
                .setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {    
  
                public void onClick(DialogInterface dialog, int which) {    
  
                     }    
  
                 })    
  
               .show();    
  
                     
  
            }    
  
}  