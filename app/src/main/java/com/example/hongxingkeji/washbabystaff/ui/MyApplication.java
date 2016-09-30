package com.example.hongxingkeji.washbabystaff.ui;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by Lizhangfeng on 2016/1/16 0016.
 * Description: 自定义Applications
 */
public class MyApplication extends Application {

    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        SDKInitializer.initialize(getApplicationContext());
    }


    public static MyApplication getMyApplication() {
        return myApplication;
    }

    public static Context getAppContext() {
        return myApplication.getApplicationContext();
    }

}
