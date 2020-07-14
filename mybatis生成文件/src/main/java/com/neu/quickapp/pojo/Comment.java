package com.neu.quickapp.pojo;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private Integer customerId;

    private Integer commodityId;

    private Integer commentLevel;

    private Date commentTime;

    private String commentContent;

    private String commentImage;

    private String additionalCommentContent;

    private Date additionalCommentTime;

    private String additionalCommentImage;

    private Integer isDelete;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public String getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(String commentImage) {
        this.commentImage = commentImage == null ? null : commentImage.trim();
    }

    public String getAdditionalCommentContent() {
        return additionalCommentContent;
    }

    public void setAdditionalCommentContent(String additionalCommentContent) {
        this.additionalCommentContent = additionalCommentContent == null ? null : additionalCommentContent.trim();
    }

    public Date getAdditionalCommentTime() {
        return additionalCommentTime;
    }

    public void setAdditionalCommentTime(Date additionalCommentTime) {
        this.additionalCommentTime = additionalCommentTime;
    }

    public String getAdditionalCommentImage() {
        return additionalCommentImage;
    }

    public void setAdditionalCommentImage(String additionalCommentImage) {
        this.additionalCommentImage = additionalCommentImage == null ? null : additionalCommentImage.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}