package com.gzw.pojo;

import javax.servlet.http.HttpServletRequest;

public class GoodsImgUrl {
    private Integer id;
    private Integer goodId;
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setGoodsImg(Object [] paras, HttpServletRequest req) {
        this.setGoodId((Integer) paras[0]);
        this.setGoodId((Integer) paras[1]);
        this.setUrl((String) paras[2]);
    }

}
