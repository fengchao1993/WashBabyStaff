package com.example.hongxingkeji.washbabystaff.farmwork.Adapater;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean.AlreadyDatailBean;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean.AlreadyfragData;

import java.util.List;

/**
 * 已接单适配器
 * Created by Administrator on 2016/9/28.
 */
public  class AlreadyGetDetailAdapter extends BaseAdapter {
    private int a;

    private Context context;

    private SMDetailReAdapter smDetailReAdapter;

    private List<AlreadyDatailBean> list;

    public AlreadyGetDetailAdapter(Context context) {
        this.context=context;
    }

    public void setdata(List<AlreadyDatailBean> list){
        this.list=list;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int i) {
        return list==null?null:list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            viewHolder=new ViewHolder();
            view=View.inflate(context, R.layout.item_fragalreadydetail,null);
            viewHolder.clothescode= (TextView) view.findViewById(R.id.clothescode);
            viewHolder.price= (TextView) view.findViewById(R.id.price);
            viewHolder.beizhu= (TextView) view.findViewById(R.id.beizhu);
            viewHolder.recyclerView= (RecyclerView) view.findViewById(R.id.recyclerView);
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context,4,GridLayoutManager.VERTICAL,false);
            viewHolder.recyclerView.setLayoutManager(layoutManager);
            view.setTag(viewHolder);
            }else {
            viewHolder= (ViewHolder) view.getTag();
            }
            viewHolder.clothescode.setText(list.get(i).clothescode);
            viewHolder.price.setText(list.get(i).price);
            viewHolder.beizhu.setText(list.get(i).beizhu);
        //给RecyclerView传递数据
            smDetailReAdapter=new SMDetailReAdapter(context,list.get(i).imglist);
            viewHolder.recyclerView.setAdapter(smDetailReAdapter);
             return view;
    }

    public class ViewHolder{
        public TextView clothescode,beizhu,price;
        public RecyclerView recyclerView;
    }
}
