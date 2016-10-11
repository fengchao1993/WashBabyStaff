package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.farmwork.Http.HttpCallBack;
import com.example.hongxingkeji.washbabystaff.farmwork.Http.HttpHelper;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.DisplayUtil;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.IntentUtils;
import com.example.hongxingkeji.washbabystaff.farmwork.Utils.StringUtils;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TheBean.LoginBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录界面
 */
public class LoginActicity extends BaseActivity{
    private LinearLayout login_order;

    private ImageView mima_img;

    private List<String> msg;

    private EditText login_edpw,login_edzh;

    private boolean b=true;

    @Override
    public int getContentViewId() {
        return R.layout.activity_login_acticity;
    }

    @Override
    public void beforeInitView() {
        msg=GetData();
    }

    @Override
    public void initView() {
        findViewByIdNoCast(R.id.bt_login).setOnClickListener(this);
        login_order=findViewByIdNoCast(R.id.login_order);
        login_edpw=findViewByIdNoCast(R.id.login_edpw);
        login_edzh=findViewByIdNoCast(R.id.login_edzh);
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
        if (msg.get(0)!=null){
            login_edzh.setText(msg.get(0));
            login_edpw.setText(msg.get(1));
        }
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
                if(StringUtils.isEmpty(login_edzh.getText().toString())){
                    Toast.makeText(this,"账号不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(StringUtils.isEmpty(login_edpw.getText().toString())){
                    Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                HttpHelper.LoginRequest(login_edzh.getText().toString(), login_edpw.getText().toString(), new HttpCallBack<LoginBean>() {
                    @Override
                    public void onSuccess(LoginBean result) {
                        if(msg.get(0)==null){
                            SaveData(login_edzh.getText().toString(),login_edpw.getText().toString());
                        }
                        if(result!=null){
                            if(result.role.equals("1")){//接单员
                                    Bundle bundle=new Bundle();
                                    bundle.putString("username",result.nick_name);
                                    bundle.putString("staffcode",result.j_num);
                                    bundle.putString("staff_id",result.staff_id);
                                    bundle.putString("headimg",result.headimg);
                                IntentUtils.openActivity(LoginActicity.this,MainActivity.class,bundle);
                            }
                            if(result.role.equals("2")){//处理员
                                Bundle bundle=new Bundle();
                                bundle.putString("username",result.nick_name);
                                bundle.putString("staffcode",result.j_num);
                                bundle.putString("staff_id",result.staff_id);
                                IntentUtils.openActivity(LoginActicity.this,Main2Activity.class,bundle);
                            }
                        }
                    }
                    @Override
                    public void onFail(String errMsg) {
                        Toast.makeText(LoginActicity.this,errMsg,Toast.LENGTH_SHORT).show();
                    }
                });
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
    //采用共享参数存储用户信息
    public void SaveData(String username,String password){
        SharedPreferences sharedPreferences=getSharedPreferences("LoginMessage",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("username",username);
        editor.putString("password",password);
        editor.commit();
    }
    //拿取数据
    public List<String> GetData(){
        SharedPreferences sharedPreferences=getSharedPreferences("LoginMessage",MODE_PRIVATE);
        if(sharedPreferences==null){
            return null;
        }
        List<String> msg=new ArrayList<>();
        msg.add(sharedPreferences.getString("username",null));
        msg.add(sharedPreferences.getString("password",null));
        return msg;
    }


}
