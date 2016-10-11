package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.farmwork.Http.HttpArrayCallBack;
import com.example.hongxingkeji.washbabystaff.farmwork.Http.HttpHelper;
import com.example.hongxingkeji.washbabystaff.farmwork.Tools.StatusBarCompat;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.IntentUtils;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.LogUtils;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.StringUtils;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TheBean.OrderListBean;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.AlreadyFragment;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.BringFragment;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.FinishFragment;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.MyFragment;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.NogetFragment;
import com.example.hongxingkeji.washbabystaff.ui.MyApplication;

import java.util.List;

public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener{
    private TextView titlename,gonghao;

    private String type="";

    private String tag;

    private FragmentTabHost fragmentTabHost;

    private List<OrderListBean> orderListBeen;

    private TabWidget tabWidget;

    private String username,staffcode,staff_id,headimg;

    private Fragment fragment;

    private AlreadyFragment alreadyFragment;

    private BringFragment bringFragment;

    private

    private NogetFragment nogetFragment1;

    private Class[] frags=new Class[]{NogetFragment.class,AlreadyFragment.class,BringFragment.class,FinishFragment.class,MyFragment.class};

    private String[] titles=new String[]{"未接","已接","送货","完成","我的"};

    private String[] tabs=new String[]{"a","b","c","d","e"};

    private String[] Toptitle=new String[]{"立即订单","已接订单","送货订单","完成订单","个人中心"};

    private int[] tabimgshen=new int[]{R.drawable.weijie,R.drawable.yijie,R.drawable.song,R.drawable.wancheng,R.drawable.wode};

    private int[] tabimgqian=new int[]{R.drawable.weijieq,R.drawable.yijieq,R.drawable.songhuo,R.drawable.wanchengq,R.drawable.wodeq};

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {
        Intent intent=getIntent();
        //拿取登录界面的数据
        Bundle bundle=intent.getExtras();
        if(bundle!=null){
            username=bundle.getString("username");
            staffcode=bundle.getString("staffcode");
            staff_id=bundle.getString("staff_id");
            headimg=bundle.getString("headimg");
        }else {
            IntentUtils.openActivity(this,LoginActicity.class);
            finish();
        }

    }
    @Override
    public void initView() {
        StatusBarCompat.compat(this,getResources().getColor(R.color.blue));
        titlename=findViewByIdNoCast(R.id.titlename);
        gonghao=findViewByIdNoCast(R.id.gonghao);
        fragmentTabHost=findViewByIdNoCast(android.R.id.tabhost);
        findViewByIdNoCast(R.id.message).setOnClickListener(this);
        buildtab();
    }

    @Override
    public void initData() {
        if(!StringUtils.isEmpty(staff_id)){
            getData("1");
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.message:
                IntentUtils.openActivity(this,MessageActivity.class);
            break;
        }
    }
    //添加tab
    public  void buildtab(){
        fragmentTabHost.setup(this,getSupportFragmentManager(),R.id.frag);
        tabWidget = fragmentTabHost.getTabWidget();
        tabWidget.setDividerDrawable(null);
        for (int i = 0; i < frags.length; i++) {
            TabHost.TabSpec spec = fragmentTabHost.newTabSpec(tabs[i]).setIndicator(initTab(i));
            fragmentTabHost.addTab(spec, frags[i], null);
        }
        fragmentTabHost.setOnTabChangedListener(this);
        titlename.postDelayed(new Runnable() {
            @Override
            public void run() {
             tag=fragmentTabHost.getCurrentTabTag();
            LogUtils.e("TAG"+tag);
                fragment=getSupportFragmentManager().findFragmentByTag(tag);
                //获取FragmentTabHost里的Fragment对象并实现回调
        if(fragment!=null&&fragment instanceof NogetFragment){
            nogetFragment1= (NogetFragment) fragment;
            nogetFragment1.setType(new NogetFragment.Type() {
                @Override
                public void setType(String type) {
                    MyApplication.setType(type);
                    getData("1");
                }
            });
            nogetFragment1.setSettitle(new NogetFragment.Settitle() {
                @Override
                public void settitle(boolean b) {
                    if(b==true){
                    titlename.setText("预约订单");
                    }else {
                    titlename.setText("立即订单");
                    }
                }
            });
            titlename.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(orderListBeen!=null){
                        nogetFragment1.setOrderListBeen(orderListBeen);
                        LogUtils.e("Jinlaileorder");
                    }
                }
            },500);

        }
            }
        },500);

    }

    @Override
    public void onTabChanged(String s) {
       if(StringUtils.isEmpty(staff_id)){
           return;
       }
        for (int i = 0; i < tabWidget.getTabCount(); i++) {
            View view = tabWidget.getChildTabViewAt(i);
            TextView tab_title = (TextView) view.findViewById(R.id.tabtext);
            ImageView tab_icon = (ImageView) view.findViewById(R.id.img);
            if (i == fragmentTabHost.getCurrentTab()) {
                if(i==0){
                    MyApplication.setType("1");
                }else{
                    MyApplication.setType("");
                }
                switch(i){
                    case 0:
                        getData("1");
                    break;
                    case 1:
                         tag=fragmentTabHost.getCurrentTabTag();
                        fragment=getSupportFragmentManager().findFragmentByTag(tag);
                        alreadyFragment= (AlreadyFragment) fragment;
                        alreadyFragment.getId();
                        getData("3");
                    break;
                    case 2:
                         tag=fragmentTabHost.getCurrentTabTag();
                        fragment=getSupportFragmentManager().findFragmentByTag(tag);
                        alreadyFragment= (AlreadyFragment) fragment;
                        alreadyFragment.getId();
                        getData("3");
                        getData("7");
                    break;
                    case 3:
                         tag=fragmentTabHost.getCurrentTabTag();
                        fragment=getSupportFragmentManager().findFragmentByTag(tag);
                        alreadyFragment= (AlreadyFragment) fragment;
                        alreadyFragment.getId();
                        getData("3");
                        getData("8");
                    break;
                }
                if(i==4){
                    gonghao.setVisibility(View.INVISIBLE);
                }else {
                    gonghao.setVisibility(View.VISIBLE);
                }
                titlename.setText(Toptitle[i]);
                view.setBackgroundColor(getResources().getColor(R.color.blue));
                tab_icon.setImageResource(tabimgqian[i]);
                tab_title.setTextColor(Color.parseColor("#ffffff"));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.white));
                tab_title.setTextColor(Color.parseColor("#000000"));
                tab_icon.setImageResource(tabimgshen[i]);
            }
        }
    }
    public View initTab(int index) {
        View view = View.inflate(this, R.layout.tab, null);
        TextView tv1 = (TextView) view.findViewById(R.id.tabtext);
        tv1.setText(titles[index]);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        img.setImageResource(tabimgshen[index]);
        return view;
    }
    //请求网络获取数据
    private void getData(String status){
        type=MyApplication.getType();
        //未接单的请求
        if(!type.equals("")){
            //1即时单，2预约单
            HttpHelper.OrderListRequest(status, staff_id, type, new HttpArrayCallBack<OrderListBean>() {
                @Override
                public void onSuccess(List<OrderListBean> result) {
                    LogUtils.e(result.toString());
                    orderListBeen=result;
                    orderListBeen.add(new OrderListBean("123"));
                    LogUtils.e("123");
                }
                @Override
                public void onFail(String errMsg) {
                    Toast.makeText(MainActivity.this,errMsg,Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            //其他单的请求
            HttpHelper.OrderListRequest(status, staff_id, null, new HttpArrayCallBack<OrderListBean>() {
                @Override
                public void onSuccess(List<OrderListBean> result) {

                }

                @Override
                public void onFail(String errMsg) {

                }
            });
        }

    }

}
