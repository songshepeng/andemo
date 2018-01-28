package com.bwei.ssp.andemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.activity.fragment.bianjidz.BianjiDz_Presenter;
import com.bwei.ssp.andemo.activity.fragment.bianjidz.BianjiDz_bean;
import com.bwei.ssp.andemo.activity.fragment.bianjidz.BianjiDz_view;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class BianjiduanziActivity extends AppCompatActivity implements BianjiDz_view {

    @InjectView(R.id.qs)
    TextView qs;
    @InjectView(R.id.fabiao)
    TextView fabiao;
    @InjectView(R.id.duanzi_con)
    EditText duanziCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bianjiduanzi);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.qs, R.id.fabiao, R.id.duanzi_con})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qs:
                finish();
                break;
            case R.id.fabiao:
                BianjiDz_Presenter bianjiDz_presenter = new BianjiDz_Presenter(this);
                bianjiDz_presenter.getBDZjs(duanziCon.getText().toString());
                startActivity(new Intent(BianjiduanziActivity.this,DuanziYsActivity.class));
                break;
        }
    }
    @Override
    public void getBjdz(BianjiDz_bean bean) {
        Toast.makeText(BianjiduanziActivity.this,bean.getMsg(),Toast.LENGTH_LONG).show();
        if (bean.getMsg()=="发布成功"){
             startActivity(new Intent(BianjiduanziActivity.this,DuanziYsActivity.class));
        }
    }
}
