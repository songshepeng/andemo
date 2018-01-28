package com.bwei.ssp.andemo.activity.fragment.Remenguanzhu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.ssp.andemo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lenovo on 2018/1/26.
 */

public class DataFragment extends Fragment {
    @InjectView(R.id.tv)
    TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.remenguanzhu_item, null);
        ButterKnife.inject(this, view);
        Bundle arguments = getArguments();
        String args = (String) arguments.get("args");
        tv.setText(args);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
