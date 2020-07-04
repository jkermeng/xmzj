package com.learn.entity;

import java.io.Serializable;

public class U_Details implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer ud_id;
    private String ud_rname;
    private Integer ud_sex;
    private String ud_phone;
    private String ud_email;
    private String ud_college;
    private String ud_education;
    private String ud_company_name;
    private String ud_job;
    private String ud_field;
    private Integer ud_jobyear;
    private String ud_achievement;
    private String ud_exp_field;
    private String ud_teamname;
    private Integer sysu_id;
    private Integer ud_status;
    private String ud_imgurl;
    private Integer up_type;
    private SysUserEntity userEntity;

    public Integer getUd_status() {
        return ud_status;
    }

    public Integer getUp_type() {
        return up_type;
    }

    public void setUp_type(Integer up_type) {
        this.up_type = up_type;
    }

    public void setUd_status(Integer ud_status) {
        this.ud_status = ud_status;
    }

    public String getUd_imgurl() {
        return ud_imgurl;
    }

    public void setUd_imgurl(String ud_imgurl) {
        this.ud_imgurl = ud_imgurl;
    }

    public SysUserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(SysUserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUd_id() {
        return ud_id;
    }

    public void setUd_id(Integer ud_id) {
        this.ud_id = ud_id;
    }

    public String getUd_rname() {
        return ud_rname;
    }

    public void setUd_rname(String ud_rname) {
        this.ud_rname = ud_rname;
    }

    public Integer getUd_sex() {
        return ud_sex;
    }

    public void setUd_sex(Integer ud_sex) {
        this.ud_sex = ud_sex;
    }

    public String getUd_phone() {
        return ud_phone;
    }

    public void setUd_phone(String ud_phone) {
        this.ud_phone = ud_phone;
    }

    public String getUd_email() {
        return ud_email;
    }

    public void setUd_email(String ud_email) {
        this.ud_email = ud_email;
    }

    public String getUd_college() {
        return ud_college;
    }

    public void setUd_college(String ud_college) {
        this.ud_college = ud_college;
    }

    public String getUd_education() {
        return ud_education;
    }

    public void setUd_education(String ud_education) {
        this.ud_education = ud_education;
    }

    public String getUd_company_name() {
        return ud_company_name;
    }

    public void setUd_company_name(String ud_company_name) {
        this.ud_company_name = ud_company_name;
    }

    public String getUd_job() {
        return ud_job;
    }

    public void setUd_job(String ud_job) {
        this.ud_job = ud_job;
    }

    public String getUd_field() {
        return ud_field;
    }

    public void setUd_field(String ud_field) {
        this.ud_field = ud_field;
    }

    public Integer getUd_jobyear() {
        return ud_jobyear;
    }

    public void setUd_jobyear(Integer ud_jobyear) {
        this.ud_jobyear = ud_jobyear;
    }

    public String getUd_achievement() {
        return ud_achievement;
    }

    public void setUd_achievement(String ud_achievement) {
        this.ud_achievement = ud_achievement;
    }

    public String getUd_exp_field() {
        return ud_exp_field;
    }

    public void setUd_exp_field(String ud_exp_field) {
        this.ud_exp_field = ud_exp_field;
    }

    public String getUd_teamname() {
        return ud_teamname;
    }

    public void setUd_teamname(String ud_teamname) {
        this.ud_teamname = ud_teamname;
    }

    public Integer getSysu_id() {
        return sysu_id;
    }

    public void setSysu_id(Integer sysu_id) {
        this.sysu_id = sysu_id;
    }

    @Override
    public String toString() {
        return "U_Details{" +
                "ud_id=" + ud_id +
                ", ud_rname='" + ud_rname + '\'' +
                ", ud_sex=" + ud_sex +
                ", ud_phone='" + ud_phone + '\'' +
                ", ud_email='" + ud_email + '\'' +
                ", ud_college='" + ud_college + '\'' +
                ", ud_education='" + ud_education + '\'' +
                ", ud_company_name='" + ud_company_name + '\'' +
                ", ud_job='" + ud_job + '\'' +
                ", ud_field='" + ud_field + '\'' +
                ", ud_jobyear=" + ud_jobyear +
                ", ud_achievement='" + ud_achievement + '\'' +
                ", ud_exp_field='" + ud_exp_field + '\'' +
                ", ud_teamname='" + ud_teamname + '\'' +
                ", sysu_id=" + sysu_id +
                '}';
    }
}
