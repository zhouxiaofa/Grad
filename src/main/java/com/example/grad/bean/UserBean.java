package com.example.grad.bean;

/**
 * @author zxf
 */
public class UserBean {

    private int id;
    private String name;
    private String password;
    private int flag;
    private int s_flag;

    public UserBean() {
    }

    public UserBean(int id, String name, String password, int flag, int s_flag) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.flag = flag;
        this.s_flag = s_flag;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getS_flag() {
        return s_flag;
    }

    public void setS_flag(int s_flag) {
        this.s_flag = s_flag;
    }
}
