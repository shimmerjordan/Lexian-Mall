package lexian.entity;

import java.util.Date;

public class ShopManager {
    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private String pwd;

    private String nick_name;

    private String user_image;

    private Date birthday;

    private String login_name;

    private String phone;

    private Integer is_delete;

    public ShopManager(Integer id, String name, Integer age, String sex, String pwd, String nick_name, String user_image, Date birthday, String login_name, String phone, Integer is_delete) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.pwd = pwd;
        this.nick_name = nick_name;
        this.user_image = user_image;
        this.birthday = birthday;
        this.login_name = login_name;
        this.phone = phone;
        this.is_delete = is_delete;
    }

    public ShopManager() {
    }

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name == null ? null : nick_name.trim();
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image == null ? null : user_image.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name == null ? null : login_name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }
}