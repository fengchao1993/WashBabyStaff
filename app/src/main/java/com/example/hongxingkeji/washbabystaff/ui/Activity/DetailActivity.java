package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.view.View;
import android.widget.TextView;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;

public class DetailActivity extends BaseActivity implements View.OnClickListener{

    @Override
    public int getContentViewId() {
        return R.layout.activity_detail;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        findViewByIdNoCast(R.id.detailback).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        this.finish();
    }
}
