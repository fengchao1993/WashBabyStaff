package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Adapater.SaoMiaoDetailAdapter;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.farmwork.Tools.StatusBarCompat;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean.SaoMiaoDetailBean;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import java.util.ArrayList;
import java.util.List;

public class SaoMiaoActivity extends BaseActivity implements SaoMiaoDetailAdapter.Datachange{

    private List<SaoMiaoDetailBean> saoMiaoDetailBeanList;

    private SaoMiaoDetailAdapter adpter;

    private  View footview;

    private TextView tv_sum,tv_sum_price;

    private ListView listview;


    @Override
    public int getContentViewId() {
        return R.layout.activity_sao_miao;
    }

    @Override
    public void beforeInitView() {
        StatusBarCompat.compat(this);
    }

    @Override
    public void initView() {
        listview=findViewByIdNoCast(R.id.list);
        adpter=new SaoMiaoDetailAdapter(this);
        footview=View.inflate(this,R.layout.footview_saomiaodetail,null);
        tv_sum= (TextView) footview.findViewById(R.id.sum);
        tv_sum_price= (TextView) footview.findViewById(R.id.sum_price);
        listview.addFooterView(footview);
        listview.setAdapter(adpter);
        adpter.setDatachange(this);
    }

    @Override
    public void initData() {
    saoMiaoDetailBeanList=new ArrayList<>();
        //添加假数据
        SaoMiaoDetailBean s=new SaoMiaoDetailBean("12345","长袖T恤","¥1","",R.drawable.testclothes);
        saoMiaoDetailBeanList.add(s);
        SaoMiaoDetailBean s1=new SaoMiaoDetailBean("1234","长袖T恤","¥2","",R.drawable.testclothes);
        saoMiaoDetailBeanList.add(s1);
        SaoMiaoDetailBean s2=new SaoMiaoDetailBean("123","长袖T恤","¥3","",R.drawable.testclothes);
        saoMiaoDetailBeanList.add(s2);
        adpter.setStrings(saoMiaoDetailBeanList);
        adpter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         *  处理二维码扫描结果
         */
        if (requestCode == 123) {
                // 处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, " 解析结果 :" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(this, " 解析二维码失败 ", Toast.LENGTH_LONG).show();
                }
            }
        }
        if(data!=null){
            Bundle bundle=data.getExtras();
            if(bundle!=null){
                String beizhu=bundle.getString("beizhu");
                List<String> imgUri=bundle.getStringArrayList("imgUri");
                Log.e("TAG","2:"+imgUri.get(0));
                if(beizhu!=null){
                    adpter.setBeizhu(beizhu,requestCode);
                    adpter.notifyDataSetChanged();
                }
                if(imgUri.size()!=0){
                    adpter.setImgUri(imgUri,requestCode);
                    adpter.notifyDataSetChanged();
                }
            }
        }



    }

    @Override
    public void footSum(int sum, int yisao, int sumprice) {
        tv_sum.setText("扫描件数:"+yisao+"/"+sum);
        tv_sum_price.setText("合计:"+sumprice+"元");
    }
}
