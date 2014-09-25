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
           //��ʼ����ͼƬ����ʱ��options.inJustDecodeBounds ���true��  
           newOpts.inJustDecodeBounds = true;  
           Bitmap bitmap = BitmapFactory.decodeFile(path,newOpts);//��ʱ����bmΪ��  
             
           newOpts.inJustDecodeBounds = false;  
           int w = newOpts.outWidth;  
           int h = newOpts.outHeight;  
           //���������ֻ��Ƚ϶���800*480�ֱ��ʣ����ԸߺͿ���������Ϊ  
           float hh = 800f;//�������ø߶�Ϊ800f  
           float ww = 480f;//�������ÿ��Ϊ480f  
           //���űȡ������ǹ̶��������ţ�ֻ�ø߻��߿�����һ�����ݽ��м��㼴��  
           int be = 1;//be=1��ʾ������  
           if (w > h && w > ww) {//�����ȴ�Ļ����ݿ�ȹ̶���С����  
               be = (int) (newOpts.outWidth / ww);  
           } else if (w < h && h > hh) {//����߶ȸߵĻ����ݿ�ȹ̶���С����  
               be = (int) (newOpts.outHeight / hh);  
           }  
           if (be <= 0)  
               be = 1;  
           newOpts.inSampleSize = be;//�������ű���  
           //���¶���ͼƬ��ע���ʱ�Ѿ���options.inJustDecodeBounds ���false��  
           bitmap = BitmapFactory.decodeFile(path, newOpts);  
           return compressImage(bitmap);//ѹ���ñ�����С���ٽ�������ѹ��  
       }
   }
   private Bitmap compressImage(Bitmap image) {  
       
       ByteArrayOutputStream baos = new ByteArrayOutputStream();  
       image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//����ѹ������������100��ʾ��ѹ������ѹ��������ݴ�ŵ�baos��  
       int options = 100;  
       while ( baos.toByteArray().length / 1024>100) {  //ѭ���ж����ѹ����ͼƬ�Ƿ����100kb,���ڼ���ѹ��         
           baos.reset();//����baos�����baos  
           image.compress(Bitmap.CompressFormat.JPEG, options, baos);//����ѹ��options%����ѹ��������ݴ�ŵ�baos��  
           options -= 10;//ÿ�ζ�����10  
       }  
       ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//��ѹ���������baos��ŵ�ByteArrayInputStream��  
       Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//��ByteArrayInputStream��������ͼƬ  
       return bitmap;  
   }  
}

