package lexian.entity;

import java.util.Date;

public class Activity {
    private Integer id;

    private String name;

    private String description;

    private String img;

    private Date createTime;

    private Date begintime;

    private Date endtime;

    private String type;

    private Integer status;

    private Integer is_delete;

    public Activity(Integer id, String name, String description, String img, Date createTime,Date begintime, Date endtime, String type, Integer status, Integer is_delete) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.createTime = createTime;
        this.begintime = begintime;
        this.endtime = endtime;
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

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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