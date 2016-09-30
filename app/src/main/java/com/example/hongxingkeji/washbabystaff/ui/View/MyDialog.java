package com.example.hongxingkeji.washbabystaff.ui.View;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/9/29.
 */
public class MyDialog extends Dialog{

    private int layout;

    public MyDialog(Context context, int themeResId,int layout) {
        super(context, themeResId);
        this.layout=layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
    }

}
