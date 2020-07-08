/**
 * 
 */
package lexian.entity.model;

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
    
    
    
}
