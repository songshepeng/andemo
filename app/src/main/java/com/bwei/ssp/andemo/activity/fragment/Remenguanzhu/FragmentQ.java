package com.bwei.ssp.andemo.activity.fragment.Remenguanzhu;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by lenovo on 2018/1/26.
 */

public class FragmentQ extends DataFragment {

    public static Fragment getInstance(String title) {
        FragmentQ fragment0 = new FragmentQ();
        Bundle args = new Bundle();
        args.putString("args", title);
        fragment0.setArguments(args);
        return fragment0;
    }
}
