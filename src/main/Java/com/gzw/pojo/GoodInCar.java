package com.gzw.pojo;
//购物车中的商品

import java.util.Date;

public class GoodInCar {

    private  Integer goodID;
    private String goodName;
    private  Double goodPrice;
    private  Integer goodNumber;
    private String addressDesc;
    private Date creationDate;
    private  String url;
    private  Integer userId;
    private Integer isPayment;
    private Integer id;

    @Override
    public String toString() {
        return "GoodInCar{" +
                "goodID=" + goodID +
                ", goodName='" + goodName + '\'' +
                ", goodPrice=" + goodPrice +
                ", goodNumber=" + goodNumber +
                ", addressDesc='" + addressDesc + '\'' +
                ", creationDate=" + creationDate +
                ", url='" + url + '\'' +
                ", userId=" + userId +
                ", isPayment=" + isPayment +
                '}';
    }

    public Integer getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(Integer isPayment) {
        this.isPayment = isPayment;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }



    public Integer getGoodID() {
        return goodID;
    }

    public void setGoodID(Integer goodID) {
        this.goodID = goodID;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }



    public Integer getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(Integer goodNumber) {
        this.goodNumber = goodNumber;
    }

    public String getAddressDesc() {
        return addressDesc;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }





}
