package com.example.hongxingkeji.washbabystaff.farmwork.Adapater;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.ui.Bean.AlreadyfragData;

import java.util.List;

/**
 * 立即单适配器
 * Created by Administrator on 2016/9/28.
 */
public  class ListAdapater extends BaseAdapter {
    private int a;

    private Context context;

    private List<AlreadyfragData> list;


    public ListAdapater(Context context) {
        this.context=context;
    }

    public void setdata(List<AlreadyfragData> list){
        this.list=list;
    }

    public void setdata2(List<AlreadyfragData> list,int a){
        this.list=list;
        this.a=a;
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
            viewHolder.address= (TextView) view.findViewById(R.id.tv_address);
            viewHolder.other = (TextView) view.findViewById(R.id.time);
            viewHolder.beizhu= (TextView) view.findViewById(R.id.beizhu);
            viewHolder.beizhumsg= (TextView) view.findViewById(R.id.beizhumsg);
            view.setTag(viewHolder);
            }else {
            viewHolder= (ViewHolder) view.getTag();
            }
            if(a==1){
                viewHolder.other.setTextColor(Color.parseColor("#00BBD2"));
                viewHolder.beizhu.setVisibility(View.VISIBLE);
                viewHolder.beizhumsg.setVisibility(View.VISIBLE);
            }else {
                viewHolder.other.setTextColor(Color.parseColor("#F5BC54"));
                viewHolder.beizhu.setVisibility(View.GONE);
                viewHolder.beizhumsg.setVisibility(View.GONE);
            }
            viewHolder.name.setText(list.get(i).name);
            viewHolder.address.setText(list.get(i).address);
            viewHolder.other.setText(list.get(i).other);
        return view;
    }

    public class ViewHolder{
        public TextView name;
        public TextView address;
        public TextView other;
        public TextView beizhu;
        public TextView beizhumsg;
    }
}
