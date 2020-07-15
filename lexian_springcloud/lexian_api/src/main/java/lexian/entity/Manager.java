package lexian.entity;

import java.sql.Timestamp;

public class Manager {
    private int ID;
    private int role;
    private String name;
    private int age;
    private String sex;
    private String nickname;
    private Timestamp birthday;
    private String phone;

    public Manager(int ID, int role, String name, int age, String sex, String nickname, Timestamp birthday, String phone) {
        this.ID = ID;
        this.role = role;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.nickname = nickname;
        this.birthday = birthday;
        this.phone = phone;
    }

    public Manager(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
