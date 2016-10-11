package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.farmwork.Tools.StatusBarCompat;
import com.uuzuche.lib_zxing.activity.CaptureActivity;

    //第二种员工进入界面
public class Main2Activity extends BaseActivity {

    private ImageView message;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main2;
    }

    @Override
    public void beforeInitView() {
        StatusBarCompat.compat(this,getResources().getColor(R.color.blue));
    }

    @Override
    public void initView() {
        message=findViewByIdNoCast(R.id.message);
        message.setOnClickListener(this);
        findViewByIdNoCast(R.id.mycenter).setOnClickListener(this);
        findViewById(R.id.wash).setOnClickListener(this);
        findViewById(R.id.outofku).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.message:
                Intent intent=new Intent(this,MessageActivity.class);
                startActivity(intent);
            break;
            case R.id.mycenter:
                Intent mycenter=new Intent(this,MyCenterActivity.class);
                startActivity(mycenter);
                break;
            case R.id.wash:
                Intent wash=new Intent(this,CaptureActivity.class);
                startActivityForResult(wash,100);
                break;
            case R.id.outofku:
                Intent outofku=new Intent(this,OutofKuAcitivity.class);
                startActivity(outofku);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //当返回码不为空时，跳转到物品信息界面


    }
}
