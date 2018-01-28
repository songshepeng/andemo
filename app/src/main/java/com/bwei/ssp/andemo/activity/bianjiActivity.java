package com.bwei.ssp.andemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.ssp.andemo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class bianjiActivity extends AppCompatActivity {

    @InjectView(R.id.qs)
    TextView qs;
    @InjectView(R.id.video)
    ImageView video;
    @InjectView(R.id.duanzi)
    ImageView duanzi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bianji);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.qs, R.id.video, R.id.duanzi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qs:
                finish();
                break;
            case R.id.video:
                break;
            case R.id.duanzi:
                startActivity(new Intent(bianjiActivity.this,BianjiduanziActivity.class));
                break;
        }
    }
}
