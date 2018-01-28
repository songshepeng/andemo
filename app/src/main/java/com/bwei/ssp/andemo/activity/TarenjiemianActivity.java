package com.bwei.ssp.andemo.activity;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.activity.fragment.guanzhu.Guanzhu_Bean;
import com.bwei.ssp.andemo.activity.fragment.guanzhu.Guanzhu_Presenter;
import com.bwei.ssp.andemo.activity.fragment.guanzhu.Guanzhu_view;
import com.bwei.ssp.andemo.activity.fragment.remenrlv.Remen_presenter;
import com.bwei.ssp.andemo.activity.fragment.remenrlv.Remen_view;
import com.bwei.ssp.andemo.activity.fragment.tarenxinxi.Taren_Presenter;
import com.bwei.ssp.andemo.activity.fragment.tarenxinxi.Taren_bran;
import com.bwei.ssp.andemo.activity.fragment.tarenxinxi.Taren_view;
import com.bwei.ssp.andemo.adapter.Remen_Adapter;
import com.bwei.ssp.andemo.bean.EventBean.UidBean;
import com.bwei.ssp.andemo.bean.Remen_Bean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TarenjiemianActivity extends AppCompatActivity implements Taren_view, Remen_view ,Guanzhu_view{

    @InjectView(R.id.back)
    TextView back;
    @InjectView(R.id.taren_name)
    TextView tarenName;
    @InjectView(R.id.zhuanfa)
    ImageView zhuanfa;
    @InjectView(R.id.xx)
    ImageView xx;
    @InjectView(R.id.duanzi_simp_tx)
    SimpleDraweeView duanziSimpTx;
    @InjectView(R.id.fensi)
    TextView fensi;
    @InjectView(R.id.guanzhu)
    TextView guanzhu;
    @InjectView(R.id.guanzhuck)
    TextView guanzhuck;
    @InjectView(R.id.zan)
    ImageView zan;
    @InjectView(R.id.zan_num)
    TextView zanNum;
    @InjectView(R.id.taren_zuopin_rlv)
    RecyclerView tarenZuopinRlv;
    @InjectView(R.id.zanbg)
    LinearLayout zanbg;
    private int uid;
    private int uid1;
    private String zank="1";
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_tarenjiemian);
        ButterKnife.inject(this);
        EventBus.getDefault().register(this);
        Remen_presenter remen_presenter = new Remen_presenter(this);
        remen_presenter.getJs();
        Taren_Presenter taren_presenter = new Taren_Presenter(this);
        taren_presenter.getJS("144");
    }

    @Subscribe(sticky = true)
    public void getUid(UidBean bean) {
        uid1 = bean.getUid();
        Log.e(
                "**", bean.getUid() + "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @OnClick({R.id.back, R.id.zhuanfa, R.id.guanzhuck, R.id.zan, R.id.zan_num})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.zhuanfa:
                break;
            case R.id.guanzhuck:
                if (code=="0"){
                    guanzhuck.setText("已关注");
                    guanzhuck.setTextColor(Color.WHITE);
                    guanzhuck.setBackgroundResource(R.drawable.taren_text_l);
                }
                if (guanzhuck.getText() == "已关注") {
                    Toast.makeText(TarenjiemianActivity.this,"取消关注😞！",Toast.LENGTH_LONG).show();
                    guanzhuck.setText("+  关注");
                    guanzhuck.setTextColor(Color.BLUE);
                    guanzhuck.setBackgroundResource(R.drawable.taren_text);
                } else {
                    guanzhuck.setText("已关注");
                    Guanzhu_Presenter guanzhu_presenter = new Guanzhu_Presenter(this);
                    guanzhu_presenter.getJs(uid1+"");
                    guanzhuck.setTextColor(Color.WHITE);
                    guanzhuck.setBackgroundResource(R.drawable.taren_text_l);
                }
                break;
            case R.id.zan:
                if (zank=="1"){
                    zanbg.setBackgroundResource(R.drawable.tarendianz_lv);
                    zank="2";
                }else if(zank=="2"){
                    zanbg.setBackgroundResource(R.drawable.tarendianz_lan);
                    zank="3";
                }else if (zank=="3"){
                    zanbg.setBackgroundResource(R.drawable.tarendianz_huan);
                    Toast.makeText(TarenjiemianActivity.this,"没有机会了呦",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.zan_num:
                break;
        }
    }

    @Override
    public void getData(Taren_bran bran) {
        Taren_bran.DataBean data = bran.getData();
        if (data.getIcon() != "" && data.getIcon() != "null") {
            Uri parse = Uri.parse(data.getIcon());
            duanziSimpTx.setImageURI(parse);
        }
        tarenName.setText(data.getNickname() + "");
        fensi.setText(data.getMobile() + "  粉丝");
        guanzhu.setText("  " + data.getUid() + "关注");
    }

    @Override
    public void getData(Remen_Bean bean) {
        Log.e("**", bean.getMsg());
        tarenZuopinRlv.setLayoutManager(new LinearLayoutManager(TarenjiemianActivity.this));
        Remen_Adapter remen_adapter = new Remen_Adapter(bean.getData(), TarenjiemianActivity.this, TarenjiemianActivity.this);
        tarenZuopinRlv.setAdapter(remen_adapter);
    }

    @Override
    public void getData(Guanzhu_Bean bean) {
        code = bean.getCode();
        Toast.makeText(TarenjiemianActivity.this,bean.getMsg(),Toast.LENGTH_LONG).show();

    }
}
