package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;

public class MyCenterActivity extends BaseActivity {


    @Override
    public int getContentViewId() {
        return R.layout.activity_my_center;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        findViewById(R.id.call).setOnClickListener(this);
        findViewById(R.id.exit).setOnClickListener(this);
        findViewById(R.id.message).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 123456));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        if(view.getId()==R.id.exit){
            dialog();
        }
        if(view.getId()==R.id.message){
            Intent intent=new Intent(this,MessageActivity.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.message){
            Intent intent=new Intent(this,MessageActivity.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.back){
           finish();
        }
    }
    protected void dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("确认退出吗?");

        builder.setTitle("提示");

        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                System.exit(0);
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }

        });

        builder.create().show();

    }

}
