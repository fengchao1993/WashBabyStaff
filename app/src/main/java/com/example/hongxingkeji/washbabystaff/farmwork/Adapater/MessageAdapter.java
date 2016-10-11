package com.example.hongxingkeji.washbabystaff.farmwork.Adapater;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.LogUtils;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean.Message;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TheBean.MessageBean;

import java.util.List;

/**
 * 消息适配器
 * Created by Administrator on 2016/9/27.
 */
public class MessageAdapter extends BaseAdapter{
    private Context context;

    private List<MessageBean> strings;

    public MessageAdapter(Context context) {
        this.context=context;
    }

    public void setStrings(List<MessageBean> strings) {
        this.strings = strings;
    }

    @Override
    public int getCount() {
        return strings==null?0:strings.size();
    }

    @Override
    public Object getItem(int i) {
        return strings==null?null:strings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view==null) {
            view=View.inflate(context, R.layout.item_msg,null);
            viewHolder=new ViewHolder();
            viewHolder.title= (TextView) view.findViewById(R.id.msgtitle);
            viewHolder.msg= (TextView) view.findViewById(R.id.msg_content);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
            }
        viewHolder.msg.setText(strings.get(i).content);
        LogUtils.e("TAGGGG"+strings.get(i).content);
        viewHolder.title.setText("发布时间:"+strings.get(i).time);
        return view;
    }

    public class ViewHolder{
        public TextView title;
        public TextView msg;
    }
}
