package com.example.hongxingkeji.washbabystaff.ui;

import android.app.Application;
import android.content.Context;

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
    }


    public static MyApplication getMyApplication() {
        return myApplication;
    }

    public static Context getAppContext() {
        return myApplication.getApplicationContext();
    }


}
