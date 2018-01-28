package com.bwei.ssp.andemo.activity.fragment.remenrlv;

import com.bwei.ssp.andemo.bean.Remen_Bean;
import com.bwei.ssp.andemo.model.Imodel;
import com.bwei.ssp.andemo.model.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by lenovo on 2018/1/23.
 */

public class RemenModel implements Imodel {

    public Observable<Remen_Bean>getData(){
        Remen_model remen_model = RetrofitManager.getInstance().create(Remen_model.class);
        return  remen_model.getdata();
    }
}
