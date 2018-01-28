package com.bwei.ssp.andemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.activity.fragment.Remenguanzhu.FragmentQ;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RemenguanzhuActivity extends AppCompatActivity implements View.OnClickListener {
    @InjectView(R.id.ll_head)
    LinearLayout llHead;
    @InjectView(R.id.hsv)
    HorizontalScrollView hsv;
    @InjectView(R.id.viewpager)
    ViewPager viewPager;
    private String[] titles;
    private ArrayList<TextView> textViewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remenguanzhu);
        ButterKnife.inject(this);
        titles = new String[] { "新闻", "爆笑", "志力", "美食", "网红", "颜值" };
        textViewList = new ArrayList<TextView>();
        for (int i = 0; i < titles.length; i++) {
            TextView textView = new TextView(this);
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
            params.setMargins(20, 10, 20, 10);
            llHead.addView(textView, params);
            // 往集合中添加textView
            textViewList.add(textView);
        }

        viewPager.setAdapter(new FragmentPagerAdapter(
                getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public Fragment getItem(int position) {
               return FragmentQ.getInstance(titles[position]);

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
                hsv.scrollTo((width + 20) * position, 0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        viewPager.setCurrentItem(id - 10000);
    }

}
