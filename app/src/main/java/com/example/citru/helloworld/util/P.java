package com.example.citru.helloworld.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

public class P {

    private Bitmap createCircleImage(Bitmap source, int min) {

        //
        // 获得图片的宽高
        int width = source.getWidth();
        int height = source.getHeight();
        float realScale = 0;
        if (width > height) {
            realScale = 2 * min / height;
        } else {
            realScale = 2 * min / width;
        }
        // 设置想要的大小

        // L.i("tag", "w="+width+"//h="+height+"//2*min="+newHeight);
        // 计算缩放比例

        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(realScale, realScale);
        // 得到新的图片
        Bitmap bm = Bitmap.createBitmap(source, 0, 0, width, height, matrix,
                true);
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap target = Bitmap.createBitmap(2 * min, 2 * min, Config.ARGB_8888);
        /**
         * 产生一个同样大小的画布
         */
        Canvas canvas = new Canvas(target);
        /**
         * 首先绘制圆形
         */
        canvas.drawCircle(min, min, min, paint);
        /**
         * 使用SRC_IN
         */
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        /**
         * 绘制图片
         */
        canvas.drawBitmap(source, 0, 0, paint);
        return target;
    }

    /**
     * 获取裁剪后的圆形图片
     *
     * @param radius 半径
     */
    public Bitmap getCroppedRoundBitmap(Bitmap bmp, int radius) {
        Bitmap scaledSrcBmp;
        int diameter = radius * 2;

        // 为了防止宽高不相等，造成圆形图片变形，因此截取长方形中处于中间位置最大的正方形图片
        int bmpWidth = bmp.getWidth();
        int bmpHeight = bmp.getHeight();
        int squareWidth = 0, squareHeight = 0;
        int x = 0, y = 0;
        Bitmap squareBitmap;
        if (bmpHeight > bmpWidth) {// 高大于宽
            squareWidth = squareHeight = bmpWidth;
            x = 0;
            y = (bmpHeight - bmpWidth) / 2;
            // 截取正方形图片
            squareBitmap = Bitmap.createBitmap(bmp, x, y, squareWidth,
                    squareHeight);
        } else if (bmpHeight < bmpWidth) {// 宽大于高
            squareWidth = squareHeight = bmpHeight;
            x = (bmpWidth - bmpHeight) / 2;
            y = 0;
            squareBitmap = Bitmap.createBitmap(bmp, x, y, squareWidth,
                    squareHeight);
        } else {
            squareBitmap = bmp;
        }

        if (squareBitmap.getWidth() != diameter
                || squareBitmap.getHeight() != diameter) {
            scaledSrcBmp = Bitmap.createScaledBitmap(squareBitmap, diameter,
                    diameter, true);

        } else {
            scaledSrcBmp = squareBitmap;
        }
        Bitmap output = Bitmap.createBitmap(scaledSrcBmp.getWidth(),
                scaledSrcBmp.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, scaledSrcBmp.getWidth(),
                scaledSrcBmp.getHeight());

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(scaledSrcBmp.getWidth() / 2,
                scaledSrcBmp.getHeight() / 2, scaledSrcBmp.getWidth() / 2,
                paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(scaledSrcBmp, rect, rect, paint);
        // bitmap回收(recycle导致在布局文件XML看不到效果)
        // bmp.recycle();
        // squareBitmap.recycle();
        // scaledSrcBmp.recycle();
        bmp = null;
        squareBitmap = null;
        scaledSrcBmp = null;
        return output;
    }

    public static void loadImage(Context context, File url,
                                 ImageView imageView, int resId) {

        if (url.exists()) {

            Picasso.with(context).load(url).placeholder(resId).noFade()
                    .into(imageView);
        } else {
            Picasso.with(context).load(resId).into(imageView);
        }

    }

    public static Bitmap toRoundCorner(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    public static void loadImage(Context context, String url,
                                 ImageView imageView, int resId) {


        Picasso.with(context).load(url).placeholder(resId).noFade()
                .into(imageView);


    }

    /**
     * @param context
     * @param url
     * @param imageView
     * @param width
     * @param height
     * @param resId     占位图
     */
    public static void loadResizeImage(Context context, String url,
                                       ImageView imageView, int width, int height, int resId) {


        Picasso.with(context).load(url).placeholder(resId)
                .resize(width, height).centerCrop().noFade()
                .into(imageView);


    }

    public static void loadResizeImage(Context context, File url,
                                       ImageView imageView, int width, int height, int resId) {

//		if (url.exists()) {
        Picasso.with(context).load(url).placeholder(resId)
                .resize(width, height).centerCrop().noFade()
                .into(imageView);
//		} else {
//			Picasso.with(context).load(resId).resize(width, height)
//			.centerCrop().noFade().into(imageView);

//		}

    }

    public static void loadResizeImagesdasdasd(Context context, String url,
                                               ImageView imageView, int width, int height) {


        Picasso.with(context).load(url)
                .resize(width, height).centerCrop().noFade()
                .into(imageView);


    }

    public static void loadResizeImage(Context context, String url,
                                       ImageView imageView, String width, String height, int resId) {

        try {
            if (url != null && !"".equals(url)) {
                int w = Integer.valueOf(width);
                int h = Integer.valueOf(height);

                Picasso.with(context).load(url).placeholder(resId)
                        .resize(w, h).centerCrop().noFade().into(imageView);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
