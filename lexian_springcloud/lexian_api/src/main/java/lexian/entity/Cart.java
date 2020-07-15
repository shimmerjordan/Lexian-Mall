package lexian.entity;

public class Cart {
	
	private Integer id;
	
    private Integer customerId;

    private Integer commodityId;

    private Integer commodityQuantity;

    private Integer isDelete;
    
    private Integer specs;


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Cart(Integer customerId, Integer commodityId, Integer commodityQuantity, Integer isDelete) {
        this.customerId = customerId;
        this.commodityId = commodityId;
        this.commodityQuantity = commodityQuantity;
        this.isDelete = isDelete;
    }

    public Cart(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSpecs() {
		return specs;
	}

	public void setSpecs(Integer specs) {
		this.specs = specs;
	}

}