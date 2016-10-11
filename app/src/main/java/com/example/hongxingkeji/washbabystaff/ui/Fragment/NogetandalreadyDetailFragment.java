package com.example.hongxingkeji.washbabystaff.ui.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Adapater.ListAdapater;

/**
 * Created by Administrator on 2016/9/26.
 */
public class NogetandalreadyDetailFragment extends Fragment{
    private ListView listView;

    private ListAdapater listAdapater;

    public NogetandalreadyDetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listAdapater=new ListAdapater(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detailnow, container, false);
        listView= (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(listAdapater);
        listAdapater.notifyDataSetChanged();
        return view;
    }

}
