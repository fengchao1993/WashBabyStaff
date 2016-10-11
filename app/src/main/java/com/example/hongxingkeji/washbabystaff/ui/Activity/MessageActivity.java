package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Adapater.MessageAdapter;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.farmwork.Http.HttpArrayCallBack;
import com.example.hongxingkeji.washbabystaff.farmwork.Http.HttpHelper;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.IntentUtils;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TheBean.MessageBean;
import java.util.List;

public class MessageActivity extends BaseActivity implements AdapterView.OnItemClickListener{
    private ListView meg_list;

    private MessageAdapter messageAdapter;

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
        getData();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.msgimg_back){
                finish();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MessageBean message= (MessageBean) messageAdapter.getItem(i);
                if(message!=null){
                    Bundle  bundle=new Bundle();
                    bundle.putString("msg",message.content);
                    IntentUtils.openActivity(this,MessageDetail.class,bundle);
                }
    }

    private void getData(){
        HttpHelper.MessageRequest(new HttpArrayCallBack<MessageBean>() {
            @Override
            public void onSuccess(List<MessageBean> result) {
                if(result!=null){
                    messageAdapter.setStrings(result);
                    messageAdapter.notifyDataSetChanged();
                }

            }
            @Override
            public void onFail(String errMsg) {
                Toast.makeText(MessageActivity.this,errMsg.toString(),Toast.LENGTH_LONG).show();
                Log.e("TAG",errMsg.toString());
            }
        });
    }
}
