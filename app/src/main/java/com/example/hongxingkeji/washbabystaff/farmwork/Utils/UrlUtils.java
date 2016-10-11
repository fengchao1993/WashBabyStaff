package com.example.hongxingkeji.washbabystaff.farmwork.Utils;

/**
 * Created by Lizhangfeng on 2016/1/19 0019.
 * Description:
 */
public class UrlUtils {

//    public static final String BASE_URL = "http://123.56.145.151:8080/TuanCheNetWork/";
//
//    //根据经纬度定位当前城市
//    public static final String QUERYCITYBYLATITUDE = BASE_URL + "bwf_TuanChe_QueryCityByLatitude";
//    //选择城市列表
    public static final String BASE_URL ="http://wash.scapp123.com/index.php/Api/";

    public static final String Login ="StaffUser/login";//登录接口

    public static final String GetOrder ="Order/startHandle";//接单

    public static final String OrderList ="Order/orderList";//订单列表

    public static final String ScanCloth ="Order/scanCloth";//取件扫描

    public static final String Message ="StaffUser/noticeList";//消息接口

    public static final String ChangePrice ="Order/changePrice";//改价

    public static final String ChangeBz ="Order/addRemarks";//改备注

    public static final String DeleteClothes ="Order/delCloth";//删除衣物

    public static final String EndSm ="Order/finishScan";//结束扫描

    public static final String ChangePay="Order/changePayType";//修改支付类型

    public static final String Finish="Order/finishShipping";//完成送货

    public static final String OrderDetail="Order/staffOrderInfo";//订单详情

    public static final String Saomawash="Order/startWashing";//扫码洗涤

    public static final String OutKu="Order/outKu";//出库扫码

    public static final String FinishBring="Order/outKu";//完成送货
}
