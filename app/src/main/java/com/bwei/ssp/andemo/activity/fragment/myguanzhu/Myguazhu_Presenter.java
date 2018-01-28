package com.bwei.ssp.andemo.activity.fragment.myguanzhu;

import com.bwei.ssp.andemo.presenter.Ipresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/1/26.
 */

public class Myguazhu_Presenter extends Ipresenter<Myguanzhu_view> {

    private MyguanzhuModel myguanzhuModel;

    public Myguazhu_Presenter(Myguanzhu_view view) {
        super(view);
    }

    @Override
    protected void init() {
        myguanzhuModel = new MyguanzhuModel();
    }
    public void getJs(){
        Observable<Myguabzhu_Bean> data = myguanzhuModel.getData();
        data
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Myguabzhu_Bean>() {
                    @Override
                    public void accept(Myguabzhu_Bean bean) throws Exception {
                        view.getData(bean);
                    }
                });
    }

}
