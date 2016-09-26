package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Adapater.OrderAdapater;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.IntentUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener{
    private  TabHost tabHost;
    private TextView tv,tv1,titlename;
    private ListView nowlist;
    private OrderAdapater orderAdapater;

    private List<String> list;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {
        IntentUtils.openActivity(this,LoginActicity.class);
    }

    @Override
    public void initView() {
        titlename=findViewByIdNoCast(R.id.titlename);
         tabHost= (TabHost) findViewById(R.id.tabhost1);
        tabHost.setup();
        orderAdapater=new OrderAdapater(this);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("即时单").setContent(R.id.tab1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("预约单").setContent(R.id.tab2));
        setOntabchangetab();//对tab进行监听
        nowlist= (ListView) findViewById(R.id.nowlist);
        nowlist.setAdapter(orderAdapater);
        list=new ArrayList<>();
        list.add("1");
        list.add("2");
        orderAdapater.setdata(list);
        orderAdapater.notifyDataSetChanged();
        nowlist.setOnItemClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {

    }

    public void setOntabchangetab(){
        tv = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        tv.setTextColor(getResources().getColor(R.color.blue));
        tv.setTextSize(getResources().getDimension(R.dimen.Padding10));
        tv1 = (TextView) tabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title);
        tv1.setTextColor(getResources().getColor(R.color.gray));
        tv1.setTextSize(getResources().getDimension(R.dimen.Padding10));
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if("tab1"==tabHost.getCurrentTabTag()){
                    tv.setTextColor(getResources().getColor(R.color.blue));
                    tv1.setTextColor(getResources().getColor(R.color.gray));
                    titlename.setText(getResources().getString(R.string.noworder));
                }else {
                    tv1.setTextColor(getResources().getColor(R.color.blue));
                    tv.setTextColor(getResources().getColor(R.color.gray));
                    titlename.setText(getResources().getString(R.string.yueorder));
                }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        IntentUtils.openActivity(this,DetailActivity.class);
    }
}
