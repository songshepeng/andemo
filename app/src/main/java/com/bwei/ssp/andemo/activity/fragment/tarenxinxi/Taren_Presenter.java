package com.bwei.ssp.andemo.activity.fragment.tarenxinxi;

import com.bwei.ssp.andemo.presenter.Ipresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/1/26.
 */

public class Taren_Presenter extends Ipresenter<Taren_view> {

    private TarenModel tarenModel;

    public Taren_Presenter(Taren_view view) {
        super(view);
    }

    @Override
    protected void init() {
        tarenModel = new TarenModel();
    }
    public  void  getJS(String uid){
        Observable<Taren_bran> data = tarenModel.getData(uid);
        data
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Taren_bran>() {
                    @Override
                    public void accept(Taren_bran bran) throws Exception {
                       view.getData(bran);
                    }
                });
    }

}
