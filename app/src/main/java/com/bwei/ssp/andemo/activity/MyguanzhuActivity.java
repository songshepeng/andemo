package com.bwei.ssp.andemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.activity.fragment.myguanzhu.Myguabzhu_Bean;
import com.bwei.ssp.andemo.activity.fragment.myguanzhu.Myguanzhu_view;
import com.bwei.ssp.andemo.activity.fragment.myguanzhu.Myguazhu_Presenter;
import com.bwei.ssp.andemo.adapter.MyGuanzhu_Adapter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MyguanzhuActivity extends AppCompatActivity implements Myguanzhu_view{

    @InjectView(R.id.back)
    TextView back;
    @InjectView(R.id.remenguazhu)
    TextView remenguazhu;
    @InjectView(R.id.myguanzhu_rlv)
    RecyclerView myguanzhuRlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myguanzhu);
        ButterKnife.inject(this);
        Myguazhu_Presenter myguazhu_presenter = new Myguazhu_Presenter(this);
        myguazhu_presenter.getJs();
    }

    @OnClick({R.id.back, R.id.remenguazhu, R.id.myguanzhu_rlv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.remenguazhu:
                startActivity(new Intent(MyguanzhuActivity.this,RemenguanzhuActivity.class));
                break;
        }
    }

    @Override
    public void getData(Myguabzhu_Bean bean) {
        Log.e("**", bean.getMsg());
        myguanzhuRlv.setLayoutManager(new LinearLayoutManager(MyguanzhuActivity.this));
        MyGuanzhu_Adapter myGuanzhu_adapter = new MyGuanzhu_Adapter(MyguanzhuActivity.this, bean.getData());
        myguanzhuRlv.setAdapter(myGuanzhu_adapter);
    }
}
