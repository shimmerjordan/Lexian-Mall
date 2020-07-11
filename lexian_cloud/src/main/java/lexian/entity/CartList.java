package lexian.entity;

public class CartList {
    private Integer id;
    private String name;
    private Double price;
    private String image;
    private Integer storage;
    private Integer commodityId;
    private Integer commodityQuantity;
    private Integer customerId;
    private String specsName;

    public CartList(Integer id, String name, Double price, String image, Integer storage, Integer commodityId, Integer commodityQuantity, Integer customerId, String specsName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.storage = storage;
        this.commodityId = commodityId;
        this.commodityQuantity = commodityQuantity;
        this.customerId = customerId;
        this.specsName = specsName;
    }

    public CartList(){}

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
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getCommodityQuantity() {
        return commodityQuantity;
    }

    public void setCommodityQuantity(Integer commodityQuantity) {
        this.commodityQuantity = commodityQuantity;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getSpecsName() {
        return specsName;
    }

    public void setSpecsName(String specsName) {
        this.specsName = specsName;
    }
}
