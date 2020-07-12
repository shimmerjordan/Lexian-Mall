/**
 * 
 */
package lexian.entity.model;

import java.util.Arrays;
import java.util.List;

import lexian.entity.Address;
import lexian.entity.Comment;
import lexian.entity.Coupon;
import lexian.entity.Specs;

/**
 * @author yang990322
 *
 */
public class GoodDetailsModel extends BaseEntity {

	/**
	 * 销量
	 */
	private int sales;

	/**
	 * 浏览量
	 */
	private int browseCount;

	private List<Comment> commentList;

	private List<Specs> specsList;

	private List<Coupon> couponList;
	
	private List<Address> addressList;

	private String image1;

	private String image2;

	private String image3;

	private String image4;

	private String image5;

	private String image6;

	private String commodityId;

	private List<String> cartIds;
	
	private String specsText;
	
	private int gootCount;
	
	private String shopName;
	
	private String shopImg;

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getBrowseCount() {
		return browseCount;
	}

	public void setBrowseCount(int browseCount) {
		this.browseCount = browseCount;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public List<Specs> getSpecsList() {
		return specsList;
	}

	public void setSpecsList(List<Specs> specsList) {
		this.specsList = specsList;
	}

	public List<Coupon> getCouponList() {
		return couponList;
	}

	public void setCouponList(List<Coupon> couponList) {
		this.couponList = couponList;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getImage5() {
		return image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}

	public String getImage6() {
		return image6;
	}

	public void setImage6(String image6) {
		this.image6 = image6;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public List<String> getCartIds() {
		return cartIds;
	}

	public void setCartIds(String cartIds) {
		this.cartIds = Arrays.asList(cartIds.split(","));
	}

	public String getSpecsText() {
		return specsText;
	}

	public void setSpecsText(String specsText) {
		this.specsText = specsText;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public int getGootCount() {
		return gootCount;
	}

	public void setGootCount(int gootCount) {
		this.gootCount = gootCount;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopImg() {
		return shopImg;
	}

	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}


}
