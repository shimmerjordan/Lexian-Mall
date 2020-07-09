/**
 * 
 */
package lexian.entity.model;

import java.util.List;

import lexian.entity.Comment;

/**
 * @author yang990322
 *
 */
public class GoodDetailsModel  extends BaseEntity{

	/**
	 * 销量
	 */
    private int sales;
    
    /**
     * 浏览量
     */
    private int browseCount;
    
    private List<Comment> commentList;
    
    

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
    
    
    
}
