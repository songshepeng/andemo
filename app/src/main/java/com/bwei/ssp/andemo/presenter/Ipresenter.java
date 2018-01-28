package com.bwei.ssp.andemo.presenter;

import com.bwei.ssp.andemo.view.Iview;

/**
 * Created by lenovo on 2018/1/23.
 */

public abstract  class Ipresenter <T extends Iview>{
    protected   T view;

    public Ipresenter(T view) {
        this.view = view;
        //用来创建modle
        init();
    }

    protected abstract void init();
}
