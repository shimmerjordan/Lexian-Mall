package com.neu.quickapp.pojo;

import java.math.BigDecimal;

public class Coupon {
    private Integer id;

    private String name;

    private BigDecimal discountedPrice;

    private String type;

    private BigDecimal cousumeMin;

    private Integer isDelete;

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

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public BigDecimal getCousumeMin() {
        return cousumeMin;
    }

    public void setCousumeMin(BigDecimal cousumeMin) {
        this.cousumeMin = cousumeMin;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}