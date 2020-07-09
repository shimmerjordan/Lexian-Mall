/**
 * 
 */
package lexian.entity;

/**
 * @author yang990322
 *
 */
public class Coupon {

	private Integer id;

	private String name;

	private Double discountedPrice;
	
	private String type;
	
	private Double cousumeMin;
	
	private Integer isDelete;

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

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getCousumeMin() {
		return cousumeMin;
	}

	public void setCousumeMin(Double cousumeMin) {
		this.cousumeMin = cousumeMin;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	

}
