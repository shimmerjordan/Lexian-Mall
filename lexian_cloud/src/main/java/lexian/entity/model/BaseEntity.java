/**
 * 
 */
package lexian.entity.model;

/**
 * @author yang990322
 *
 */
public class BaseEntity {

	private int pageSize;

	private int pageNo;
	
	private String categoryId;
	
	/**
	 * 排序
	 * 1 销量排序
	 * 2 价格升序
	 * 3 价格降序
	 */
	private String sortType;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

}
