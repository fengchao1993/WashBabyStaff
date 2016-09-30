package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.farmwork.Tools.StatusBarCompat;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.IntentUtils;

public class DetailActivity extends BaseActivity implements View.OnClickListener{
    private String which,name,address,other;
    private TextView tv_name,tv_address,tv_other;
    private Button anniu;
    @Override
    public int getContentViewId() {
        return R.layout.activity_detail;
    }

    @Override
    public void beforeInitView() {
        which=getIntent().getStringExtra("which");
        name=getIntent().getStringExtra("name");
        address=getIntent().getStringExtra("address");
        other=getIntent().getStringExtra("other");
        StatusBarCompat.compat(this);
    }

    @Override
    public void initView() {
        findViewByIdNoCast(R.id.detailback).setOnClickListener(this);
        tv_name=findViewByIdNoCast(R.id.name);
        tv_address=findViewByIdNoCast(R.id.address);
        tv_other=findViewByIdNoCast(R.id.other);
        anniu=findViewByIdNoCast(R.id.anniu);
        anniu.setOnClickListener(this);
//        Toast.makeText(this,which,Toast.LENGTH_LONG).show();
    }

    @Override
    public void initData() {
        if(which!=null){
            tv_name.setText(name);
            tv_address.setText(address);
            tv_other.setText(other);
            switch (which){
                case "finish":
                    anniu.setText("确定");
                    break;
                case "bring":
                    anniu.setText("已完成送货");
                    break;
                case "jishi":
                    anniu.setText("开始处理");
                    break;
                case "yuyue":
                    anniu.setText("开始处理");
                    break;
                case "already":
                    anniu.setText("改为货到付款");
                    break;
            }
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.anniu:
                if(anniu.getText()=="开始处理"){
                    IntentUtils.openActivity(this,MapActivity.class);
                }else {
                    Toast.makeText(this,"功能完善中",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.detailback:
                this.finish();
                break;
        }



    }
}
