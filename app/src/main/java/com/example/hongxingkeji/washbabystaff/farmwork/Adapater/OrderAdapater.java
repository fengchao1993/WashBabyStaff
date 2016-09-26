package com.example.hongxingkeji.washbabystaff.farmwork.Adapater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hongxingkeji.washbabystaff.R;

import java.util.List;

/**
 * Created by Administrator on 2016/1/23.
 */
public  class OrderAdapater extends BaseAdapter {
    private Context context;

    private List<String> list;


    public OrderAdapater(Context context) {
        this.context=context;
    }

    public void setdata(List<String> list){
        this.list=list;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1=View.inflate(context, R.layout.itemoforder,null);
        TextView textView1= (TextView) view1.findViewById(R.id.text1);
        TextView textView2= (TextView) view1.findViewById(R.id.text2);
        TextView textView3= (TextView) view1.findViewById(R.id.text3);
        return view1;
    }
}
