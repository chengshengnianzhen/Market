/*
Copyright (c) 2012 Roman Truba

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
documentation files (the "Software"), to deal in the Software without restriction, including without limitation
the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH
THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package ru.truba.touchgallery.TouchView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
public class FileTouchImageView extends UrlTouchImageView 
{
	
   public FileTouchImageView(Context ctx)
   {
       super(ctx);

   }
   public FileTouchImageView(Context ctx, AttributeSet attrs)
   {
       super(ctx, attrs);
   }

   public void setUrl(String imagePath)
   {
       new ImageLoadTask().execute(imagePath);
   }
   //No caching load
   public class ImageLoadTask extends UrlTouchImageView.ImageLoadTask
   {
       @Override
       protected Bitmap doInBackground(String... strings) {
           String path = strings[0];
           BitmapFactory.Options newOpts = new BitmapFactory.Options();  
           //开始读入图片，此时把options.inJustDecodeBounds 设回true了  
           newOpts.inJustDecodeBounds = true;  
           Bitmap bitmap = BitmapFactory.decodeFile(path,newOpts);//此时返回bm为空  
             
           newOpts.inJustDecodeBounds = false;  
           int w = newOpts.outWidth;  
           int h = newOpts.outHeight;  
           //现在主流手机比较多是800*480分辨率，所以高和宽我们设置为  
           float hh = 800f;//这里设置高度为800f  
           float ww = 480f;//这里设置宽度为480f  
           //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可  
           int be = 1;//be=1表示不缩放  
           if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放  
               be = (int) (newOpts.outWidth / ww);  
           } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放  
               be = (int) (newOpts.outHeight / hh);  
           }  
           if (be <= 0)  
               be = 1;  
           newOpts.inSampleSize = be;//设置缩放比例  
           //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了  
           bitmap = BitmapFactory.decodeFile(path, newOpts);  
           return compressImage(bitmap);//压缩好比例大小后再进行质量压缩  
       }
   }
   private Bitmap compressImage(Bitmap image) {  
       
       ByteArrayOutputStream baos = new ByteArrayOutputStream();  
       image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中  
       int options = 100;  
       while ( baos.toByteArray().length / 1024>100) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩         
           baos.reset();//重置baos即清空baos  
           image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中  
           options -= 10;//每次都减少10  
       }  
       ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中  
       Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片  
       return bitmap;  
   }  
}

