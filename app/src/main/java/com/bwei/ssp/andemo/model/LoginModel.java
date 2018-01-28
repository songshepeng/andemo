package com.bwei.ssp.andemo.model;

import com.bwei.ssp.andemo.bean.Login_Bean;

import io.reactivex.Observable;

/**
 * Created by lenovo on 2018/1/23.
 */

public class LoginModel implements Imodel {
    public Observable<Login_Bean>getLogin(String mobile,String password){
        login_model login_model = RetrofitManager.getInstance().create(login_model.class);
        return  login_model.getLogin(mobile,password);
    }


}
