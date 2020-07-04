package com.learn.entity;

import java.io.Serializable;

public class Prohistory implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer ph_id;
    private Integer sysuid;
    private Integer phuid;
    private SysUserEntity sysUserEntity;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPhuid() {
        return phuid;
    }

    public void setPhuid(Integer phuid) {
        this.phuid = phuid;
    }

    public Integer getPh_id() {
        return ph_id;
    }

    public void setPh_id(Integer ph_id) {
        this.ph_id = ph_id;
    }

    public Integer getSysuid() {
        return sysuid;
    }

    public void setSysuid(Integer sysuid) {
        this.sysuid = sysuid;
    }

    public SysUserEntity getSysUserEntity() {
        return sysUserEntity;
    }

    public void setSysUserEntity(SysUserEntity sysUserEntity) {
        this.sysUserEntity = sysUserEntity;
    }

    @Override
    public String toString() {
        return "Prohistory{" +
                "ph_id=" + ph_id +
                ", sysuid=" + sysuid +
                ", sysUserEntity=" + sysUserEntity +
                '}';
    }
}
