package com.example.grad.bean;

/**
 * @author zxf
 */
public class ApiBean {

    private int id;
    private String api_url;
    private String remark_detail;

    public ApiBean(int id, String api_url, String remark_detail) {
        this.id = id;
        this.api_url = api_url;
        this.remark_detail = remark_detail;
    }

    public ApiBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApi_url() {
        return api_url;
    }

    public void setApi_url(String api_url) {
        this.api_url = api_url;
    }

    public String getRemark_detail() {
        return remark_detail;
    }

    public void setRemark_detail(String remark_detail) {
        this.remark_detail = remark_detail;
    }
}
