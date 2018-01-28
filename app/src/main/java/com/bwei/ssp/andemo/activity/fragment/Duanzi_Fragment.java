package com.bwei.ssp.andemo.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.activity.fragment.duanzi.Duanzi_view;
import com.bwei.ssp.andemo.activity.fragment.duanzi.Duanzzi_Presenter;
import com.bwei.ssp.andemo.adapter.Duanzi_Adapter;
import com.bwei.ssp.andemo.bean.Duanzi_bean;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lenovo on 2018/1/22.
 */

public class Duanzi_Fragment extends Fragment implements Duanzi_view {


    @InjectView(R.id.duanzi_rlv)
    RecyclerView duanziRlv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.duanzi_fragment, null);
        Duanzzi_Presenter duanzzi_presenter = new Duanzzi_Presenter(this);
        duanzzi_presenter.getDZjs();
        ButterKnife.inject(this, v);
        return v;
    }


    @Override
    public void getDuanziData(Duanzi_bean bean) {
        Log.e("**", bean.getMsg() + "dz");
        duanziRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        Duanzi_Adapter duanzi_adapter = new Duanzi_Adapter(getContext(), bean.getData());
        duanziRlv.setAdapter(duanzi_adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
