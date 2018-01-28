package com.bwei.ssp.andemo.avtivityutils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lenovo on 2018/1/23.
 */

public  abstract class BaseMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1、初始化布局
        setContentView(getRootView());
        //2、初始化控件
        initView();
    }
    protected void startActivity(Class<? extends Activity> clazz){
        Intent in = new Intent(this,clazz);
        startActivity(in);
    }
    /**初始化布局*/
    protected abstract int getRootView();
    /**初始化控件*/
    protected abstract void initView();

}
