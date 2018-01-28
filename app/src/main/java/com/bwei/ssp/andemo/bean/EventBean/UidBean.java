package com.bwei.ssp.andemo.bean.EventBean;

/**
 * Created by lenovo on 2018/1/26.
 */

public class UidBean {
    int uid;

    public UidBean(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UidBean{" +
                "uid=" + uid +
                '}';
    }
}
