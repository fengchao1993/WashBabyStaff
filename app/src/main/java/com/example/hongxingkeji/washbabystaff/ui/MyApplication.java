package com.example.hongxingkeji.washbabystaff.ui;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import com.baidu.mapapi.SDKInitializer;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.uuzuche.lib_zxing.DisplayUtil;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by fengchao on 2016/1/26 0016.
 * Description: 自定义Applications
 */
public class MyApplication extends Application {

    private static MyApplication myApplication;

    private static String type="1";

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        SDKInitializer.initialize(getApplicationContext());
        /**
         * 初始化尺寸工具类
         */
        initDisplayOpinion();
        Fresco. initialize ( this );
        //初始化okhttp
        initOkhttp();
    }


    public static MyApplication getMyApplication() {
        return myApplication;
    }

    public static Context getAppContext() {
        return myApplication.getApplicationContext();
    }

    private void initDisplayOpinion() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        DisplayUtil.density = dm.density;
        DisplayUtil.densityDPI = dm.densityDpi;
        DisplayUtil.screenWidthPx = dm.widthPixels;
        DisplayUtil.screenhightPx = dm.heightPixels;
        DisplayUtil.screenWidthDip = DisplayUtil.px2dip(getApplicationContext(), dm.widthPixels);
        DisplayUtil.screenHightDip = DisplayUtil.px2dip(getApplicationContext(), dm.heightPixels);
    }
    /**
     * 初始化okhttp
     */
    public void initOkhttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        MyApplication.type = type;
    }
}
