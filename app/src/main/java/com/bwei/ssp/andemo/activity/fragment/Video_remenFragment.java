package com.bwei.ssp.andemo.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.activity.fragment.video_rm.SpacesItemDecoration;
import com.bwei.ssp.andemo.activity.fragment.video_rm.Video_rm_Bean;
import com.bwei.ssp.andemo.adapter.Video_rm_Adapter;
import com.bwei.ssp.andemo.lx.Show_Presenter;
import com.bwei.ssp.andemo.lx.Show_View;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lenovo on 2018/1/22.
 */

public class Video_remenFragment extends Fragment implements Show_View{

    @InjectView(R.id.video_rm_rlv)
    RecyclerView videoRmRlv;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.viedeo_remen, null);
        ButterKnife.inject(this, v);
        Show_Presenter show_presenter = new Show_Presenter(getContext(), this);
        show_presenter.qqss();

        return v;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void getrDate(Video_rm_Bean bean) {
        Log.e("**", bean.getMsg()+"video");
        Video_rm_Adapter video_rm_adapter = new Video_rm_Adapter(getContext(), bean.getRet().getList().get(0).getChildList());
        videoRmRlv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        videoRmRlv.setAdapter(video_rm_adapter);
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(16);
        videoRmRlv.addItemDecoration(spacesItemDecoration);
    }
}
