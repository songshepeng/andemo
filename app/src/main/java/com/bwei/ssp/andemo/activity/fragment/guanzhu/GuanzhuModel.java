package com.bwei.ssp.andemo.activity.fragment.guanzhu;

import com.bwei.ssp.andemo.model.Imodel;
import com.bwei.ssp.andemo.model.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by lenovo on 2018/1/26.
 */

public class GuanzhuModel implements Imodel {
    public Observable<Guanzhu_Bean>getData(String follwid){
        Guanzhu_model guanzhu_model = RetrofitManager.getInstance().create(Guanzhu_model.class);
        return  guanzhu_model.getData(follwid);
    }
}
