package com.bwei.ssp.andemo.activity.fragment.remenrlv;

import com.bwei.ssp.andemo.bean.Remen_Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2018/1/23.
 */

public interface Remen_model  {
    @GET("quarter/getHotVideos?token=C5837FAE21F0A4BC4A115569CDA21FFD&source=android&appVersion=101")
    Observable<Remen_Bean>getdata();
}
