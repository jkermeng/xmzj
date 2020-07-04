package com.learn.entity;

import java.io.Serializable;

public class Collect implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer c_id;
    private Integer c_userid;
    private Integer c_stuffid;
    private SysUserEntity sysUserEntity;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public SysUserEntity getSysUserEntity() {
        return sysUserEntity;
    }

    public void setSysUserEntity(SysUserEntity sysUserEntity) {
        this.sysUserEntity = sysUserEntity;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Integer getC_userid() {
        return c_userid;
    }

    public void setC_userid(Integer c_userid) {
        this.c_userid = c_userid;
    }

    public Integer getC_stuffid() {
        return c_stuffid;
    }

    public void setC_stuffid(Integer c_stuffid) {
        this.c_stuffid = c_stuffid;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "c_id=" + c_id +
                ", c_userid=" + c_userid +
                ", c_stuffid=" + c_stuffid +
                '}';
    }
}
