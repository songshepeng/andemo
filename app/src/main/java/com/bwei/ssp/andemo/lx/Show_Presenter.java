package com.bwei.ssp.andemo.lx;

import android.content.Context;

import com.bwei.ssp.andemo.activity.fragment.video_rm.Video_rm_Bean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2017/12/1.
 */

public class Show_Presenter {
  Context context;
    Show_Model show_model;
    Show_View view;

    public Show_Presenter(Context context, Show_View view) {
        this.context = context;
        this.view = view;
    }

    public void qqss(){
      Retrofit retrofit = new Retrofit.Builder()
      .baseUrl("http://api.svipmovie.com/front/homePageApi/")
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build();
      show_model = retrofit.create(Show_Model.class);
      Call<Video_rm_Bean> call = show_model.getssata();
      call.enqueue(new Callback<Video_rm_Bean>() {
          @Override
          public void onResponse(Call<Video_rm_Bean> call, Response<Video_rm_Bean> response) {
              Video_rm_Bean bean = response.body();
              view.getrDate(bean);
          }

          @Override
          public void onFailure(Call<Video_rm_Bean> call, Throwable t) {

          }
      });
  }





}
