package com.example.market.activity;

import com.example.market.Main_LoginActivity;
import com.example.market.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MenuActivity extends Activity { 

	private SharedPreferences sp;
    @Override 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);//实例化对象
    } 
     
    @Override 
    public boolean onCreateOptionsMenu(Menu menu) { 
        menu.add(1, Menu.FIRST + 1, 4, "返回").setIcon(android.R.drawable.ic_menu_call); 
        menu.add(2, Menu.FIRST + 2, 2, "退出").setIcon(android.R.drawable.ic_menu_close_clear_cancel); 
        menu.add(1, Menu.FIRST + 3, 3, "注销").setIcon(android.R.drawable.ic_menu_delete);
        //menu.add(2, Menu.FIRST + 4, 1, "测试").setIcon(android.R.drawable.ic_menu_more);  
        menu.add(2, Menu.FIRST + 4, 1, "测试").setIcon(R.drawable.quit);  
        return true; 
    } 
    @Override 
    public boolean onOptionsItemSelected(MenuItem item) { 
        switch (item.getItemId()) {
		case Menu.FIRST+1:
			finish();
			break;
		case Menu.FIRST+2:
			Intent intent = new Intent(Intent.ACTION_MAIN);  
        	intent.addCategory(Intent.CATEGORY_HOME);  
        	startActivity(intent);  
        	System.exit(0); 
        	break;
        case Menu.FIRST+3:
        	deletedp();//删除数据		
        	Intent intent1 = new Intent(this,Main_LoginActivity.class);  
        	intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
        	startActivity(intent1);  
        	System.exit(0);
		default:
			break;
		}
        return true; 
    } 
    private void deletedp(){
    	sp.edit().putString("USER_NAME","").commit();
    	sp.edit().putString("PASSWORD","").commit();
    	sp.edit().putBoolean("ISCHECK",false).commit();
    	sp.edit().putBoolean("AUTO_ISCHECK",false).commit();
    	
    }
} 