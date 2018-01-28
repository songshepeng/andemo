package com.bwei.ssp.andemo.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.bean.EventBean.Uribean;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class VideoxiangqingActivity extends AppCompatActivity {

    @InjectView(R.id.video_touxiang)
    SimpleDraweeView videoTouxiang;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_videoxiangqing);
        ButterKnife.inject(this);
        EventBus.getDefault().register(this);
        PlayerView playerView = new PlayerView(this)
                .hideMenu(true)
                .forbidTouch(false)
                .setScaleType(PlayStateParams.fitparent)
                .setPlaySource(url)
                .startPlay();
        Uri parse = Uri.parse("https://v2.modao.cc/uploads3/images/1112/11125160/raw_1500359318.jpeg");
        videoTouxiang.setImageURI(parse);
    }

    @Subscribe(sticky = true)
    public void getUrl(Uribean uribean) {
        url = uribean.getUrl();
        Log.e("url*", uribean.getUrl() + "333");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
