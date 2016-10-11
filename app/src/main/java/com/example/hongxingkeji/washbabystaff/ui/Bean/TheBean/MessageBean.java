package com.example.hongxingkeji.washbabystaff.ui.Bean.TheBean;

import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseBean;

/**
 * Created by Administrator on 2016/10/10.
 */
public class MessageBean extends BaseBean{
       public String content;            //"content": "是福建按打款了到静安寺路附近了三大件傅雷家书打了快放假了凯撒的解放了空间撒到路口附近快乐圣诞节福利会计师对垃圾了房间",
        public String time;      //"time": "2016年09月18日"

    @Override
    public String toString() {
        return "MessageBean{" +
                "content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
