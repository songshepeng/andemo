package com.bwei.ssp.andemo.activity.fragment.duanzi;

import com.bwei.ssp.andemo.bean.Duanzi_bean;
import com.bwei.ssp.andemo.model.Imodel;
import com.bwei.ssp.andemo.model.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by lenovo on 2018/1/25.
 */

public class DuanziModel implements Imodel {
    public Observable<Duanzi_bean>getDzData(){
        Duanzi_model duanzi_model = RetrofitManager.getInstance().create(Duanzi_model.class);
        return  duanzi_model.getDuanziBean();
    }
}
