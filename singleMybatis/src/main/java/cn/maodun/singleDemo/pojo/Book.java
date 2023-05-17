package cn.maodun.singleDemo.pojo;

/**
 * @author DELL
 * @date 2022/9/23
 */
public class Book {
    private Integer bid ;
    private String bname;

    public Integer getBid() {
        return bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                '}';
    }
}
