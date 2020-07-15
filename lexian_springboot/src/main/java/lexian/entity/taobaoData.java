package lexian.entity;

public class taobaoData {
    private int id;
    private String name;
    private String price;
    private String peopleNum;

    public taobaoData(){}

    public taobaoData(int id, String name, String price, String peopleNum) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.peopleNum = peopleNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
    }
}
