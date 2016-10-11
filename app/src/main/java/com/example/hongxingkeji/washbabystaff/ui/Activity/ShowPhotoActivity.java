package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Adapater.ShowPhotoAdapter;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean.ImgBean;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class ShowPhotoActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private ShowPhotoAdapter showPhotoAdapter;

    private List<ImgBean> imageUrls;

    private List<ImgBean> imageSelect;

    private Button que;

    @Override
    public int getContentViewId() {
        return R.layout.activity_show_photo;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        imageUrls = new ArrayList<ImgBean>();
        imageSelect = new ArrayList<ImgBean>();//选中的图片组
        que=(Button) findViewById(R.id.que);
        que.setOnClickListener(this);
        findViewByIdNoCast(R.id.dismiss).setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(layoutManager);
        showPhotoAdapter = new ShowPhotoAdapter(this);
        showPhotoAdapter.setData(getImageResource());
        recyclerView.setAdapter(showPhotoAdapter);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.que:
                if(imageUrls.size()!=0){
                    //回传照片地址
                    ArrayList<String> imguri=new ArrayList<>();
                    for (int i=0;i<imageUrls.size();i++){
                        if (imageUrls.get(i).check == true){
                            imguri.add(imageUrls.get(i).uri);
                        }
                    }
                    if(imguri.size()>4){
                        Toast.makeText(this,"最多选取4张图片~",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    imguri.add("photo");
                    imguri.add("carema");
                    Intent intent=new Intent();
                    Bundle bundle=new Bundle();
                    bundle.putStringArrayList("ImgUri",imguri);
                    intent.putExtras(bundle);
                    setResult(1,intent);
                }
                finish();
                break;
            case R.id.dismiss:
                finish();
                break;
        }
    }

    //获取系统照片资源
    public List<ImgBean> getImageResource(){
        Cursor c = getContentResolver().query( MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null );
        if ( c != null ) {
            if (c.moveToFirst()) {
                do {
                    long id = c.getLong(c.getColumnIndex( MediaStore.Images.Media._ID));
                    Uri imageUri = Uri.parse( MediaStore.Images.Media.EXTERNAL_CONTENT_URI + "/" + id );
                    imageUrls.add(new ImgBean(imageUri.toString()));
                } while (c.moveToNext());
            }
        }
        c.close();
        LogUtils.e("TAA",""+imageUrls.size());
        return imageUrls;
    }
}
