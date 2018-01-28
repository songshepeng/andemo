package com.bwei.ssp.andemo.lx;

import com.bwei.ssp.andemo.activity.fragment.video_rm.Video_rm_Bean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2017/12/1.
 */

public interface Show_Model {
    @GET("homePage.do")
    Call<Video_rm_Bean> getssata();
}
