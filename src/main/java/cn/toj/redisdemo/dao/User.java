package cn.toj.redisdemo.dao;

/**
 * @author Carlos
 * @description 用户类
 * @Date 2020/7/16
 */

public class User {

    private Integer id;
    private String username;
    private String sex;
    private String adderess;

    public User(Integer id, String username, String sex, String adderess) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.adderess = adderess;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdderess() {
        return adderess;
    }

    public void setAdderess(String adderess) {
        this.adderess = adderess;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", adderess='" + adderess + '\'' +
                '}';
    }
}
