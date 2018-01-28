package com.bwei.ssp.andemo.activity.fragment.bianjidz;

import com.bwei.ssp.andemo.presenter.Ipresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/1/26.
 */

public class BianjiDz_Presenter extends Ipresenter<BianjiDz_view> {

    private BianjiModel bianjiModel;

    public BianjiDz_Presenter(BianjiDz_view view) {
        super(view);
    }

    @Override
    protected void init() {
        bianjiModel = new BianjiModel();
    }

    public void getBDZjs(String contern){
        Observable<BianjiDz_bean> js = bianjiModel.getJs(contern);
        js
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BianjiDz_bean>() {
                    @Override
                    public void accept(BianjiDz_bean bean) throws Exception {
                        view.getBjdz(bean);
                    }
                });
    }
}
