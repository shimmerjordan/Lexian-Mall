package lexian.entity;


import java.io.Serializable;

import lexian.entity.model.BaseEntity;

/**
 * <p>
 * 顾客地址信息表
 * </p>
 *
 * @author zly
 * @since 2020-07-11
 */
public class Address extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 省份
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 详细地址
     */
    private String location;

    /**
     * 邮政编码
     */
    private Integer postcode;

    /**
     * 收件人姓名
     */
    private String name;

    /**
     * 收件人联系方式‘
     */
    private String phone;

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Address{" +
        ", id=" + id +
        ", province=" + province +
        ", city=" + city +
        ", area=" + area +
        ", location=" + location +
        ", postcode=" + postcode +
        ", name=" + name +
        ", phone=" + phone +
        ", isDelete=" + isDelete +
        "}";
    }
}
