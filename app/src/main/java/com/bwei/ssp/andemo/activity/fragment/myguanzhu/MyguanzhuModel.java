package com.bwei.ssp.andemo.activity.fragment.myguanzhu;

import com.bwei.ssp.andemo.model.Imodel;
import com.bwei.ssp.andemo.model.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by lenovo on 2018/1/26.
 */

public class MyguanzhuModel implements Imodel {
    public Observable<Myguabzhu_Bean>getData(){
        Myguanzhu_model myguanzhu_model = RetrofitManager.getInstance().create(Myguanzhu_model.class);
        return  myguanzhu_model.getData();
    }
}
