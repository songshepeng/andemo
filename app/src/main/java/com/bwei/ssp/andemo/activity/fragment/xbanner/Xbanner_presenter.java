package com.bwei.ssp.andemo.activity.fragment.xbanner;

import com.bwei.ssp.andemo.bean.Xbanner_Bean;
import com.bwei.ssp.andemo.presenter.Ipresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/1/23.
 */

public class Xbanner_presenter extends Ipresenter<Xbanner_view> {

    private XbannerModel xbannerModel;

    public Xbanner_presenter(Xbanner_view view) {
        super(view);
    }

    @Override
    protected void init() {
        xbannerModel = new XbannerModel();
    }
    public void getJs(){
        Observable<Xbanner_Bean> data = xbannerModel.getData();
        data
           .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Xbanner_Bean>() {
                    @Override
                    public void accept(Xbanner_Bean xbannerBean) throws Exception {
                   view.getData(xbannerBean);
                    }
                });
    }
}
