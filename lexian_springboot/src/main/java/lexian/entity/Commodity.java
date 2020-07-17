package lexian.entity;

import java.util.Date;

import lexian.entity.model.GoodDetailsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * 商品的实体类
 */
public class Commodity extends GoodDetailsModel {
    private int ID;   //商品ID
    private String name;  //商品名字
    private double price; //商品价格
    private String image; //商品图片
    private String introduction;  //商品介绍
    private int storage;  //商品库存
    private String specification;  //商品规格
    private Date modify_time;  //修改时间
    private int status;  //商品状态
    private int is_delete;  //是否删除
    private int index;


    public Commodity(){}

    public Commodity(int ID, String name, double price, String image, String introduction, int storage, String specification, Date modify_time, int status, int is_delete, int index) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.image = image;
        this.introduction = introduction;
        this.storage = storage;
        this.specification = specification;
        this.modify_time = modify_time;
        this.status = status;
        this.is_delete = is_delete;
        this.index = index;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Date getModify_time() {
        return modify_time;
    }

    public void setModify_time(Date modify_time) {
        this.modify_time = modify_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public int getIndex() { return index; }

    public void setIndex(int index) { this.index = index; }
    
}
