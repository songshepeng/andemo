package com.bwei.ssp.andemo.activity.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwei.ssp.andemo.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 2018/1/22.
 */

public class Tuijian_Fragment extends Fragment implements View.OnClickListener {

    private View v;
    private LinearLayout ll_head;
    private HorizontalScrollView horizontalScrollView;
    private ViewPager viewPager;
    private String[] titles;
    private ArrayList<TextView> textViewList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = View.inflate(getActivity(), R.layout.tuijian_fragment, null);
        ll_head = (LinearLayout) v.findViewById(R.id.ll_head);
        horizontalScrollView = (HorizontalScrollView) v.findViewById(R.id.hsv);

        viewPager = (ViewPager)v.findViewById(R.id.viewpager);
        titles = new String[] { "热门", "关注" };
        textViewList = new ArrayList<TextView>();
        for (int i = 0; i < titles.length; i++) {
            TextView textView = new TextView(getActivity());
            textView.setText(titles[i]);
            // textView.setWidth(100);
            textView.setTextSize(20);
            if (i == 0) {
                textView.setTextColor(Color.RED);
            } else {
                textView.setTextColor(Color.BLACK);
            }
            // 顺便点击事件
            textView.setOnClickListener(this);
            // 定义id
            textView.setId(i + 10000);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(140, 10, 10, 20);
            ll_head.addView(textView, params);
            // 往集合中添加textView
            textViewList.add(textView);
        }
        viewPager.setAdapter(new FragmentPagerAdapter(
                getActivity().getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public Fragment getItem(int position) {
                return Fragment0.getInstance(titles[position]);

            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < textViewList.size(); i++) {
                    if (position == i) {
                        textViewList.get(i).setTextColor(Color.RED);
                    } else {
                        textViewList.get(i).setTextColor(Color.BLACK);
                    }
                }

                TextView textView = textViewList.get(position);
                int width = textView.getWidth();
                // 计算该滑到什么位置
                horizontalScrollView.scrollTo((width + 20) * position, 0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

        return v;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        viewPager.setCurrentItem(id - 10000);
    }
}
