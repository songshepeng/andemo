package com.bwei.ssp.andemo.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.activity.fragment.Duanzi_Fragment;
import com.bwei.ssp.andemo.activity.fragment.Tuijian_Fragment;
import com.bwei.ssp.andemo.activity.fragment.Video_Fragment;
import com.bwei.ssp.andemo.avtivityutils.BaseMainActivity;
import com.bwei.ssp.andemo.view.SwitchButton;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Main2Activity extends BaseMainActivity {
    @InjectView(R.id.main_touxiang)
    ImageView mainTouxiang;
    @InjectView(R.id.main_tv)
    TextView mainTv;
    @InjectView(R.id.main_bianji)
    ImageView mainBianji;
    @InjectView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;
    @InjectView(R.id.navig)
    NavigationView navig;
    @InjectView(R.id.switch_xz)
    SwitchButton switchXz;
    @InjectView(R.id.wode)
    ImageView wode;
    @InjectView(R.id.sz)
    ImageView sz;
    @InjectView(R.id.drawer)
    DrawerLayout drawer;
    private ImageView touxiang;
    private TextView tv;

    @Override
    protected int getRootView() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
        final ImageView tx = (ImageView) findViewById(R.id.main_touxiang);
        ImageView bj = (ImageView) findViewById(R.id.main_bianji);
        tv = (TextView) findViewById(R.id.main_tv);
        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "我的作品123", Toast.LENGTH_LONG).show();
            }
        });

        View view = navig.inflateHeaderView(R.layout.head);
        touxiang = view.findViewById(R.id.touxiang);
        touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "我的作品", Toast.LENGTH_LONG).show();
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        sz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "设置中心", Toast.LENGTH_LONG).show();
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        switchXz.setOnSwitchListener(new SwitchButton.OnSwitchListener() {
            @Override
            public void onSwitchChange(int currentStatuss) {
                Toast.makeText(Main2Activity.this, "状态" + currentStatuss, Toast.LENGTH_LONG).show();
            }
        });
        navig.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.gz) {
                    startActivity(new Intent(Main2Activity.this,MyguanzhuActivity.class));
                   // Toast.makeText(Main2Activity.this, "我的关注", Toast.LENGTH_LONG).show();
                } else if (id == R.id.sc) {
                    startActivity(new Intent(Main2Activity.this,MyshoucangActivity.class));

                  //  Toast.makeText(Main2Activity.this, "我的收藏", Toast.LENGTH_LONG).show();
                } else if (id == R.id.ss) {
                    Toast.makeText(Main2Activity.this, "搜索好友", Toast.LENGTH_LONG).show();
                } else if (id == R.id.tz) {
                    Toast.makeText(Main2Activity.this, "消息通知", Toast.LENGTH_LONG).show();
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        mainBianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,bianjiActivity.class));
            }
        });

        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(8)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("推荐",R.drawable.tuijian, Tuijian_Fragment.class)
                .addTabItem("段子",R.drawable.duanzi, Duanzi_Fragment.class)
                .addTabItem("视频",R.drawable.shipin, Video_Fragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        //  Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
                        if (position==0){
                            tv.setText("热门");
                        }else if (position==1){
                            tv.setText("段子");
                        }else if (position==2){
                            tv.setText("视频");
                        }

                    }
                });

    }
}
