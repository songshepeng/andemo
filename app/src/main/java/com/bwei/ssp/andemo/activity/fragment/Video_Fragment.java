package com.bwei.ssp.andemo.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.ssp.andemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lenovo on 2018/1/22.
 */

public class Video_Fragment extends Fragment {

    @InjectView(R.id.tablelatout)
    TabLayout tabley;
    @InjectView(R.id.vp)
    ViewPager vp;
    List<Fragment> Flist =new ArrayList<>();
   List<String>list =new ArrayList<>();
    private Madapter madapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.video_fragment, null);
        ButterKnife.inject(this, v);
        Flist.add(new Video_remenFragment());
        Flist.add(new Video_fujinFragment());
        if (list.size()<3){
            list.add("热门");
            list.add("附近");
        }

        madapter = new Madapter(getActivity().getSupportFragmentManager());

        tabley.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        final TabLayout.TabLayoutOnPageChangeListener listener = new TabLayout.TabLayoutOnPageChangeListener(tabley);
        vp.addOnPageChangeListener(listener);
        tabley.setTabMode(TabLayout.MODE_FIXED);
        //让tablayout和Viewpager关联;
        tabley.setupWithViewPager(vp);
        vp.setAdapter(madapter);
        return v;
    }

    private class Madapter extends FragmentPagerAdapter {
        public Madapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return Flist.get(position);
        }

        @Override
        public int getCount() {
            return Flist.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list.get(position);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
