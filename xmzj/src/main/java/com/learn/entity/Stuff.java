package com.learn.entity;

import java.io.Serializable;

public class Stuff implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer s_id;
    private String s_name;
    private String s_good;
    private String s_bad;
    private String s_where;
    private String s_how;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "s_id=" + s_id +
                ", s_name='" + s_name + '\'' +
                ", s_good='" + s_good + '\'' +
                ", s_bad='" + s_bad + '\'' +
                ", s_where='" + s_where + '\'' +
                ", s_how='" + s_how + '\'' +
                '}';
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_good() {
        return s_good;
    }

    public void setS_good(String s_good) {
        this.s_good = s_good;
    }

    public String getS_bad() {
        return s_bad;
    }

    public void setS_bad(String s_bad) {
        this.s_bad = s_bad;
    }

    public String getS_where() {
        return s_where;
    }

    public void setS_where(String s_where) {
        this.s_where = s_where;
    }

    public String getS_how() {
        return s_how;
    }

    public void setS_how(String s_how) {
        this.s_how = s_how;
    }
}
