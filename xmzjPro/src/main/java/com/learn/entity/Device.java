package com.learn.entity;

import java.io.Serializable;
import java.util.Date;

public class Device implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer d_id;
    private String  d_name;
    private String d_type;
    private double d_price;
    private String d_getday;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_type() {
        return d_type;
    }

    public void setD_type(String d_type) {
        this.d_type = d_type;
    }

    public double getD_price() {
        return d_price;
    }

    public void setD_price(double d_price) {
        this.d_price = d_price;
    }

    public String getD_getday() {
        return d_getday;
    }

    public void setD_getday(String d_getday) {
        this.d_getday = d_getday;
    }

    @Override
    public String toString() {
        return "Device{" +
                "d_id=" + d_id +
                ", d_name='" + d_name + '\'' +
                ", d_type='" + d_type + '\'' +
                ", d_price=" + d_price +
                ", d_getday='" + d_getday + '\'' +
                '}';
    }
}
