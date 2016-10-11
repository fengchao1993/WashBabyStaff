package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.view.View;
import android.widget.TextView;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;

public class MessageDetail extends BaseActivity {
    private String msg;
    private TextView messagedetail;

    @Override
    public int getContentViewId() {
        return R.layout.activity_msgdetail;
    }

    @Override
    public void beforeInitView() {
        msg=getIntent().getStringExtra("msg");
    }

    @Override
    public void initView() {
        messagedetail=findViewByIdNoCast(R.id.message);
        findViewByIdNoCast(R.id.msgimgdetail_back).setOnClickListener(this);
    }

    @Override
    public void initData() {
        if(msg!=null)
            messagedetail.setText("  "+msg);
        else
            messagedetail.setText("没拿到数据");
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.msgimgdetail_back){
            finish();
        }
    }
}
