package lexian.entity;

import java.sql.Timestamp;

public class Order {
    private int ID;
    private Timestamp date;
    private String description;
    private String name;
    private int comment;
    private int status;
    private int quantity;
    private float price;
    private int commodity;

    public Order(int ID, Timestamp date, String description, String name, int comment, int status, int quantity, float price, int commodity) {
        this.ID = ID;
        this.date = date;
        this.description = description;
        this.name = name;
        this.comment = comment;
        this.status = status;
        this.quantity = quantity;
        this.price = price;
        this.commodity = commodity;
    }

    public Order(){}

    public int getCommodity() {
        return commodity;
    }

    public void setCommodity(int commodity) {
        this.commodity = commodity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
