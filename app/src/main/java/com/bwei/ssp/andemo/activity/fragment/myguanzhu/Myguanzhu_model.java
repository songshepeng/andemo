package com.bwei.ssp.andemo.activity.fragment.myguanzhu;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2018/1/26.
 */

public interface Myguanzhu_model  {
    @GET("quarter/getFollowUsers?token=C5837FAE21F0A4BC4A115569CDA21FFD&source=android&appVersion=101&uid=2856")
    Observable<Myguabzhu_Bean>getData();

}
