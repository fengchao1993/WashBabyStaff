package com.example.hongxingkeji.washbabystaff.ui.Activity;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Adapater.LoginAdapter;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class LoginActicity extends BaseActivity implements AdapterView.OnItemClickListener{
    private ListView loginlist;

    private  List<String> list ;

    private LoginAdapter loginAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_login_acticity;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        loginlist=findViewByIdNoCast(R.id.loginlist);
        loginlist.setFocusable(false);
    }

    @Override
    public void initData() {
        list=new ArrayList<>();
        list.add("姓名：");
        list.add("员工号：");
        list.add("手机号：");
        list.add("验证码：");
        list.add("密码：");
        loginAdapter=new LoginAdapter(this,list);
        loginlist.setAdapter(loginAdapter);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }
}
