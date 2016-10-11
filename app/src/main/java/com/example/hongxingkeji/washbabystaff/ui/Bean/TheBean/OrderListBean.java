package com.example.hongxingkeji.washbabystaff.ui.Bean.TheBean;

import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseBean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/10.
 */
public class OrderListBean extends BaseBean implements Serializable{
    public OrderListBean() {
    }

    public OrderListBean(String address) {

        this.address = address;
    }

    public String  order_id;    //"order_id": "6",
            public String  order_num;   //"order_num": "SCAPX00000000006/B",
            public String  customer_name; //"customer_name": "就死定了",
            public String  order_time; //"order_time": "1474248935",
            public String  pay_type;  //"pay_type": "1",
            public String  pay_status;  //"pay_status": "1",
            public String  headimg;  //"headimg": "http://192.168.3.9/xiyi/Public/Upload/HeadImg/2016-09-12/54467660_1473674426.png",
            public String  address;   //"address": "四川省成都市郫县嘻嘻嘻想休假",
            public String  is_remarks;   //"is_remarks": 0
}
