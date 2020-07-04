package com.learn.entity;

import java.io.Serializable;

public class A_Img implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer ai_id;
    private Integer ai_aid;
    private String ai_url;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAi_id() {
        return ai_id;
    }

    public void setAi_id(Integer ai_id) {
        this.ai_id = ai_id;
    }

    public Integer getAi_aid() {
        return ai_aid;
    }

    public void setAi_aid(Integer ai_aid) {
        this.ai_aid = ai_aid;
    }

    public String getAi_url() {
        return ai_url;
    }

    public void setAi_url(String ai_url) {
        this.ai_url = ai_url;
    }

    @Override
    public String toString() {
        return "A_Img{" +
                "ai_id=" + ai_id +
                ", ai_aid=" + ai_aid +
                ", ai_url='" + ai_url + '\'' +
                '}';
    }
}
