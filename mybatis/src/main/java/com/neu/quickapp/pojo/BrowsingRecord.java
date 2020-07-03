package com.neu.quickapp.pojo;

import java.util.Date;

public class BrowsingRecord {
    private Integer id;

    private Integer commodityId;

    private Integer customerId;

    private Date browsingTime;

    private Integer isdelete;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getBrowsingTime() {
        return browsingTime;
    }

    public void setBrowsingTime(Date browsingTime) {
        this.browsingTime = browsingTime;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}