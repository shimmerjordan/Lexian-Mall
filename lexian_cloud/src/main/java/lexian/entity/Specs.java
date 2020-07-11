package lexian.entity;

public class Specs {
    private Integer id;

    private String specsName;

    private Integer pid;

    private Integer sort;

    public Specs(Integer id, String specsName, Integer pid, Integer sort) {
        this.id = id;
        this.specsName = specsName;
        this.pid = pid;
        this.sort = sort;
    }

    public Specs(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecsName() {
        return specsName;
    }

    public void setSpecsName(String specsName) {
        this.specsName = specsName == null ? null : specsName.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}