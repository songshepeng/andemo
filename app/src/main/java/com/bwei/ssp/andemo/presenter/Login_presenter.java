package com.bwei.ssp.andemo.presenter;

import com.bwei.ssp.andemo.bean.Login_Bean;
import com.bwei.ssp.andemo.model.LoginModel;
import com.bwei.ssp.andemo.view.Login_view;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/1/23.
 */

public class Login_presenter extends Ipresenter<Login_view> {

    private LoginModel loginModel;

    public Login_presenter(Login_view view) {
        super(view);
    }

    @Override
    protected void init() {
        loginModel = new LoginModel();
    }
    public void getLoginJs(String mobile,String password){
        Observable<Login_Bean> login = loginModel.getLogin(mobile, password);
        login
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Login_Bean>() {
                               @Override
                               public void accept(Login_Bean loginBean) throws Exception {
                                   view.getYs(loginBean);
                               }
                           }
                        , new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                view.getNo(throwable);
                            }
                        }
                );

    }



}
