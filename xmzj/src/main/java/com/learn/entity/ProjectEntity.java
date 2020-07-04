package com.learn.entity;

import java.io.Serializable;
import java.util.Date;

import com.learn.service.*;


/**
 * 项目
 */
public class ProjectEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;

    //名称
    private String name;

    //所属用户
    private Long user;

    private SysUserEntity sysUserEntity;

    public SysUserEntity getSysUserEntity() {
        return sysUserEntity;
    }

    public void setSysUserEntity(SysUserEntity sysUserEntity) {
        this.sysUserEntity = sysUserEntity;
    }


    //领域
    private Long type;

    private TypeEntity typeEntity;

    public TypeEntity getTypeEntity() {
        return typeEntity;
    }

    public void setTypeEntity(TypeEntity typeEntity) {
        this.typeEntity = typeEntity;
    }

    //内容
    private String content;

    //地点
    private String area;

    //时间
    private Date time;

    //状态
    private String state;

    //所选专家
    private Long pro;

    private SysUserEntity proEntity;

    public SysUserEntity getProEntity() {
        return proEntity;
    }

    public void setProEntity(SysUserEntity proEntity) {
        this.proEntity = proEntity;
    }

    //费用
    private Double price;

    //支付方式
    private String pay;

    //添加时间
    private Date gmttime = new Date();


    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：所属用户
     */
    public void setUser(Long user) {
        this.user = user;
    }

    /**
     * 获取：所属用户
     */
    public Long getUser() {
        return user;
    }

    /**
     * 设置：领域
     */
    public void setType(Long type) {
        this.type = type;
    }

    /**
     * 获取：领域
     */
    public Long getType() {
        return type;
    }

    /**
     * 设置：内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置：地点
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取：地点
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置：时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取：时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置：状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取：状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置：所选专家
     */
    public void setPro(Long pro) {
        this.pro = pro;
    }

    /**
     * 获取：所选专家
     */
    public Long getPro() {
        return pro;
    }

    /**
     * 设置：费用
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取：费用
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置：支付方式
     */
    public void setPay(String pay) {
        this.pay = pay;
    }

    /**
     * 获取：支付方式
     */
    public String getPay() {
        return pay;
    }

    /**
     * 设置：添加时间
     */
    public void setGmttime(Date gmttime) {
        this.gmttime = gmttime;
    }

    /**
     * 获取：添加时间
     */
    public Date getGmttime() {
        return gmttime;
    }
}
