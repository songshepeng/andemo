package com.bwei.ssp.andemo.activity.fragment.xbanner;

import com.bwei.ssp.andemo.bean.Xbanner_Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2018/1/23.
 */

public interface Xbanner_model {
    @GET("quarter/getAd")
    Observable<Xbanner_Bean>getData();
}
