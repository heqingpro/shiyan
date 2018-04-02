package com.cn.sys.user.pojo;

public class LabResult {
    private Integer id;

    private Integer labpreId;

    private String stuNum;

    private String labNum;

    private String description;

    private String picture;

    private String others;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLabpreId() {
        return labpreId;
    }

    public void setLabpreId(Integer labpreId) {
        this.labpreId = labpreId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }

    public String getLabNum() {
        return labNum;
    }

    public void setLabNum(String labNum) {
        this.labNum = labNum == null ? null : labNum.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others == null ? null : others.trim();
    }
}