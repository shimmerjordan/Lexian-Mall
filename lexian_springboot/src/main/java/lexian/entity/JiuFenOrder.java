package lexian.entity;


import java.sql.Timestamp;


/**
 *纠纷订单实体类
 */
public class JiuFenOrder {
    private int id;   //纠纷编号
    private int customer_id;  //顾客id
    private int order_id;  //订单id
    private int shop_id;   //店铺id
    private String reason;  //纠纷原因
    private String result;  //处理结果
    private int status;   //处理状态
    private Timestamp handTime;  //处理时间
    private Timestamp applyTime;  //申请时间

    public JiuFenOrder(){}

    public JiuFenOrder(int id, int customer_id, int order_id, int shop_id, String reason, String result, int status, Timestamp handTime, Timestamp applyTime) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getHandTime() {
        return handTime;
    }

    public void setHandTime(Timestamp handTime) {
        this.handTime = handTime;
    }

    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
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
}
