package com.kanchan.musicalinstrument.Model;

import java.util.Calendar;

public class Cart {
    private String userid;
    private String productid;

    public Cart(String userid, String productid) {
        this.userid = userid;
        this.productid = productid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }
}