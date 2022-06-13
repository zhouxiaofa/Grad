package com.example.grad.bean;

/**
 * @author zxf
 */
public class IpcBean {

    private String id;
    private String abst;
    private String appDate;
    private String appid;
    private String appApplication;
    private String appApplicationType;
    private String claimsCount;
    private String claimsList;
    private String inventorList;
    private String mainIpc3;
    private String pubDate;
    private String pubid;
    private String title;

    public IpcBean(String id, String abst, String appDate, String appid, String appApplication, String appApplicationType, String claimsCount, String claimsList, String inventorList, String mainIpc3, String pubDate, String pubid, String title) {
        this.id = id;
        this.abst = abst;
        this.appDate = appDate;
        this.appid = appid;
        this.appApplication = appApplication;
        this.appApplicationType = appApplicationType;
        this.claimsCount = claimsCount;
        this.claimsList = claimsList;
        this.inventorList = inventorList;
        this.mainIpc3 = mainIpc3;
        this.pubDate = pubDate;
        this.pubid = pubid;
        this.title = title;
    }

    public IpcBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbst() {
        return abst;
    }

    public void setAbst(String abst) {
        this.abst = abst;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppApplication() {
        return appApplication;
    }

    public void setAppApplication(String appApplication) {
        this.appApplication = appApplication;
    }

    public String getAppApplicationType() {
        return appApplicationType;
    }

    public void setAppApplicationType(String appApplicationType) {
        this.appApplicationType = appApplicationType;
    }

    public String getClaimsCount() {
        return claimsCount;
    }

    public void setClaimsCount(String claimsCount) {
        this.claimsCount = claimsCount;
    }

    public String getClaimsList() {
        return claimsList;
    }

    public void setClaimsList(String claimsList) {
        this.claimsList = claimsList;
    }

    public String getInventorList() {
        return inventorList;
    }

    public void setInventorList(String inventorList) {
        this.inventorList = inventorList;
    }

    public String getMainIpc3() {
        return mainIpc3;
    }

    public void setMainIpc3(String mainIpc3) {
        this.mainIpc3 = mainIpc3;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getPubid() {
        return pubid;
    }

    public void setPubid(String pubid) {
        this.pubid = pubid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
