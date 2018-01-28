package com.bwei.ssp.andemo.activity.fragment.xbanner;

import com.bwei.ssp.andemo.bean.Xbanner_Bean;
import com.bwei.ssp.andemo.model.Imodel;
import com.bwei.ssp.andemo.model.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by lenovo on 2018/1/23.
 */

public class XbannerModel implements Imodel {
    public Observable<Xbanner_Bean>getData(){
        Xbanner_model xbanner_model = RetrofitManager.getInstance().create(Xbanner_model.class);
       return xbanner_model.getData();
    }
}
