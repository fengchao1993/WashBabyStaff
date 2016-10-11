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
public class FinishFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView listView;

    private ListAdapater listAdapater;

    private List<AlreadyfragData> alreadyfragDatas;

    private AlreadyfragData alreadyfragData;

    public static FinishFragment newInstance(String param1) {
        FinishFragment fragment = new FinishFragment();
        return fragment;
    }

    public FinishFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listAdapater=new ListAdapater(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finish, container, false);
        listView= (ListView) view.findViewById(R.id.already_list);
        listView.setAdapter(listAdapater);
        listView.setOnItemClickListener(this);
        alreadyfragDatas=new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            alreadyfragData=new AlreadyfragData("王五","成都市东门大桥","完成时间：2016年9月28日 16:03");
            alreadyfragDatas.add(alreadyfragData);
        }
        listAdapater.setdata2(alreadyfragDatas,1);
        listAdapater.notifyDataSetChanged();
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        alreadyfragData= (AlreadyfragData) listAdapater.getItem(i);
        Bundle bundle=new Bundle();
        bundle.putString("which","finish");
        bundle.putString("name",alreadyfragData.name);
        bundle.putString("address",alreadyfragData.address);
        bundle.putString("other",alreadyfragData.other);
        IntentUtils.openActivity(getActivity(), DetailActivity.class,bundle);
    }
}
