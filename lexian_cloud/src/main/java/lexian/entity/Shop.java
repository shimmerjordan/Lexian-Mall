package lexian.entity;

import java.util.Date;

public class Shop {
    private Integer id;

    private String name;

    private Date establishTime;

    private String kind;

    private Integer status;

    private Integer isDelete;

    private String img;

    private String tag;

    public Shop(Integer id, String name, Date establishTime, String kind, Integer status, Integer isDelete, String img, String tag) {
        this.id = id;
        this.name = name;
        this.establishTime = establishTime;
        this.kind = kind;
        this.status = status;
        this.isDelete = isDelete;
        this.img = img;
        this.tag = tag;
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
}