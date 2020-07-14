package lexian.entity;
import java.io.Serializable;

/**
 * <p>
 * 商品类别表
 * </p>
 *
 * @author zly
 * @since 2020-07-07
 */
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品类别名
     */
    private String name;

    /**
     * 商品类别描述
     */
    private String description;

    /**
     * 目录深度，表示第几层分类
     */
    private Integer level;

    /**
     * 删除标记
     */
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}


}
