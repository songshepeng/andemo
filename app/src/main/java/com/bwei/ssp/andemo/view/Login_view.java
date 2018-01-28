package com.bwei.ssp.andemo.view;

import com.bwei.ssp.andemo.bean.Login_Bean;

/**
 * Created by lenovo on 2018/1/23.
 */

public interface Login_view extends Iview {
    void getYs(Login_Bean loginBean);
    void getNo(Throwable throwable);

}
