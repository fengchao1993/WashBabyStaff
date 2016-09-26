package com.example.hongxingkeji.washbabystaff.farmwork.Base;

/**
 * Created by Lizhangfeng on 2016/1/15 0015.
 * Description:
 */
public class BaseBean{

    public String code;//接口返回码 10000表示请求成功，其他表示失败

    public String msg;//返回msg

   public String result;//数据结果

    @Override
    public String toString() {
        return "BaseBean{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
