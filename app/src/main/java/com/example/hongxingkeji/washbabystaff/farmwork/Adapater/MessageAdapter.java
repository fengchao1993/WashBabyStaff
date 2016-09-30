package com.example.hongxingkeji.washbabystaff.farmwork.Adapater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.ui.Bean.Message;

import java.util.List;

/**
 * 消息适配器
 * Created by Administrator on 2016/9/27.
 */
public class MessageAdapter extends BaseAdapter{
    private Context context;

    private List<Message> strings;
    public MessageAdapter(Context context) {
    this.context=context;
    }

    public void setStrings(List<Message> strings) {
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
        viewHolder.msg.setText(strings.get(i).msg);
        viewHolder.title.setText(strings.get(i).title);
        return view;
    }

    public class ViewHolder{
        public TextView title;
        public TextView msg;
    }
}
