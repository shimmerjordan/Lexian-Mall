package lexian.entity;

import java.util.Date;

public class UniBrowsingRecord {

    private static final long serialVersionUID = 1L;

    /**
     * 连接commodity的ID
     */
    private Integer commodityId;

    /**
     * 连接customer表的ID
     */
    private Integer customerId;

    /**
     * 浏览时间
     */
    private Date browsingTime;

    /**
     * 删除标记
     */
    private Integer isDelete;

    /**
     * 修改时间
     */
    private Date date;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品图片
     */
    private String image;

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getBrowsingTime() {
        return browsingTime;
    }

    public void setBrowsingTime(Date browsingTime) {
        this.browsingTime = browsingTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private double price;

    public UniBrowsingRecord(){}
    public UniBrowsingRecord(Integer commodityId, Integer customerId, Date browsingTime, Integer isDelete, Date date, Integer id, String image, String name, double price) {
        this.commodityId = commodityId;
        this.customerId = customerId;
        this.browsingTime = browsingTime;
        this.isDelete = isDelete;
        this.date = date;
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
    }
}
