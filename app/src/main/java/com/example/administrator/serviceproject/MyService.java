package com.example.administrator.serviceproject;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2018/1/16.
 */

public class MyService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "---------onStartCommand----第二个执行---");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //这里是模拟程序挂掉  ANR
//        try {
//            Thread.sleep(60000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Log.d("MyService", "---------onCreate---第一个执行----");
        //开启前台服务
        openFrontService();
    }

    private void openFrontService() {
        Notification.Builder localBuilder = new Notification.Builder(this);
        localBuilder.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0));
        localBuilder.setAutoCancel(false);
        localBuilder.setSmallIcon(R.mipmap.ic_launcher);
        localBuilder.setTicker("有新的消息");
        localBuilder.setContentTitle("APP更新");
        localBuilder.setContentText("下载中...");
        startForeground(1, localBuilder.getNotification());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MyService", "---------onBind-------");
        return myBind;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService", "---------onDestroy---杀死执行----");
    }

    private MyBind myBind = new MyBind();

    class MyBind extends Binder {
        public void startDownload() {
            Log.d("MyService", "----------执行具体的下载任务-------");
            // 执行具体的下载任务

        }
    }
}
