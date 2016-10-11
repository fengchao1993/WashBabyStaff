package com.example.hongxingkeji.washbabystaff.farmwork.Adapater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hongxingkeji.washbabystaff.R;

import java.util.List;

/**
 * 立即单适配器
 * Created by Administrator on 2016/1/23.
 */
public  class MySimpleAdapater extends BaseAdapter {
    private Context context;

    private List<String> list;


    public MySimpleAdapater(Context context) {
        this.context=context;
    }

    public void setdata(List<String> list){
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
            view=View.inflate(context, R.layout.itemoforder,null);
            viewHolder.name= (TextView) view.findViewById(R.id.text1);
            viewHolder.address= (TextView) view.findViewById(R.id.text2);
            viewHolder.other = (TextView) view.findViewById(R.id.time);
            view.setTag(viewHolder);
            }else {
            viewHolder= (ViewHolder) view.getTag();
            }
            viewHolder.name.setText(list.get(i));
            viewHolder.name.setText(list.get(i));
            viewHolder.name.setText(list.get(i));
        return view;
    }

    public class ViewHolder{
        public TextView name;
        public TextView address;
        public TextView other;
    }
}
