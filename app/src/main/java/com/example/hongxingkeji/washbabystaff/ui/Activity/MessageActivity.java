package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Adapater.MessageAdapter;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.IntentUtils;
import com.example.hongxingkeji.washbabystaff.ui.Bean.Message;
import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends BaseActivity implements AdapterView.OnItemClickListener{
    private ListView meg_list;

    private MessageAdapter messageAdapter;

    private Message message;
    @Override
    public int getContentViewId() {
        return R.layout.activity_message;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        meg_list=findViewByIdNoCast(R.id.meg_list);
        messageAdapter=new MessageAdapter(this);
        meg_list.setAdapter(messageAdapter);
        meg_list.setOnItemClickListener(this);
        findViewByIdNoCast(R.id.msgimg_back).setOnClickListener(this);
    }

    @Override
    public void initData() {
        messageAdapter.setStrings(getData());
        messageAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.msgimg_back){
                finish();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Message message= (Message) messageAdapter.getItem(i);
                if(message!=null){
                    Bundle  bundle=new Bundle();
                    bundle.putString("msg",message.msg);
                    IntentUtils.openActivity(this,MessageDetail.class,bundle);
                }else {
                    Toast.makeText(this,"没数据",Toast.LENGTH_LONG).show();
                }
    }

    private List<Message> getData(){
        List<Message> list=new ArrayList<>();
        for (int i = 0; i <10; i++) {
            message=new Message("消息"+i,"内容"+i);
            list.add(message);
        }
        return list;
    }
}
