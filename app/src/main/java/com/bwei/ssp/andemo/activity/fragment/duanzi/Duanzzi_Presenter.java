package com.bwei.ssp.andemo.activity.fragment.duanzi;

import com.bwei.ssp.andemo.bean.Duanzi_bean;
import com.bwei.ssp.andemo.presenter.Ipresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/1/25.
 */

public class Duanzzi_Presenter extends Ipresenter<Duanzi_view> {

    private DuanziModel duanziModel;

    public Duanzzi_Presenter(Duanzi_view view) {
        super(view);
    }

    @Override
    protected void init() {
        duanziModel = new DuanziModel();
    }

    public  void getDZjs(){
        Observable<Duanzi_bean> dzData = duanziModel.getDzData();
        dzData
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Duanzi_bean>() {
                    @Override
                    public void accept(Duanzi_bean bean) throws Exception {
                       view.getDuanziData(bean);
                    }
                });
    }
}
