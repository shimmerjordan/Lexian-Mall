package lexian.entity;

import java.sql.Date;

public class JiuFenOrder {
    private int id;
    private int customer_id;
    private int order_id;
    private int shop_id;
    private String reason;
    private String result;
    private int status;
    private Date handTime;
    private Date applyTime;

    public JiuFenOrder(){}

    public JiuFenOrder(int id, int customer_id, int order_id, int shop_id, String reason, String result, int status, Date handTime, Date applyTime) {
        this.id = id;
        this.customer_id = customer_id;
        this.order_id = order_id;
        this.shop_id = shop_id;
        this.reason = reason;
        this.result = result;
        this.status = status;
        this.handTime = handTime;
        this.applyTime = applyTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getHandTime() {
        return handTime;
    }

    public void setHandTime(Date handTime) {
        this.handTime = handTime;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }
}
