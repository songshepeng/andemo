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
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.activity.fragment.remenrlv.Remen_presenter;
import com.bwei.ssp.andemo.activity.fragment.remenrlv.Remen_view;
import com.bwei.ssp.andemo.activity.fragment.xbanner.Xbanner_presenter;
import com.bwei.ssp.andemo.activity.fragment.xbanner.Xbanner_view;
import com.bwei.ssp.andemo.adapter.Remen_Adapter;
import com.bwei.ssp.andemo.bean.Remen_Bean;
import com.bwei.ssp.andemo.bean.Xbanner_Bean;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lenovo on 2018/1/22.
 */

public class BaseFragment extends Fragment implements Xbanner_view,Remen_view{


    @InjectView(R.id.remen_xbanner)
    XBanner remenXbanner;
    @InjectView(R.id.remen_rlv)
    RecyclerView remenRlv;
    private View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String args = (String) arguments.get("args");
        if (args.equals("热门")) {
            v = View.inflate(getActivity(), R.layout.base_fragment, null);
            ButterKnife.inject(this, v);
            Xbanner_presenter xbanner_presenter = new Xbanner_presenter(this);
            xbanner_presenter.getJs();
            Remen_presenter remen_presenter = new Remen_presenter(this);
            remen_presenter.getJs();
        } else if (args.equals("关注")) {
         //   v = View.inflate(getActivity(), R.layout.base_fragment, null);
        }
        return v;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    @Override
    public void getData(Xbanner_Bean bean) {
       final List<String> images = new ArrayList<>();
        List<Xbanner_Bean.DataBean> data = bean.getData();
        for (int i = 0; i <data.size() ; i++) {
            images.add(data.get(i).getIcon());
        }
        remenXbanner.setData(images,null);
        remenXbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(images.get(position)).into((ImageView) view);
            }
        });
    }

    @Override
    public void getData(Remen_Bean bean) {
        Log.e("**", bean.getMsg());
        remenRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        Remen_Adapter remen_adapter = new Remen_Adapter(bean.getData(), getActivity(),getActivity());
        remenRlv.setAdapter(remen_adapter);
    }
//
//    @Override
//    public void getData(Remen_Bean bean) {
//        Log.e("**", bean.getMsg());
//    }
}
