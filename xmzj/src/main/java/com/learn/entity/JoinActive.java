package com.learn.entity;

import java.io.Serializable;

public class JoinActive implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer ja_id;
    private Integer uid;
    private Integer a_id;
    private String joinDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getJa_id() {
        return ja_id;
    }

    public void setJa_id(Integer ja_id) {
        this.ja_id = ja_id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "JoinActive{" +
                "ja_id=" + ja_id +
                ", uid=" + uid +
                ", a_id=" + a_id +
                ", joinDate='" + joinDate + '\'' +
                '}';
    }
}
