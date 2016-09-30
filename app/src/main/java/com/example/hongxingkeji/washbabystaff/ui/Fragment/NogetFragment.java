package com.example.hongxingkeji.washbabystaff.ui.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Adapater.ListAdapater;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.IntentUtils;
import com.example.hongxingkeji.washbabystaff.ui.Activity.DetailActivity;
import com.example.hongxingkeji.washbabystaff.ui.Bean.AlreadyfragData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */
public class NogetFragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener{

    private Settitle settitle;

    private AlreadyfragData alreadyfragData,alreadyfragData1;

    private boolean b=false;

    private ListAdapater listAdapater, listAdapater1;


    private List<AlreadyfragData> list,list1;

    private ListView nowlist,yuelist;

    private LinearLayout tab1,tab2;

    private View line1,line2;

    private TextView jishidan,yuyuedan;

    //回调tab状态
    public void setSettitle(Settitle settitle) {
        this.settitle = settitle;
    }


    public static NogetFragment newInstance(String param1) {
        NogetFragment fragment = new NogetFragment();
        return fragment;
    }

    public NogetFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nogetfragment, container, false);
        listAdapater =new ListAdapater(getActivity());
        listAdapater1 =new ListAdapater(getActivity());
        nowlist= (ListView) view.findViewById(R.id.nowlist);
        yuelist= (ListView) view.findViewById(R.id.yuelist);
        tab1= (LinearLayout) view.findViewById(R.id.tab1);
        tab2= (LinearLayout) view.findViewById(R.id.tab2);
        line1=view.findViewById(R.id.line1);
        line2=view.findViewById(R.id.line2);
        jishidan= (TextView) view.findViewById(R.id.jishidan);
        jishidan.setOnClickListener(this);
        yuyuedan= (TextView) view.findViewById(R.id.yuyuedan);
        yuyuedan.setOnClickListener(this);
        //添加头部闹钟时间
        View headview=View.inflate(getActivity(),R.layout.headview_jishilist,null);
        TextView onclock= (TextView) headview.findViewById(R.id.xiadantime);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date curDate =new Date(System.currentTimeMillis());//获取当前时间
        String str=formatter.format(curDate);
        onclock.setText(str);
        nowlist.addHeaderView(headview);
        nowlist.setAdapter(listAdapater);
        yuelist.setAdapter(listAdapater1);
        list=new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            alreadyfragData=new AlreadyfragData("赵六","建设路","下单时间：一个小时前");
            list.add(alreadyfragData);
        }
        listAdapater.setdata(list);
        list1=new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            alreadyfragData1=new AlreadyfragData("路人甲","王府井","预约时间：2016年9月28日17:00-18:00");
            list1.add(alreadyfragData1);
        }
        listAdapater1.setdata(list1);
        listAdapater.notifyDataSetChanged();
        listAdapater1.notifyDataSetChanged();
        nowlist.setOnItemClickListener(this);
        yuelist.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(b==false){
            Bundle bundle=new Bundle();
            bundle.putString("which","jishi");
            bundle.putString("name",alreadyfragData.name);
            bundle.putString("address",alreadyfragData.address);
            bundle.putString("other",alreadyfragData.other);
            IntentUtils.openActivity(getActivity(), DetailActivity.class,bundle);
        }else
        if (b==true)
            {
            Bundle bundle=new Bundle();
            bundle.putString("which","yuyue");
            bundle.putString("name",alreadyfragData1.name);
            bundle.putString("address",alreadyfragData1.address);
            bundle.putString("other",alreadyfragData1.other);
            IntentUtils.openActivity(getActivity(), DetailActivity.class,bundle);
        }

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.jishidan:
                line1.setBackgroundColor(Color.parseColor("#F5BC54"));
                line2.setBackgroundColor(Color.parseColor("#ffffff"));
                jishidan.setTextColor(Color.parseColor("#F5BC54"));
                yuyuedan.setTextColor(Color.parseColor("#7f737373"));
                tab1.setVisibility(View.VISIBLE);
                tab2.setVisibility(View.GONE);
                break;
            case R.id.yuyuedan:
                line1.setBackgroundColor(Color.parseColor("#ffffff"));
                line2.setBackgroundColor(Color.parseColor("#F5BC54"));
                jishidan.setTextColor(Color.parseColor("#7f737373"));
                yuyuedan.setTextColor(Color.parseColor("#F5BC54"));
                tab1.setVisibility(View.GONE);
                tab2.setVisibility(View.VISIBLE);
                break;
        }
    }

    public interface  Settitle{
        void settitle(boolean b);
    }

}
