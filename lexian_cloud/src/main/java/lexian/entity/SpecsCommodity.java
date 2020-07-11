package lexian.entity;

public class SpecsCommodity {
    private Integer id;

    private Integer commodityId;

    private Integer specsId;

    public SpecsCommodity(Integer id, Integer commodityId, Integer specsId) {
        this.id = id;
        this.commodityId = commodityId;
        this.specsId = specsId;
    }

    public SpecsCommodity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getSpecsId() {
        return specsId;
    }

    public void setSpecsId(Integer specsId) {
        this.specsId = specsId;
    }
}