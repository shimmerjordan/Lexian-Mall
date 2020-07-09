/**
 * 
 */
package lexian.entity.model;

import java.util.List;

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

}
