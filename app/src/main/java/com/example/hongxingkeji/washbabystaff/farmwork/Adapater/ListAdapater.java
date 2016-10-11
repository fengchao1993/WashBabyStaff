package com.example.hongxingkeji.washbabystaff.farmwork.Adapater;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean.AlreadyfragData;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TheBean.OrderListBean;
import com.example.hongxingkeji.washbabystaff.ui.View.CircleImageView;

import java.util.List;

/**
 * 立即单适配器
 * Created by Administrator on 2016/9/28.
 */
public  class ListAdapater extends BaseAdapter {

    private Context context;

    private String paytype;

    private String paystatus;

    private List<OrderListBean> list;


    public ListAdapater(Context context) {
        this.context=context;
    }

    public void setdata(List<OrderListBean> list){
        this.list=list;
    }

    public void setdata2(List<OrderListBean> list){
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
            viewHolder.address= (TextView) view.findViewById(R.id.tv_address);
            viewHolder.other = (TextView) view.findViewById(R.id.time);
            viewHolder.beizhu= (TextView) view.findViewById(R.id.beizhu);
            viewHolder.beizhumsg= (TextView) view.findViewById(R.id.beizhumsg);
            viewHolder.headimg= (CircleImageView) view.findViewById(R.id.headimg);
            view.setTag(viewHolder);
            }else {
            viewHolder= (ViewHolder) view.getTag();
            }
            if(list.get(i).is_remarks.equals("1")){
                viewHolder.other.setTextColor(Color.parseColor("#00BBD2"));
                viewHolder.beizhu.setVisibility(View.VISIBLE);
                viewHolder.beizhumsg.setVisibility(View.VISIBLE);
                if(list.get(i).pay_type=="1"){
                    paytype="在线支付";
                }
                if(list.get(i).pay_type=="2"){
                    paytype="货到付款";
                }
                if(list.get(i).pay_status=="1"){
                    paystatus="未支付";
                }
                if(list.get(i).pay_status=="2"){
                    paystatus="已付款";
                }
            }else {
                viewHolder.other.setTextColor(Color.parseColor("#F5BC54"));
                viewHolder.beizhu.setVisibility(View.GONE);
                viewHolder.beizhumsg.setVisibility(View.GONE);
            }
            viewHolder.ordercode.setText(list.get(i).order_num);//订单编号
            viewHolder.name.setText(list.get(i).customer_name);//名字
            viewHolder.address.setText(list.get(i).address);
            viewHolder.other.setText(list.get(i).order_time);
            viewHolder.beizhumsg.setText("("+paytype+""+paystatus+")");
            viewHolder.headimg.setImageURI(Uri.parse(list.get(i).headimg));
                    return view;
    }

    public class ViewHolder{
        public TextView name;
        public TextView address;
        public TextView other;
        public TextView beizhu;
        public TextView beizhumsg;
        public TextView ordercode;
        public CircleImageView headimg;
    }
}
