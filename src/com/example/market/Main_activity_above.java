package com.example.market;
import java.io.File;
import com.example.market.activity.BaseActivity;
import com.example.market.db.Userinfo;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class Main_activity_above extends BaseActivity {
	private static final String LOG_TAG = "HelloCamera";
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
    
    private Button takePicBtn = null;
    private Button takeVideoBtn = null;
    private Button uploadBtnButton =null;
    private Button download;
    private Uri fileUri;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_above);
		 takePicBtn = (Button) findViewById(R.id.main_activtiy_above_pirture);
	     takePicBtn.setOnClickListener(takePiClickListener);//拍照的按钮

	     takeVideoBtn = (Button) findViewById(R.id.main_activtiy_above_video);
	     takeVideoBtn.setOnClickListener(takeVideoClickListener);//摄像的按钮
	     setTitle("现场情况");
	     uploadBtnButton= (Button) findViewById(R.id.main_activtiy_above_upload);
	     //上传的按钮，显示已经拍摄的照片或者视频然后点击可以上传
	     uploadBtnButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Main_activity_above.this,Main_activity_above_upload.class);
				startActivity(intent);
			}
		});
	     download=(Button)findViewById(R.id.main_activtiy_above_download);
	     download.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					DbUtils dbUtil=DbUtils.create(Main_activity_above.this,"market");
			    	Userinfo userinfo = null;
					try {
						userinfo = dbUtil.findById(Userinfo.class, 1);
					} catch (DbException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(userinfo.isIsnetwork())
					{
						Intent intent=new Intent(Main_activity_above.this,Main_activity_above_download.class);
						startActivity(intent);
					}else {
						Toast.makeText(Main_activity_above.this, "登录时没有联网，请重新登录", Toast.LENGTH_LONG).show();
					}
				}
			});
	     
	    
	}
	private final OnClickListener takePiClickListener = new View.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            Log.d(LOG_TAG, "Take Picture Button Click");
            // 利用系统自带的相机应用:拍照
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            // create a file to save the image
            fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

            // 此处这句intent的值设置关系到后面的onActivityResult中会进入那个分支，即关系到data是否为null，如果此处指定，则后来的data为null
            // set the image file name
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        }

    };

    private final OnClickListener takeVideoClickListener = new View.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            Log.d(LOG_TAG, "Take Video Button Click");
            // 摄像
            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

            // create a file to save the video
            fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);
            // set the image file name
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

            // set the video image quality to high
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);

            startActivityForResult(intent, CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);
        }
    };

    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;

    private static Uri getOutputMediaFileUri(int type)
    {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /** Create a File for saving an image or video */
    @SuppressLint("SimpleDateFormat")
	private static File getOutputMediaFile(int type)
    {

        File mediaStorageDir = null;
        try
        {

            mediaStorageDir = new File(
                    Environment
                            .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "MyMarketApp");//设置保存的位置

            Log.d(LOG_TAG, "Successfully created mediaStorageDir: "
                    + mediaStorageDir);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.d(LOG_TAG, "Error in Creating mediaStorageDir: "
                    + mediaStorageDir);
        }

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists())
        {
            if (!mediaStorageDir.mkdirs())
            {
                // 在SD卡上创建文件夹需要权限：
                // <uses-permission
                // android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
                Log.d(LOG_TAG,
                        "failed to create directory, check if you have the WRITE_EXTERNAL_STORAGE permission");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE)
        {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + ".jpg");
        }
        else if (type == MEDIA_TYPE_VIDEO)
        {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "VID_" + timeStamp + ".mp4");
        }
        else
        {
            return null;
        }

        return mediaFile;
    }

}