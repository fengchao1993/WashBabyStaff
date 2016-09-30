package com.example.hongxingkeji.washbabystaff.ui.Activity;


import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.DisplayUtil;

/**
 * 注册界面
 */
public class SignupActivity extends BaseActivity {
    private LinearLayout signup_order;

    private RadioButton radioget,radiowork;

    private ImageView mima_img;

    private EditText login_edpw;

    private boolean b;

    @Override
    public int getContentViewId() {
        return R.layout.activity_signup;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        findViewByIdNoCast(R.id.signupback).setOnClickListener(this);
        signup_order=findViewByIdNoCast(R.id.signup_order);
        login_edpw=findViewByIdNoCast(R.id.login_edpw);
        mima_img=findViewByIdNoCast(R.id.mima_img);
        mima_img.setOnClickListener(this);
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(DisplayUtil.getDensity_Width(getApplicationContext())/3*2, ViewGroup.LayoutParams.WRAP_CONTENT);
                        params.setMargins(DisplayUtil.getDensity_Width(getApplicationContext())/6,DisplayUtil.getDensity_Height(getApplicationContext())/5*2,DisplayUtil.getDensity_Width(getApplicationContext())/6,0);
                        signup_order.setLayoutParams(params);
                    }
                }
        ).start();
        radioget=findViewByIdNoCast(R.id.radioget);
        radioget.setOnClickListener(this);
        radiowork=findViewByIdNoCast(R.id.radiowork);
        radiowork.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.signupback){
            finish();
        }
        if(view.getId()==R.id.radioget){
            radioget.setChecked(true);
            radiowork.setChecked(false);
        }
        if(view.getId()==R.id.radiowork){
            radioget.setChecked(false);
            radiowork.setChecked(true);
        }
        if(view.getId()==R.id.mima_img){
                if(b==false){
                    mima_img.setImageResource(R.drawable.bukejian);
                    login_edpw.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);//设置密码不可见
                    b=true;
                }else {
                    mima_img.setImageResource(R.drawable.kejian);
                    login_edpw.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    b=false;
                }
        }
    }
}
