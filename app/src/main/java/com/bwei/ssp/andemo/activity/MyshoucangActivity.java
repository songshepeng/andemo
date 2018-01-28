package com.bwei.ssp.andemo.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.ssp.andemo.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class MyshoucangActivity extends AppCompatActivity {

    @InjectView(R.id.back)
    TextView back;
    @InjectView(R.id.myshoucang_del)
    TextView myshoucangDel;
    @InjectView(R.id.check)
    CheckBox check;
    @InjectView(R.id.remen_simp_tx)
    SimpleDraweeView remenSimpTx;
    @InjectView(R.id.remen_name)
    TextView remenName;
    @InjectView(R.id.remen_time)
    TextView remenTime;
    @InjectView(R.id.pingbi)
    LinearLayout pingbi;
    @InjectView(R.id.lianjie)
    LinearLayout lianjie;
    @InjectView(R.id.jubao)
    LinearLayout jubao;
    @InjectView(R.id.zhuangtai)
    LinearLayout zhuangtai;
    @InjectView(R.id.jia)
    LinearLayout jia;
    @InjectView(R.id.player_list_video)
    JCVideoPlayerStandard playerListVideo;
    @InjectView(R.id.xianshi)
    LinearLayout xianshi;
    private PopupWindow popupWindow;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_myshoucang);
        ButterKnife.inject(this);
        Uri parse = Uri.parse("https://v2.modao.cc/uploads3/images/1113/11130958/raw_1500364559.jpeg");
        remenSimpTx.setImageURI(parse);
        boolean setUp = playerListVideo.setUp("http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4", JCVideoPlayer.SCREEN_LAYOUT_LIST, "无视");
        if (setUp) {
            Glide.with(this).load("http://a4.att.hudong.com/05/71/01300000057455120185716259013.jpg").into(playerListVideo.thumbImageView);
        }



    }

    @OnClick({R.id.back, R.id.myshoucang_del, R.id.check})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                if (myshoucangDel.getText().toString() == "q") {
                    check.setVisibility(View.GONE);
                    myshoucangDel.setVisibility(View.VISIBLE);
                    myshoucangDel.setText("删除");
                    popupWindow.dismiss();
                } else {
                    finish();
                }
                break;
            case R.id.myshoucang_del:
                myshoucangDel.setText("q");
                myshoucangDel.setVisibility(View.GONE);
                check.setVisibility(View.VISIBLE);

                popupWindow = new PopupWindow(this);
                View inflate = MyshoucangActivity.this.getLayoutInflater().inflate(R.layout.del_popup, null);

                popupWindow.setContentView(inflate);

                popupWindow.setAnimationStyle(R.style.shipping_popup_style);
                //设置PopupWindow宽
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                //设置PopupWindow高
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                //在父布局的弹入/出位置
                popupWindow.showAsDropDown(playerListVideo, 0, 20);
                // rootView = LayoutInflater.from(this).inflate(R.layout.activity_myshoucang, null);
                //返回键点击，弹出
                popupWindow.setFocusable(false);
                Button del = inflate.findViewById(R.id.tv_delete);
                inflate.findViewById(R.id.tv_cancel);
                del.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        check.setVisibility(View.GONE);
                        popupWindow.dismiss();
                        xianshi.setVisibility(View.GONE);
                    }
                });


                break;
            case R.id.check:
                break;
        }
    }
}
