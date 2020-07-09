package lexian.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 商品评价表，评价ID是唯一的主键，为了节省数据库空间，评论内容可为空，如果为空，前端应显示“用户没有填写评价，系统默认好评”
 * </p>
 *
 * @author zly
 * @since 2020-07-08
 */
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 评论的ID
	 */
	private Integer commentId;

	/**
	 * 连接customer表的ID
	 */
	private Integer customerId;

	/**
	 * 连接commodity的ID
	 */
	private Integer commodityId;

	/**
	 * 商品综合评价等级
	 */
	private Integer commentLevel;

	/**
	 * 评论时间
	 */
	private Date commentTime;

	/**
	 * 评论内容，如果为空，前端应显示“用户没有填写评价，系统默认好评”
	 */
	private String commentContent;

	/**
	 * 评价图片
	 */
	private String commentImage;

	/**
	 * 追评内容，可以为空，为空不显示在前端
	 */
	private String additionalCommentContent;

	/**
	 * 追评时间，如果追评为空，即为空
	 */
	private LocalDateTime additionalCommentTime;

	/**
	 * 追评图片，如果追评为空，即为空
	 */
	private String additionalCommentImage;

	/**
	 * 删除标记
	 */
	private Integer isDelete;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

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

	public Integer getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(Integer commentLevel) {
		this.commentLevel = commentLevel;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentImage() {
		return commentImage;
	}

	public void setCommentImage(String commentImage) {
		this.commentImage = commentImage;
	}

	public String getAdditionalCommentContent() {
		return additionalCommentContent;
	}

	public void setAdditionalCommentContent(String additionalCommentContent) {
		this.additionalCommentContent = additionalCommentContent;
	}

	public LocalDateTime getAdditionalCommentTime() {
		return additionalCommentTime;
	}

	public void setAdditionalCommentTime(LocalDateTime additionalCommentTime) {
		this.additionalCommentTime = additionalCommentTime;
	}

	public String getAdditionalCommentImage() {
		return additionalCommentImage;
	}

	public void setAdditionalCommentImage(String additionalCommentImage) {
		this.additionalCommentImage = additionalCommentImage;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "Comment{" + ", commentId=" + commentId + ", customerId=" + customerId + ", commodityId=" + commodityId
				+ ", commentLevel=" + commentLevel + ", commentTime=" + commentTime + ", commentContent="
				+ commentContent + ", commentImage=" + commentImage + ", additionalCommentContent="
				+ additionalCommentContent + ", additionalCommentTime=" + additionalCommentTime
				+ ", additionalCommentImage=" + additionalCommentImage + ", isDelete=" + isDelete + "}";
	}
}
