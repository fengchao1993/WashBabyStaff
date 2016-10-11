package com.example.hongxingkeji.washbabystaff.ui.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Adapater.AlreadyGetDetailAdapter;

/**
 * Created by Administrator on 2016/9/26.
 */
public class FinishDetailFragment extends Fragment{
    private ListView listView;

    private AlreadyGetDetailAdapter alreadyGetDetailAdapter;

    private TextView sum,sum_price,gongji;

    public FinishDetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alreadyGetDetailAdapter=new AlreadyGetDetailAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detailfinish, container, false);
        listView= (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(alreadyGetDetailAdapter);
        //添加脚部
        View footview=View.inflate(getActivity(),R.layout.footview_fragalreadydetail,null);
        sum= (TextView) footview.findViewById(R.id.sum);
        sum_price= (TextView) footview.findViewById(R.id.sum_price);
        gongji= (TextView) footview.findViewById(R.id.gongji);
        gongji.setVisibility(View.GONE);
        sum.setVisibility(View.GONE);
        listView.addFooterView(footview);
//        alreadyGetDetailAdapter.notifyDataSetChanged();
        return view;
    }

}
