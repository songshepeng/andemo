package com.bwei.ssp.andemo.activity.fragment.bianjidz;

import com.bwei.ssp.andemo.model.Imodel;
import com.bwei.ssp.andemo.model.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by lenovo on 2018/1/26.
 */

public class BianjiModel implements Imodel {
    public Observable<BianjiDz_bean>getJs(String content){
        BianjiDz_model bianjiDz_model = RetrofitManager.getInstance().create(BianjiDz_model.class);
        return bianjiDz_model.getBzdz(content);
    }
}
