package com.example.hongxingkeji.washbabystaff.ui.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Adapater.ShowPhotoAdapter;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean.ImgBean;
import java.util.ArrayList;
import java.util.List;

public class WriteBzActivity extends BaseActivity{

    private EditText addtext;

    private RecyclerView recyclerView;

    private LinearLayout linearLayout;

    private ShowPhotoAdapter showPhotoAdapter;

    private  ArrayList<String> imgUri,newimgUri;

    @Override
    public int getContentViewId() {
        return R.layout.activity_write_bz;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        findViewByIdNoCast(R.id.qd).setOnClickListener(this);
        addtext=findViewByIdNoCast(R.id.addtext);
        findViewByIdNoCast(R.id.addimg).setOnClickListener(this);
        findViewByIdNoCast(R.id.carame).setOnClickListener(this);
        findViewByIdNoCast(R.id.detailback).setOnClickListener(this);
        recyclerView=findViewByIdNoCast(R.id.recyclerView);
        linearLayout=findViewByIdNoCast(R.id.linear);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,6,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        showPhotoAdapter=new ShowPhotoAdapter(this);
        recyclerView.setAdapter(showPhotoAdapter);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.qd:
                if(addtext.getText()!=null){
                    Intent intent=new Intent();
                    Bundle bundle=new Bundle();
                    bundle.putString("beizhu",addtext.getText().toString());
                    if(imgUri.size()>2){
                        newimgUri=new ArrayList<>();
                        for (int i = 0; i <imgUri.size() ; i++) {
                            if(i<imgUri.size()-2){
                                newimgUri.add(imgUri.get(i));
                            }else{
                               break;
                            }
                        }
                        bundle.putStringArrayList("imgUri",newimgUri);
                    }
                    intent.putExtras(bundle);
                    setResult(1,intent);
                    finish();
                }else{
                    finish();
                }
            break;
            case R.id.addimg:
                Intent intent = new Intent(this,ShowPhotoActivity.class);
                startActivityForResult(intent,123);
                break;
            case R.id.carame:
                Intent carame = new Intent();
                carame.setAction("android.media.action.IMAGE_CAPTURE");
                carame.addCategory("android.intent.category.DEFAULT");
                startActivity(carame); // 启动相机程序
                break;
            case R.id.detailback:
                finish();
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==123){
            if(data!=null){
                 imgUri=data.getStringArrayListExtra("ImgUri");
                linearLayout.setVisibility(View.GONE);
                if(imgUri!=null){
                    recyclerView.setVisibility(View.VISIBLE);
                    List<ImgBean> imgBeen=new ArrayList<>();
                    for (int i = 0; i <imgUri.size() ; i++) {
                        ImgBean imgbean=new ImgBean();
                        imgbean.check=true;
                        imgbean.uri=imgUri.get(i);
                        imgBeen.add(imgbean);
                    }
                    showPhotoAdapter.setData(imgBeen);
                    showPhotoAdapter.notifyDataSetChanged();
                }
            }
        }
    }


}
