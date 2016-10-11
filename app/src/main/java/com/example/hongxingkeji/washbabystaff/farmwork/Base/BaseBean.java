package com.example.hongxingkeji.washbabystaff.farmwork.Base;

/**
 * Created by Lizhangfeng on 2016/1/15 0015.
 * Description:
 */
public class BaseBean{

    public String resultcode;//接口返回码 200表示请求成功，其他表示失败

    public String resaon;//成功或者失败

    public String error;//错误码

   public String result;//数据结果

    @Override
    public String toString() {
        return "BaseBean{" +
                "code='" + resultcode + '\'' +
                ", resaon='" + resaon + '\'' +
                ", error='" + error + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
