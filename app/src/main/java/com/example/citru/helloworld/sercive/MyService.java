package com.example.citru.helloworld.sercive;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public static final String ACTION = "com.example.citru.helloworld.service";
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(), "启动Service成功",Toast.LENGTH_SHORT).show();
        super.onCreate();
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplicationContext(), "Service已销毁",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
