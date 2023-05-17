package cn.maodun.singleDemo.pojo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DELL
 * @date 2022/9/22
 */
public class User {
    private Integer uid;
    private String uname;
    private String upassword;
    private List<Book> bookList;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    @Override
    public String toString() {
        String bookListStr = bookList.stream().map(b -> {
            return "\n" + " bid:" + b.getBid() + " bname:" + b.getBname();
        }).collect(Collectors.joining(""));
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", bookList=" + bookListStr +
                '}';
    }
}
