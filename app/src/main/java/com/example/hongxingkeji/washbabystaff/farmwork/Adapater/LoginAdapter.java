package com.example.hongxingkeji.washbabystaff.farmwork.Adapater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hongxingkeji.washbabystaff.R;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */
public class LoginAdapter extends BaseAdapter{
    private Context context;

    private List<String> list;

    public LoginAdapter(Context context,List<String> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        View view1=View.inflate(context, R.layout.itemofinclude,null);
        TextView name= (TextView) view1.findViewById(R.id.loginname);
        name.setText(list.get(i));
        return view1;
    }
}
