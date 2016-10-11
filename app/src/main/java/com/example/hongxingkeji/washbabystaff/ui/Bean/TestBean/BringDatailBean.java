package com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */
public class BringDatailBean {
    public String clothescode;
    public String price;
    public String beizhu;
    public List<String> imglist;
    public List<String> textlist;

    public BringDatailBean() {
    }

    public BringDatailBean(String clothescode, String price, String beizhu, List<String> imglist) {
        this.clothescode = clothescode;
        this.price = price;
        this.beizhu = beizhu;
        this.imglist = imglist;
    }

    public void setClothescode(String clothescode) {
        this.clothescode = clothescode;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public void setImglist(List<String> imglist) {
        this.imglist = imglist;
    }
}
