package lexian.entity;

//活动——店铺关系实体类
public class ActivityShop {
    private Integer id;//主键id

    private Integer shop_id;//外键，店铺id

    private Integer activity_id;//外键，活动id

    private Integer is_delete;//关系表删除标记

    public ActivityShop(Integer id, Integer shop_id, Integer activity_id, Integer is_delete) {
        this.id = id;
        this.shop_id = shop_id;
        this.activity_id = activity_id;
        this.is_delete = is_delete;
    }

    public ActivityShop() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }
}
