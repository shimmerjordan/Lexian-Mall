package lexian.entity;

import java.util.Date;

//店铺信息实体类
public class Shop {
    private Integer id;//店铺id

    private String name;//店铺名称

    private Date establishTime;//创建店铺时间

    private String kind;//该店铺类型——旗舰店，自营店，进口店，

    private Integer status;//店铺状态

    private Integer isDelete;//店铺删除标记

    private String img;//店铺图片

    private String tag;//店铺的标签，分类——食品，服饰，电子设备

    private  String description;//店铺描述

    public Shop(Integer id, String name, Date establishTime, String kind, Integer status, Integer isDelete, String img, String tag, String description) {
        this.id = id;
        this.name = name;
        this.establishTime = establishTime;
        this.kind = kind;
        this.status = status;
        this.isDelete = isDelete;
        this.img = img;
        this.tag = tag;
        this.description = description;
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

    public Date getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind == null ? null : kind.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}