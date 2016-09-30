package com.example.hongxingkeji.washbabystaff.ui.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.hongxingkeji.washbabystaff.R;

/**
 * 个人中心Fragment
 * Created by Administrator on 2016/9/26.
 */
public class MyFragment extends Fragment implements View.OnClickListener{
    public MyFragment() {

    }

    public static MyFragment newInstance(String param1) {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mycenter, container, false);
        view.findViewById(R.id.call).setOnClickListener(this);
        view.findViewById(R.id.exit).setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 123456));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        if(view.getId()==R.id.exit){
            dialog();
        }
    }

    protected void dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

       builder.setMessage("确认退出吗?");

         builder.setTitle("提示");

         builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {

            @Override

           public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                System.exit(0);
              }
             });

         builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override

             public void onClick(DialogInterface dialog, int which) {

                 dialog.dismiss();

                 }

             });

         builder.create().show();

         }

}
