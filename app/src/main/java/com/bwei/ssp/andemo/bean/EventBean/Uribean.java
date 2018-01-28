package com.bwei.ssp.andemo.bean.EventBean;

/**
 * Created by lenovo on 2018/1/25.
 */

public class Uribean {
    String url;


    public Uribean(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Uribean{" +
                "url='" + url + '\'' +
                '}';
    }
}
