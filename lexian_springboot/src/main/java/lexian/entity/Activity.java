package lexian.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//店铺活动实体类
public class Activity {
    private Integer id;//活动id

    private String name;//活动名称

    private String description;//活动描述

    private String img;//活动图片

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;//创建活动时间

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date beginTime;//活动开始时间

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;//活动结束时间

    private String type;//活动类型

    private Integer status;//活动状态——已发布，是草稿

    private Integer is_delete;//活动删除标记

    public Activity(Integer id, String name, String description, String img, Date createTime,Date beginTime, Date endTime, String type, Integer status, Integer is_delete) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.createTime = createTime;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.type = type;
        this.status = status;
        this.is_delete = is_delete;
    }

    public Activity() {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer isDelete) {
        this.is_delete = is_delete;
    }
}