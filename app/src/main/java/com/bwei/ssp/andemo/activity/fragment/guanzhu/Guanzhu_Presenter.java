package com.bwei.ssp.andemo.activity.fragment.guanzhu;

import com.bwei.ssp.andemo.presenter.Ipresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/1/26.
 */

public class Guanzhu_Presenter extends Ipresenter<Guanzhu_view> {

    private GuanzhuModel guanzhuModel;

    public Guanzhu_Presenter(Guanzhu_view view) {
        super(view);
    }

    @Override
    protected void init() {
        guanzhuModel = new GuanzhuModel();
    }
    public  void getJs(String follwid){
        Observable<Guanzhu_Bean> data = guanzhuModel.getData(follwid);
        data
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Guanzhu_Bean>() {
                    @Override
                    public void accept(Guanzhu_Bean bean) throws Exception {
                        view.getData(bean);
                    }
                });
    }
}
