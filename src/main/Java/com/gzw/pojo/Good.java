package com.gzw.pojo;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


//Good是上架的商品，不是用户购物车里的

public class Good {
    private Integer goodID;
    private String goodName;
    private Double goodPrice;
    private Date createdDate;
    private  Integer createdBy;
    private  String url;
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

    public Double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }






   public void setGood(Object [] paras, HttpServletRequest req)
   {
      this.setGoodID(null);
      this.setGoodName((String) paras[0]);
      this.setGoodPrice((Double) paras[1]);
    this.setUrl((String) paras[2]);
      this.setCreatedDate(new Date());
      this.setCreatedBy((Integer) req.getSession().getAttribute("userId"));
   }




}
