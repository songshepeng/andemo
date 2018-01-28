package com.bwei.ssp.andemo.activity.fragment.bianjidz;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2018/1/26.
 */

public interface BianjiDz_model {
    @GET("quarter/publishJoke?uid=2856&token=C5837FAE21F0A4BC4A115569CDA21FFD&source=android&appVersion=101")
    Observable<BianjiDz_bean>getBzdz(@Query("content")String content);
}
