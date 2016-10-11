package com.example.hongxingkeji.washbabystaff.ui.View;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.IntentUtils;
import com.example.hongxingkeji.washbabystaff.ui.Activity.SaoMiaoActivity;

/**
 * Created by Administrator on 2016/9/29.
 */
public class MyDialog extends AlertDialog implements View.OnClickListener{
    private static final String MSG1="确定开始扫码?";

    private static final String MSG2="确定取消此订单?";

    private static final String MSG3="确定删除此衣物?";

    public void setDeleteitem(DeleteItem deleteitem) {
        this.deleteitem = deleteitem;
    }

    private DeleteItem deleteitem;

    public int detele;

    private Context context;

    private Button que,dismiss;

    private TextView msg;

    private View view;

    private int i;

    private String message;

    public MyDialog(Context context, int i,String message) {
        super(context, R.style.Dialog);
        this.context=context;
        this.message=message;
        this.i=i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view=View.inflate(context, R.layout.style_dialog,null);
        msg= (TextView) view.findViewById(R.id.message);
        msg.setText(message);
        que= (Button) view.findViewById(R.id.que);
        dismiss= (Button) view.findViewById(R.id.dismiss);
        if(message==MSG2){
            que.setText("取消");
            dismiss.setText("确定");
        }
        if(message==MSG3){
            que.setText("删除");
            dismiss.setText("取消");
        }
        que.setOnClickListener(this);
        dismiss.setOnClickListener(this);
        setContentView(view);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.que:
                if(message==MSG1){
                    IntentUtils.openActivity(context, SaoMiaoActivity.class);
                    this.dismiss();
                }
                if(message==MSG2){
                    this.dismiss();
                }
                if(message==MSG3){
                   deleteitem.delete(i);
                    this.dismiss();
                }
                    break;
            case R.id.dismiss:
                if(message==MSG1){
                    this.dismiss();
                }
                if(message==MSG2){
                    this.dismiss();
                }
                if(message==MSG3){
                    this.dismiss();
                }
                break;
        }
    }

    public interface  DeleteItem{
        void delete(int i);
    }
}
