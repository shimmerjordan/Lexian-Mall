package lexian.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 浏览记录（关系表）
 * </p>
 *
 * @author zly
 * @since 2020-07-08
 */
public class BrowsingRecord implements Serializable {

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

	@Override
	public String toString() {
		return "BrowsingRecord{" + ", commodityId=" + commodityId + ", customerId=" + customerId + ", browsingTime="
				+ browsingTime + ", isDelete=" + isDelete + ", date=" + date + ", id=" + id + "}";
	}
}
