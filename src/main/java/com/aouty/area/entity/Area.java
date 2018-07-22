package com.aouty.area.entity;

import java.util.Date;

/**
 * @author Aouty
 * @date 2018-04-14 23:24
 * @description Area实体类
 */
public class Area {
    //主键ID
    private Integer areaId;

    //名称
    private String areaName;

    //权重，越大越靠前显示
    private Integer priority;

    //创建时间 java.util.Date
    private Date createTime;

    //更新时间
    private Date lastEditTime;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public Area() {
    }
    public Area(Integer areaId, String areaName, Integer priority, Date createTime, Date lastEditTime) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.priority = priority;
        this.createTime = createTime;
        this.lastEditTime = lastEditTime;
    }
}
