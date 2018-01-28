package com.bwei.ssp.andemo.activity.fragment.tarenxinxi;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2018/1/26.
 */

public interface Taren_model {

    @GET("user/getUserInfo")
    Observable<Taren_bran>getData(@Query("uid")String uid);
}
