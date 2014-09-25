package com.example.market;



import com.example.market.R.color;
import com.example.market.activity.BaseActivity;
import com.example.market.dialog.Effectstype;
import com.example.market.dialog.NiftyDialogBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main_activity_center extends BaseActivity
{
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_center);
		setTitle("企业巡查");
		final EditText editTextname=(EditText)findViewById(R.id.main_activity_center_name);
		final EditText editTextnumber=(EditText)findViewById(R.id.main_activity_center_numbner);
		Button buttonreutrn=(Button)findViewById(R.id.main_activity_center_return);
		Button buttonstart=(Button)findViewById(R.id.main_activity_center_start);
		buttonreutrn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent =  new Intent(Main_activity_center.this,Main_activity.class);
				startActivity(intent);
				finish();
			}
		}); 
		buttonstart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(editTextname.getText().toString().length()==0||editTextnumber.getText().toString().length()==0)
				{
					if(editTextname.getText().toString().length()==0)
					{
						editTextname.setHint("请输入企业名称");
						editTextname.setHintTextColor(color.red);
					}
					if(editTextnumber.getText().toString().length()==0)
					{
						editTextnumber.setHint("请输入注册号");
						editTextnumber.setHintTextColor(color.red);
					}
				}
				else {
					Intent intent=new Intent(Main_activity_center.this,Main_activity_center_questionnaire.class);
					intent.putExtra("name", editTextname.getText().toString());
					intent.putExtra("number", editTextnumber.getText().toString());
					startActivity(intent);
					finish();
				}
			}
		});
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
            NiftyDialogBuilder dialogBuilder=NiftyDialogBuilder.getInstance(this);
            Effectstype effect=Effectstype.Slidetop;
            dialogBuilder.withTitle("")
            .withTitleColor("#FFFFFF")
            .withDividerColor("#11000000")
            .withIcon(getResources().getDrawable(R.drawable.ic_launcher))
            .withEffect(effect)
            .withButton1Text("查看")
            .withButton2Text("删除")
            .setButton1Click(new View.OnClickListener() {
                 @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"i'm btn1",Toast.LENGTH_SHORT).show();
                }
            })
            .setButton2Click(new View.OnClickListener() {
                 @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"i'm btn2",Toast.LENGTH_SHORT).show();
                }
            })
            .show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
        }  
    } 
	
	
}