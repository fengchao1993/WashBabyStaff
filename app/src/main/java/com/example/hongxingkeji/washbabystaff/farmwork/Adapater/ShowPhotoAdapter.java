package com.example.hongxingkeji.washbabystaff.farmwork.Adapater;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean.ImgBean;
import com.example.hongxingkeji.washbabystaff.ui.Activity.ShowPhotoActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/10/8.
 */
public class ShowPhotoAdapter extends RecyclerView.Adapter<ShowPhotoAdapter.MyViewHolder>{
    private Activity context;

    private List<ImgBean> dataList;

    public ShowPhotoAdapter(Activity context){
        this.context = context;
    }

    public void setData(List<ImgBean> dataList){
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(dataList.get(0).check==true){
            View view=View.inflate(context,R.layout.item_writephoto,null);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            myViewHolder.img = (SimpleDraweeView) view.findViewById(R.id.photo);
            return myViewHolder;
        }else{
            View view = View.inflate(context, R.layout.item_showphoto,null);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            myViewHolder.checkBox = (CheckBox) view.findViewById(R.id.check);
            myViewHolder.img = (SimpleDraweeView) view.findViewById(R.id.photo);
            return myViewHolder;
        }

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        if(dataList.get(0).check==true){
            Log.e("TAG","position:"+position);
            if(position==dataList.size()-1){
                holder.img.setImageResource(R.mipmap.testcarema);
                holder.img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent carame = new Intent();
                        carame.setAction("android.media.action.IMAGE_CAPTURE");
                        carame.addCategory("android.intent.category.DEFAULT");
                        context.startActivity(carame); // 启动相机程序
                    }
                });
                return;
            }
            if(position==dataList.size()-2){
                holder.img.setImageResource(R.mipmap.testimg);
                holder.img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context,ShowPhotoActivity.class);
                        context.startActivityForResult(intent,123);
                    }
                });
                return;
            }

            Log.e("TAG","position2:"+position);
            holder.img.setImageURI(Uri.parse(dataList.get(position).uri));

            return;
        }else {
            holder.checkBox.setVisibility(View.VISIBLE);
        }
        holder.img.setImageURI(Uri.parse(dataList.get(position).uri));
        holder.checkBox.setChecked(false);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dataList.get(position).check==true){
                    holder.checkBox.setChecked(false);
                    dataList.get(position).check = false;
                }else{
                    holder.checkBox.setChecked(true);
                    dataList.get(position).check = true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (dataList==null){
            return 0;
        }else if (dataList.get(0).check==true){
            return dataList.size();
        }
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkBox;
        private SimpleDraweeView img;
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
