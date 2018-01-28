package com.bwei.ssp.andemo.model;

import com.bwei.ssp.andemo.bean.Login_Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2018/1/23.
 */

public interface login_model {
    @GET("user/login")
    Observable<Login_Bean>getLogin(@Query("mobile")String mobile,@Query("password")String password);

}
