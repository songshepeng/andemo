package com.bwei.ssp.andemo.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by lenovo on 2018/1/23.
 */

public class Fragment0 extends BaseFragment {

    public static Fragment getInstance(String title) {
        Fragment0 fragment0 = new Fragment0();
        Bundle args = new Bundle();
        args.putString("args", title);
        fragment0.setArguments(args);
        return fragment0;
    }
}
