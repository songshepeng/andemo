package com.bwei.ssp.andemo.activity.fragment.tarenxinxi;

import com.bwei.ssp.andemo.model.Imodel;
import com.bwei.ssp.andemo.model.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by lenovo on 2018/1/26.
 */

public class TarenModel implements Imodel {

    public Observable<Taren_bran>getData(String uid){
        Taren_model taren_model = RetrofitManager.getInstance().create(Taren_model.class);
        return taren_model.getData(uid);
    }
}
