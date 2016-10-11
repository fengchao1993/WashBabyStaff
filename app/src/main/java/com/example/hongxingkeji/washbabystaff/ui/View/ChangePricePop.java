package com.example.hongxingkeji.washbabystaff.ui.View;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import com.example.hongxingkeji.washbabystaff.R;

/**
 * Created by Administrator on 2016/10/4 0004.
 * 自定义Popuowindow
 */
public class ChangePricePop extends PopupWindow{
    private EditText editText;

    private Button que,dismiss;

    private GetPrice getPrice;

    private int x;

    private Activity activity;

    private String price;

    public void setGetPrice(GetPrice getPrice) {
        this.getPrice = getPrice;
    }

    public ChangePricePop(Context context) {
        this(context,null);
    }

    public ChangePricePop(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ChangePricePop(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context){
        View view=View.inflate(context, R.layout.view_changgepricepop,null);
        editText= (EditText) view.findViewById(R.id.price);
        view.findViewById(R.id.queding).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText()!=null){
                   getPrice.getprice(editText.getText().toString(),x);
                }
                dismiss();
            }
        });
        view.findViewById(R.id.dismiss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        //popWindow相关设置
        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        this.setBackgroundDrawable(context.getResources().getDrawable(
                R.drawable.shape));
    }

    public  void  ShowPop(Activity activity,int x){
        this.x=x;
        this.activity=activity;
        WindowManager.LayoutParams lp;
        lp= activity.getWindow().getAttributes();
        if(isShowing()){
           return;
        }else {
            showAtLocation(activity.findViewById(R.id.main), Gravity.BOTTOM,0,0);
            lp.alpha = 0.5f; //0.0-1.0
        }
        activity.getWindow().setAttributes(lp);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        WindowManager.LayoutParams lp;
        lp= activity.getWindow().getAttributes();
        lp.alpha = 1.0f; //0.0-1.0
        activity.getWindow().setAttributes(lp);
    }

    public interface GetPrice{
        void getprice(String a,int i);
    }
}
