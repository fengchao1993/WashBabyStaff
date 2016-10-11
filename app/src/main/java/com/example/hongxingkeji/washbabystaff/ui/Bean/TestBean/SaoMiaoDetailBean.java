package com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/30.
 */
public class SaoMiaoDetailBean {
    public String code;
    public String clothestype;
    public String price;
    public String beizhu;
    public List<String> imgUri;
    public int clothes;
    public SaoMiaoDetailBean(String code, String clothestype, String price, String beizhu, int clothes) {
        this.code = code;
        this.clothestype = clothestype;
        this.price = price;
        this.beizhu = beizhu;
        this.clothes = clothes;
    }
}
