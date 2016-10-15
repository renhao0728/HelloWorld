package com.example.citru.helloworld.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class PhoneUtil {

	/**
	 * sp转px
	 * 
	 * @param context
	 * @param spValue
	 * @return
	 */
	public static int sp2px(Context context, float spValue) {
		final float scale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * scale + 0.5f);
	}

	/**
	 * px转sp
	 * 
	 * @param context
	 * @param pxValue
	 * @return
	 */
	public static int px2sp(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * �豸ʶ����
	 * 
	 */
	public static String getDeviceId(Context context) {
		TelephonyManager telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		return telephonyManager.getDeviceId();
	}

	/**
	 * AndroidId
	 */
	public static String getAndroidId(Context context) {
		String androidId = Secure.getString(context.getContentResolver(),
				Secure.ANDROID_ID);
		return androidId;
	}

	/**
	 * dp 2 px
	 * 
	 * @param context
	 * @param dp
	 * @return
	 */
	public static int Dp2Px(Context context, float dp) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}

	/**
	 * px 2 dp
	 * 
	 * @param context
	 * @param px
	 * @return
	 */
	public static int Px2Dp(Context context, float px) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}

	/**
	 * ������Ļ�Ŀ������ֵ
	 * 
	 * @param activity
	 * @return
	 */
	public static int getScreenWidth(Activity activity) {
		DisplayMetrics metric = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
		return metric.widthPixels; // ��Ļ��ȣ����أ�
	}

	/**
	 * ������Ļ�ĸ߶�����ֵ
	 * 
	 * @param activity
	 * @return
	 */
	public static int getScreenHeight(Activity activity) {
		DisplayMetrics metric = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
		return metric.heightPixels; // ��Ļ�߶ȣ����أ�
	}

	/**
	 * ��������Ϣʹ��һ��stringbuffer��������
	 * 
	 * @param context
	 * @return
	 */
	private static StringBuffer colloctDeviceInfo(Context context,
			StringBuffer sb) {

		Map<String, String> info = new HashMap<String, String>();
		info.put("crash-time",
				new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
		try {
			PackageManager pm = context.getPackageManager();// ��ð������
			PackageInfo pi = pm.getPackageInfo(context.getPackageName(),
					PackageManager.GET_ACTIVITIES);// �õ���Ӧ�õ���Ϣ������Activity
			if (pi != null) {
				String versionName = pi.versionName == null ? "null"
						: pi.versionName;
				String versionCode = pi.versionCode + "";
				info.put("versionName", versionName);
				info.put("versionCode", versionCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Field[] fields = Build.class.getDeclaredFields();// �������
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				info.put(field.getName(), field.get("").toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (Map.Entry<String, String> entry : info.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			sb.append(key + "=" + value + "\r\n");
		}

		return sb;
	}

	/**
	 * ��������Ϣʹ��һ��stringbuffer��������
	 * 
	 * @param context
	 * @return
	 */
	private static String colloctDeviceInfo(Context context) {

		StringBuffer sb = new StringBuffer();
		Map<String, String> info = new HashMap<String, String>();
		info.put("crash-time",
				new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
		try {
			PackageManager pm = context.getPackageManager();// ��ð������
			PackageInfo pi = pm.getPackageInfo(context.getPackageName(),
					PackageManager.GET_ACTIVITIES);// �õ���Ӧ�õ���Ϣ������Activity
			if (pi != null) {
				String versionName = pi.versionName == null ? "null"
						: pi.versionName;
				String versionCode = pi.versionCode + "";
				info.put("versionName", versionName);
				info.put("versionCode", versionCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Field[] fields = Build.class.getDeclaredFields();// �������
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				info.put(field.getName(), field.get("").toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (Map.Entry<String, String> entry : info.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			sb.append(key + "=" + value + "\r\n");
		}

		return sb.toString();
	}

	/**
	 * �����Ļ�߶�
	 * 
	 * @param context
	 * @return
	 */
	public static int getScreenWidth(Context context) {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.widthPixels;
	}

	/**
	 * �����Ļ���
	 * 
	 * @param context
	 * @return
	 */
	public static int getScreenHeight(Context context) {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.heightPixels;
	}

	/**
	 * ���״̬���ĸ߶�
	 * 
	 * @param context
	 * @return
	 */
	public static int getStatusHeight(Context context) {

		int statusHeight = -1;
		try {
			Class<?> clazz = Class.forName("com.android.internal.R$dimen");
			Object object = clazz.newInstance();
			int height = Integer.parseInt(clazz.getField("status_bar_height")
					.get(object).toString());
			statusHeight = context.getResources().getDimensionPixelSize(height);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusHeight;
	}

	/**
	 * ��ȡ��ǰ��Ļ��ͼ����״̬��
	 * 
	 * @param activity
	 * @return
	 */
	public static Bitmap snapShotWithStatusBar(Activity activity) {
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bmp = view.getDrawingCache();
		int width = getScreenWidth(activity);
		int height = getScreenHeight(activity);
		Bitmap bp = null;
		bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
		view.destroyDrawingCache();
		return bp;

	}

	/**
	 * ��ȡ��ǰ��Ļ��ͼ������״̬��
	 * 
	 * @param activity
	 * @return
	 */
	public static Bitmap snapShotWithoutStatusBar(Activity activity) {
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bmp = view.getDrawingCache();
		Rect frame = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
		int statusBarHeight = frame.top;

		int width = getScreenWidth(activity);
		int height = getScreenHeight(activity);
		Bitmap bp = null;
		bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height
				- statusBarHeight);
		view.destroyDrawingCache();
		return bp;

	}
}
