package lexian.entity;

public class CartList {
    private int id;
    private int cartId;
    private String name;
    private Double price;
    private String image;
    private int storage;
    private int commodityId;
    private int commodityQuantity;
    private int customerId;
    private String specsName;

    public CartList(){}

    public CartList(int id, int cartId, String name, Double price, String image, int storage, int commodityId, int commodityQuantity, int customerId, String specsName) {
        this.id = id;
        this.cartId = cartId;
        this.name = name;
        this.price = price;
        this.image = image;
        this.storage = storage;
        this.commodityId = commodityId;
        this.commodityQuantity = commodityQuantity;
        this.customerId = customerId;
        this.specsName = specsName;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public int getCommodityQuantity() {
        return commodityQuantity;
    }

    public void setCommodityQuantity(int commodityQuantity) {
        this.commodityQuantity = commodityQuantity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getSpecsName() {
        return specsName;
    }

    public void setSpecsName(String specsName) {
        this.specsName = specsName;
    }
}
