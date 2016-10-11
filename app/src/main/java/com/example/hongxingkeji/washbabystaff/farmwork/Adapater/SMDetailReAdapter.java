package com.example.hongxingkeji.washbabystaff.farmwork.Adapater;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean.TextBean;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

/**
 * Created by Administrator on 2016/10/8.
 */
public class SMDetailReAdapter extends RecyclerView.Adapter<SMDetailReAdapter.MyViewHolder>{
    private Context context;

    private List<String> dataList;

    private List<String> textBeen;

    public SMDetailReAdapter(Context context) {
        this.context = context;
    }

    public SMDetailReAdapter(Context context, List<String> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public void setTextBeen(List<String> textBeen) {
        this.textBeen = textBeen;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(textBeen==null){
            View view = View.inflate(context, R.layout.item_writephoto,null);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            myViewHolder.img = (SimpleDraweeView) view.findViewById(R.id.photo);
            return myViewHolder;
        }else {
            View view=View.inflate(context,R.layout.item_recyclerviewtext,null);
            MyViewHolder myViewHolder=new MyViewHolder(view);
            myViewHolder.textView= (TextView) view.findViewById(R.id.text);
            return myViewHolder;
        }

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if(textBeen==null){
            holder.img.setImageURI(Uri.parse(dataList.get(position)));
        }else{
            holder.textView.setText(textBeen.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0:dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView img;
        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
