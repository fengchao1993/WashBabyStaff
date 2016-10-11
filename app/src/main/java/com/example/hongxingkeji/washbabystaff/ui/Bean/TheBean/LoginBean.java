package com.example.hongxingkeji.washbabystaff.ui.Bean.TheBean;

import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseBean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/10.
 */
public class LoginBean extends BaseBean implements Serializable{
    public String   staff_id;   //   "staff_id ": "1",
    public String   role;     //"role":"1",
    public String   j_num;     //"j_num": "YCD00001",
    public String   nick_name;    //"nick_name": "嘻嘻嘻",
    public String   headimg;    //"headimg": ""

    @Override
    public String toString() {
        return "LoginBean{" +
                "staff_id='" + staff_id + '\'' +
                ", role='" + role + '\'' +
                ", j_num='" + j_num + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", headimg='" + headimg + '\'' +
                '}';
    }
}
