package com.example.grad.bean;

/**
 * @author zxf
 */
public class StandardBean {

    private int id;
    private String standard_id;
    private String standard_name_cn;
    private String standard_name_en;
    private String standard_class;
    private String standard_state;
    private String standard_adopt;
    private String release_date;
    private String impl_date;
    private String css;
    private String iss;
    private String competent_department;
    private String technical_comm;
    private String standard_feature;

    public StandardBean(int id, String standard_id, String standard_name_cn, String standard_name_en, String standard_class, String standard_state, String standard_adopt, String release_date, String impl_date, String css, String iss, String competent_department, String technical_comm, String standard_feature) {
        this.id = id;
        this.standard_id = standard_id;
        this.standard_name_cn = standard_name_cn;
        this.standard_name_en = standard_name_en;
        this.standard_class = standard_class;
        this.standard_state = standard_state;
        this.standard_adopt = standard_adopt;
        this.release_date = release_date;
        this.impl_date = impl_date;
        this.css = css;
        this.iss = iss;
        this.competent_department = competent_department;
        this.technical_comm = technical_comm;
        this.standard_feature = standard_feature;
    }

    public StandardBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStandard_id() {
        return standard_id;
    }

    public void setStandard_id(String standard_id) {
        this.standard_id = standard_id;
    }

    public String getStandard_name_cn() {
        return standard_name_cn;
    }

    public void setStandard_name_cn(String standard_name_cn) {
        this.standard_name_cn = standard_name_cn;
    }

    public String getStandard_name_en() {
        return standard_name_en;
    }

    public void setStandard_name_en(String standard_name_en) {
        this.standard_name_en = standard_name_en;
    }

    public String getStandard_class() {
        return standard_class;
    }

    public void setStandard_class(String standard_class) {
        this.standard_class = standard_class;
    }

    public String getStandard_state() {
        return standard_state;
    }

    public void setStandard_state(String standard_state) {
        this.standard_state = standard_state;
    }

    public String getStandard_adopt() {
        return standard_adopt;
    }

    public void setStandard_adopt(String standard_adopt) {
        this.standard_adopt = standard_adopt;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getImpl_date() {
        return impl_date;
    }

    public void setImpl_date(String impl_date) {
        this.impl_date = impl_date;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getCompetent_department() {
        return competent_department;
    }

    public void setCompetent_department(String competent_department) {
        this.competent_department = competent_department;
    }

    public String getTechnical_comm() {
        return technical_comm;
    }

    public void setTechnical_comm(String technical_comm) {
        this.technical_comm = technical_comm;
    }

    public String getStandard_feature() {
        return standard_feature;
    }

    public void setStandard_feature(String standard_feature) {
        this.standard_feature = standard_feature;
    }
}
