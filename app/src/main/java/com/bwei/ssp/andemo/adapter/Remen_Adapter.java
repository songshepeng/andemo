package com.bwei.ssp.andemo.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.bean.Remen_Bean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by lenovo on 2018/1/24.
 */

public class Remen_Adapter extends RecyclerView.Adapter<Remen_Adapter.Myhoder> {
    List<Remen_Bean.DataBean>list;
    Context context;
    Activity activity;
    private int q=1;

    public Remen_Adapter(List<Remen_Bean.DataBean> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public Myhoder onCreateViewHolder(ViewGroup parent, int viewType) {
        Fresco.initialize(context);
        View inflate = View.inflate(context, R.layout.remenrlv_item, null);
        Myhoder myhoder = new Myhoder(inflate);
        return myhoder;
    }

    @Override
    public void onBindViewHolder(Myhoder holder, int position) {
        Remen_Bean.DataBean dataBean = list.get(position);
        Uri parse = Uri.parse("https://v2.modao.cc/uploads3/images/1113/11130958/raw_1500364559.jpeg");
        holder.remen_simp_tx.setImageURI(parse);
        holder.remen_name.setText(dataBean.getUser().getNickname());
        holder.remen_time.setText(dataBean.getCreateTime());

        holder.remen_rlv.setLayoutManager(new LinearLayoutManager(context));
        List<Remen_Bean.DataBean.CommentsBean> comments = dataBean.getComments();
        Remenpl_Adapter remenpl_adapter = new Remenpl_Adapter(context, comments);
        holder.remen_rlv.setAdapter(remenpl_adapter);
        boolean setUp = holder.player.setUp("http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4", JCVideoPlayer.SCREEN_LAYOUT_LIST, "无视");
        if (setUp) {
            Glide.with(context).load("http://a4.att.hudong.com/05/71/01300000057455120185716259013.jpg").into(holder.player.thumbImageView);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myhoder extends RecyclerView.ViewHolder {
        SimpleDraweeView remen_simp_tx;
        TextView remen_name,remen_time,miaoshu;
        RecyclerView remen_rlv;
        JCVideoPlayerStandard player;
        CheckBox chek;
        public Myhoder(View itemView) {
            super(itemView);
            remen_simp_tx= itemView.findViewById(R.id.remen_simp_tx);
            remen_name=itemView.findViewById(R.id.remen_name);
            remen_time=itemView.findViewById(R.id.remen_time);
            player=itemView.findViewById(R.id.player_list_video);
            remen_rlv=itemView.findViewById(R.id.renmen_pinglun_rlv);


        }
    }
}
