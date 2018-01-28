package com.bwei.ssp.andemo.activity.fragment.guanzhu;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2018/1/26.
 */

public interface Guanzhu_model {
     @GET("quarter/follow?token=C5837FAE21F0A4BC4A115569CDA21FFD&source=android&appVersion=101&uid=2856")
    Observable<Guanzhu_Bean>getData(@Query("followId")String followid);
}
