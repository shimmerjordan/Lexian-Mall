package com.neu.quickapp.pojo;

public class Settings {
    private Integer id;

    private String backgroundColor;

    private Integer messageRemind;

    private Integer musicRemind;

    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor == null ? null : backgroundColor.trim();
    }

    public Integer getMessageRemind() {
        return messageRemind;
    }

    public void setMessageRemind(Integer messageRemind) {
        this.messageRemind = messageRemind;
    }

    public Integer getMusicRemind() {
        return musicRemind;
    }

    public void setMusicRemind(Integer musicRemind) {
        this.musicRemind = musicRemind;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}