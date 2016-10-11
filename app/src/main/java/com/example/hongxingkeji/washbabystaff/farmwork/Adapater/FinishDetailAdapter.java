package com.example.hongxingkeji.washbabystaff.farmwork.Adapater;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean.BringDatailBean;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean.FinishBean;

import java.util.List;

/**
 * 完成单适配器
 * Created by Administrator on 2016/9/28.
 */
public  class FinishDetailAdapter extends BaseAdapter {
    private Context context;

    private List<FinishBean> list;

    public FinishDetailAdapter(Context context) {
        this.context=context;
    }

    public void setdata(List<FinishBean> list){
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
            view=View.inflate(context, R.layout.item_fragfinishdetail,null);
            viewHolder.imageView= (ImageView) view.findViewById(R.id.clothes_img);
            viewHolder.num= (TextView) view.findViewById(R.id.num);
            viewHolder.price= (TextView) view.findViewById(R.id.price);
            viewHolder.clothestype= (TextView) view.findViewById(R.id.clothertype);
            view.setTag(viewHolder);
            }else {
            viewHolder= (ViewHolder) view.getTag();
            }
            viewHolder.num.setText(list.get(i).sum);
            viewHolder.price.setText(list.get(i).price);
            viewHolder.clothestype.setText(list.get(i).type);
//            viewHolder.imageView.setImageResource();
             return view;
    }

    public class ViewHolder{
        public TextView clothestype,num,price;
        public ImageView imageView;
    }
}
