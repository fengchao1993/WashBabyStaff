package com.example.hongxingkeji.washbabystaff.ui.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Adapater.ListAdapater;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.IntentUtils;
import com.example.hongxingkeji.washbabystaff.ui.Activity.DetailActivity;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean.AlreadyfragData;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/9/26.
 */
public class AlreadyFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView listView;

    private ListAdapater listAdapater;

    private AlreadyfragData alreadyfragData;

    private List<AlreadyfragData> alreadyfragDatas;
    public static AlreadyFragment newInstance(String param1) {
        AlreadyFragment fragment = new AlreadyFragment();
        return fragment;
    }

    public AlreadyFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listAdapater=new ListAdapater(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_already, container, false);
        listView= (ListView) view.findViewById(R.id.already_list);
        listView.setAdapter(listAdapater);
        listView.setOnItemClickListener(this);
        alreadyfragDatas=new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            alreadyfragData=new AlreadyfragData("张三","成都市东门大桥","接单时间：2016年9月28日 15:34");
            alreadyfragDatas.add(alreadyfragData);
        }
        listAdapater.setdata(alreadyfragDatas);
        listAdapater.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Bundle bundle=new Bundle();
        bundle.putString("which","already");
        bundle.putString("name",alreadyfragData.name);
        bundle.putString("address",alreadyfragData.address);
        bundle.putString("other",alreadyfragData.other);
        IntentUtils.openActivity(getActivity(), DetailActivity.class,bundle);
    }
}
