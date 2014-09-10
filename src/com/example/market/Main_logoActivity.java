package com.example.market;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;  
import android.content.Intent;  
import android.os.Bundle;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.view.Window;  
import android.widget.Button;  
import android.widget.ProgressBar;  
  
public class Main_logoActivity extends Activity {  
    private ProgressBar progressBar;  
    private Button backButton;  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        // È¥³ý±êÌâ  
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.logo);  
  
        progressBar = (ProgressBar) findViewById(R.id.pgBar);  
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
         @Override
         public void run() {
         Intent intent = new Intent(Main_logoActivity.this,Main_activity.class);
         intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
         startActivity(intent);
         finish();
         }
        };
        timer.schedule(task, 1000);
        backButton = (Button) findViewById(R.id.btn_back);  
        backButton.setOnClickListener(new OnClickListener() {  
  
            @Override  
            public void onClick(View v) {  
                finish();  
  
            }  
        });  
  
    }  
    
  
}  