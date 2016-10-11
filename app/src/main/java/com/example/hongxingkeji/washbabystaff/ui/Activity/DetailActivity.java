package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.farmwork.Tools.StatusBarCompat;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.IntentUtils;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.AlreadyDetailFragment;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.BringDetailFragment;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.FinishDetailFragment;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.NowDetailFragment;
import com.example.hongxingkeji.washbabystaff.ui.Fragment.YuYueDetailFragment;

import java.util.List;

public class DetailActivity extends BaseActivity implements View.OnClickListener{
    private String which,name,address,other;

    private TextView tv_name,tv_address,tv_other;

    private Button anniu;

    private NowDetailFragment nowfrag;
    private BringDetailFragment bringfrag;
    private FinishDetailFragment finishfrag;
    private AlreadyDetailFragment alreadyfrag;
    private YuYueDetailFragment yuyuefrag;

    private LinearLayout ll_now,ll_bring,ll_finish,ll_already,ll_yuyue;

    private LinearLayout[] ll=new LinearLayout[]{ll_now,ll_bring,ll_finish,ll_already,ll_yuyue};

    private int[] ll_id=new int[]{R.id.ll_jishi,R.id.ll_bring,R.id.ll_finish,R.id.ll_already,R.id.ll_yuyue};

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
        Log.e("TAGG",which+","+name+","+address+","+other);
        StatusBarCompat.compat(this);
    }

    @Override
    public void initView() {
        findViewByIdNoCast(R.id.detailback).setOnClickListener(this);
        tv_name=findViewByIdNoCast(R.id.name);
        tv_address=findViewByIdNoCast(R.id.address);
        tv_other=findViewByIdNoCast(R.id.other);
        anniu=findViewByIdNoCast(R.id.anniu);
        nowfrag= (NowDetailFragment) getSupportFragmentManager().findFragmentById(R.id.now_fragment);
        bringfrag= (BringDetailFragment) getSupportFragmentManager().findFragmentById(R.id.bring_fragment);
        finishfrag= (FinishDetailFragment) getSupportFragmentManager().findFragmentById(R.id.finish_fragment);
        alreadyfrag= (AlreadyDetailFragment) getSupportFragmentManager().findFragmentById(R.id.already_fragment);
        yuyuefrag= (YuYueDetailFragment) getSupportFragmentManager().findFragmentById(R.id.yuyue_fragment);
        for (int i = 0; i <ll.length ; i++) {
            ll[i]=findViewByIdNoCast(ll_id[i]);
        }
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
                    for (int i = 0; i <ll.length ; i++) {
                       ll[i].setVisibility(View.GONE);
                    }
                    ll[2].setVisibility(View.VISIBLE);
                    anniu.setText("确定");
                    break;
                case "bring":
                    for (int i = 0; i <ll.length ; i++) {
                        ll[i].setVisibility(View.GONE);
                    }
                    ll[1].setVisibility(View.VISIBLE);
                    anniu.setText("已完成送货");
                    break;
                case "jishi":
                    for (int i = 0; i <ll.length ; i++) {
                        ll[i].setVisibility(View.GONE);
                    }
                    ll[0].setVisibility(View.VISIBLE);
                    anniu.setText("开始处理");
                    break;
                case "yuyue":
                    for (int i = 0; i <ll.length ; i++) {
                        ll[i].setVisibility(View.GONE);
                    }
                    ll[4].setVisibility(View.VISIBLE);
                    anniu.setText("开始处理");
                    break;
                case "already":
                    for (int i = 0; i <ll.length ; i++) {
                        ll[i].setVisibility(View.GONE);
                    }
                    ll[3].setVisibility(View.VISIBLE);
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
