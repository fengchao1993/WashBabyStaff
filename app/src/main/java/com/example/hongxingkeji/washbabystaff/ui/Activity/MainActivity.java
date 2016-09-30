package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.graphics.Color;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.farmwork.Tools.StatusBarCompat;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.IntentUtils;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.AlreadyFragment;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.BringFragment;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.FinishFragment;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.MyFragment;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.NogetFragment;

public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener,NogetFragment.Settitle{
    private TextView titlename,gonghao;

    private LinearLayout mainfrag;

    private FragmentTabHost fragmentTabHost;

    private TabWidget tabWidget;

    private NogetFragment nogetFragment;

    private Class[] frags=new Class[]{NogetFragment.class,AlreadyFragment.class,BringFragment.class,FinishFragment.class,MyFragment.class};

    private String[] titles=new String[]{"未接","已接","送货","完成","我的"};

    private String[] tabs=new String[]{"未接","已接","送货","完成","我的"};

    private String[] Toptitle=new String[]{"立即订单","已接订单","送货订单","完成订单","个人中心"};

    private int[] tabimgshen=new int[]{R.drawable.weijie,R.drawable.yijie,R.drawable.song,R.drawable.wancheng,R.drawable.wode};

    private int[] tabimgqian=new int[]{R.drawable.weijieq,R.drawable.yijieq,R.drawable.songhuo,R.drawable.wanchengq,R.drawable.wodeq};

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
        StatusBarCompat.compat(this,getResources().getColor(R.color.blue));
        mainfrag=findViewByIdNoCast(R.id.mainfrag);
        titlename=findViewByIdNoCast(R.id.titlename);
        gonghao=findViewByIdNoCast(R.id.gonghao);
        fragmentTabHost=findViewByIdNoCast(android.R.id.tabhost);
        findViewByIdNoCast(R.id.message).setOnClickListener(this);
        buildtab();
//        nogetFragment= (NogetFragment) getSupportFragmentManager().findFragmentByTag(tabs[0]);
//        nogetFragment.setSettitle(this);
    }

    @Override
    public void initData() {

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
        fragmentTabHost.setOnTabChangedListener(this);
        tabWidget = fragmentTabHost.getTabWidget();
        tabWidget.setDividerDrawable(null);
        for (int i = 0; i < frags.length; i++) {
            TabHost.TabSpec spec = fragmentTabHost.newTabSpec(tabs[i]).setIndicator(initTab(i));
            fragmentTabHost.addTab(spec, frags[i], null);
        }
    }

    @Override
    public void onTabChanged(String s) {
        for (int i = 0; i < tabWidget.getTabCount(); i++) {
            View view = tabWidget.getChildTabViewAt(i);
            TextView tab_title = (TextView) view.findViewById(R.id.tabtext);
            ImageView tab_icon = (ImageView) view.findViewById(R.id.img);
            if (i == fragmentTabHost.getCurrentTab()) {
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

    @Override
    public void settitle(boolean b) {
        if(b==false){
            titlename.setText(getResources().getString(R.string.noworder));
        }else {
            titlename.setText(getResources().getString(R.string.yueorder));
        }
    }
}
