package com.learn.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Active implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer a_id;
    private String a_title;
    private String a_context;
    private String a_scheme;
    private Integer a_pnum;
    private double a_price;
    private String a_beginDate;
    private String a_type;
    private Integer a_status;
    private Integer a_userid;
    private Integer lastNum;
    private List<A_Img> a_imgList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getLastNum() {
        return lastNum;
    }

    public void setLastNum(Integer lastNum) {
        this.lastNum = lastNum;
    }

    public List<A_Img> getA_imgList() {
        return a_imgList;
    }

    public void setA_imgList(List<A_Img> a_imgList) {
        this.a_imgList = a_imgList;
    }

    public Integer getA_userid() {
        return a_userid;
    }

    public void setA_userid(Integer a_userid) {
        this.a_userid = a_userid;
    }

    public Integer getA_status() {
        return a_status;
    }

    public void setA_status(Integer a_status) {
        this.a_status = a_status;
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getA_title() {
        return a_title;
    }

    public void setA_title(String a_title) {
        this.a_title = a_title;
    }

    public String getA_context() {
        return a_context;
    }

    public void setA_context(String a_context) {
        this.a_context = a_context;
    }

    public String getA_scheme() {
        return a_scheme;
    }

    public void setA_scheme(String a_scheme) {
        this.a_scheme = a_scheme;
    }

    public Integer getA_pnum() {
        return a_pnum;
    }

    public void setA_pnum(Integer a_pnum) {
        this.a_pnum = a_pnum;
    }

    public double getA_price() {
        return a_price;
    }

    public void setA_price(double a_price) {
        this.a_price = a_price;
    }

    public String getA_beginDate() {
        return a_beginDate;
    }

    public void setA_beginDate(String a_beginDate) {
        this.a_beginDate = a_beginDate;
    }

    public String getA_type() {
        return a_type;
    }

    public void setA_type(String a_type) {
        this.a_type = a_type;
    }

    @Override
    public String toString() {
        return "Active{" +
                "a_id=" + a_id +
                ", a_title='" + a_title + '\'' +
                ", a_context='" + a_context + '\'' +
                ", a_scheme='" + a_scheme + '\'' +
                ", a_pnum=" + a_pnum +
                ", a_price=" + a_price +
                ", a_beginDate='" + a_beginDate + '\'' +
                ", a_type=" + a_type +
                '}';
    }
}
