package com.example.hongxingkeji.washbabystaff.farmwork.Http;


import com.example.hongxingkeji.washbabystaff.farmwork.Utils.UrlUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by fengchao on 2016/1/13 0013.
 * Description:
 */
public class HttpHelper {


//
//    /**
//     * 热门搜索
//     *
//     * @param context
//     * @param callBack
//     */
//    public static void getHotSearch(Context context, StringCallback callBack) {
//
//        OkHttpUtils
//                .get()
//                .url(UrlUtils.HOT_SEARCH)
//                .addParams("cityId", "" + SharePrefreceHelper.getInstence(context).getCityId())
//                .build()
//                .execute(callBack);
//    }
    //登录请求
    public static void LoginRequest(String username, String password, StringCallback callback){
        OkHttpUtils
                .post()
                .url(UrlUtils.BASE_URL+UrlUtils.Login)
                .addParams("user_name",username)
                .addParams("password",password)
                .build()
                .execute(callback);
    }
    //消息接口
    public static void MessageRequest(StringCallback callback){
        OkHttpUtils
                .post()
                .url(UrlUtils.BASE_URL+UrlUtils.Message)
                .build()
                .execute(callback);
    }

    //订单列表
    //type：1即时单，2预约单
    public static void OrderListRequest(String orderstatus,String staff_id,String type,StringCallback callback){
        if(type!=null){
            OkHttpUtils
                    .post()
                    .url(UrlUtils.BASE_URL+UrlUtils.OrderList)
                    .addParams("order_status",orderstatus)
                    .addParams("staff_id",staff_id)
                    .addParams("type",type)
                    .build()
                    .execute(callback);
                     return;
        }
        OkHttpUtils
                .post()
                .url(UrlUtils.BASE_URL+UrlUtils.OrderList)
                .addParams("order_status",orderstatus)
                .addParams("staff_id",staff_id)
                .build()
                .execute(callback);
    }
    //区间扫描
    public static void GetandSm(StringCallback callback){
        OkHttpUtils
                .post()
                .url(UrlUtils.BASE_URL+UrlUtils.ScanCloth)
                .build()
                .execute(callback);
    }
}
