package com.bwei.ssp.andemo.activity.fragment.remenrlv;

import com.bwei.ssp.andemo.bean.Remen_Bean;
import com.bwei.ssp.andemo.presenter.Ipresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/1/23.
 */

public class Remen_presenter extends Ipresenter<Remen_view> {

    private RemenModel remenModel;

    public Remen_presenter(Remen_view view) {
        super(view);
    }

    @Override
    protected void init() {
        remenModel = new RemenModel();
    }

    public  void getJs(){
        Observable<Remen_Bean> data = remenModel.getData();
        data
               .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Remen_Bean>() {
                    @Override
                    public void accept(Remen_Bean bean) throws Exception {
                        view.getData(bean);
                    }
                });
    }
}
