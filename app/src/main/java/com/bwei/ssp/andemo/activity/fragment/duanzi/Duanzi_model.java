package com.bwei.ssp.andemo.activity.fragment.duanzi;

import com.bwei.ssp.andemo.bean.Duanzi_bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2018/1/25.
 */

public interface Duanzi_model {
    @GET("quarter/getJokes?source=android&appVersion=101")
    Observable<Duanzi_bean>getDuanziBean();
}
