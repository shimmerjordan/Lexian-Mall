package com.neu.quickapp.pojo;

import java.util.Date;

public class SystemManagerAuthorityKey {
    private Integer systmManager;

    private Integer authority;

    private Integer shopManager;

    private Date time;

    public Integer getSystmManager() {
        return systmManager;
    }

    public void setSystmManager(Integer systmManager) {
        this.systmManager = systmManager;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public Integer getShopManager() {
        return shopManager;
    }

    public void setShopManager(Integer shopManager) {
        this.shopManager = shopManager;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}