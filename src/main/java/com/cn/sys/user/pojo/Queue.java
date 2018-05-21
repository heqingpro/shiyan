package com.cn.sys.user.pojo;

import java.util.Date;

public class Queue {
    private Integer id;

    private String name;

    private String labNum;

    private String labeqNum;

    private Integer state;

    private Date time;

    private Integer credit;

    private String others;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLabNum() {
        return labNum;
    }

    public void setLabNum(String labNum) {
        this.labNum = labNum == null ? null : labNum.trim();
    }

    public String getLabeqNum() {
        return labeqNum;
    }

    public void setLabeqNum(String labeqNum) {
        this.labeqNum = labeqNum == null ? null : labeqNum.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others == null ? null : others.trim();
    }
}