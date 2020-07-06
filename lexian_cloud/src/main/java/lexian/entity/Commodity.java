package lexian.entity;

import java.util.Date;

public class Commodity {
    private int ID;
    private String name;
    private double price;
    private String image;
    private String introdution;
    private int storage;
    private String specification;
    private Date modify_time;
    private int status;
    private int is_delete;

    public Commodity(){}


    public Commodity(int ID, String name, double price, String image, String introdution, int storage, String specification, Date modify_time, int status, int is_delete) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.image = image;
        this.introdution = introdution;
        this.storage = storage;
        this.specification = specification;
        this.modify_time = modify_time;
        this.status = status;
        this.is_delete = is_delete;
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

    public String getIntrodution() {
        return introdution;
    }

    public void setIntrodution(String introdution) {
        this.introdution = introdution;
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
}
