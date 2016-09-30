package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.DisplayUtil;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.IntentUtils;

/**
 * 登录界面
 */
public class LoginActicity extends BaseActivity implements AdapterView.OnItemClickListener{
    private LinearLayout login_order;

    private ImageView mima_img;

    private EditText login_edpw;

    private boolean b=true;

    @Override
    public int getContentViewId() {
        return R.layout.activity_login_acticity;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        findViewByIdNoCast(R.id.bt_login).setOnClickListener(this);
        login_order=findViewByIdNoCast(R.id.login_order);
        login_edpw=findViewByIdNoCast(R.id.login_edpw);
        mima_img=findViewByIdNoCast(R.id.mima_img);
        mima_img.setOnClickListener(this);
        findViewByIdNoCast(R.id.newuser).setOnClickListener(this);
        findViewByIdNoCast(R.id.forgetpass).setOnClickListener(this);
        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(DisplayUtil.getDensity_Width(this)/3*2, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(DisplayUtil.getDensity_Width(this)/6,DisplayUtil.getDensity_Height(this)/2,DisplayUtil.getDensity_Width(this)/6,0);
        login_order.setLayoutParams(params);
    }

    @Override
    public void initData() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.newuser:
                IntentUtils.openActivity(this,SignupActivity.class);
            break;
            case R.id.forgetpass:
                IntentUtils.openActivity(this,ForgetPasswordActivity.class);
                break;
            case R.id.bt_login:
                IntentUtils.openActivity(this,MainActivity.class);
                break;
            case R.id.mima_img:
                if(b==false){
                    mima_img.setImageResource(R.drawable.bukejian);
                    login_edpw.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);//设置密码不可见
                    b=true;
                }else {
                    mima_img.setImageResource(R.drawable.kejian);
                    login_edpw.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    b=false;
                }
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
