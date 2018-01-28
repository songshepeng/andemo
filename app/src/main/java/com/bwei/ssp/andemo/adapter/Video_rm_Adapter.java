package com.bwei.ssp.andemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.activity.VideoxiangqingActivity;
import com.bwei.ssp.andemo.activity.fragment.video_rm.Video_rm_Bean;
import com.bwei.ssp.andemo.bean.EventBean.Uribean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/1/25.
 */

public class Video_rm_Adapter extends RecyclerView.Adapter<Video_rm_Adapter.Myhoder>{

    Context context;
    List<Video_rm_Bean.RetBean.ListBean.ChildListBean> list;

    public Video_rm_Adapter(Context context, List<Video_rm_Bean.RetBean.ListBean.ChildListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Myhoder onCreateViewHolder(ViewGroup parent, int viewType) {
        Fresco.initialize(context);
        View inflate = View.inflate(context, R.layout.videl_rm_item, null);
        Myhoder myhoder = new Myhoder(inflate);
        return myhoder;
    }

    @Override
    public void onBindViewHolder(Myhoder holder, final int position) {
        final List<String> listurl =new ArrayList<>();
        listurl.add("http://flv2.bn.netease.com/videolib3/1604/28/fVobI0704/SD/fVobI0704-mobile.mp4");
        listurl.add("http://flv2.bn.netease.com/tvmrepo/2016/4/G/O/EBKQOA8GO/SD/EBKQOA8GO-mobile.mp4");
        listurl.add("http://flv2.bn.netease.com/tvmrepo/2016/4/M/Q/EBKQO95MQ/SD/EBKQO95MQ-mobile.mp4");
        listurl.add("http://flv2.bn.netease.com/tvmrepo/2016/4/G/S/EBKQO7TGS/SD/EBKQO7TGS-mobile.mp4");
        listurl.add("http://flv2.bn.netease.com/tvmrepo/2016/4/0/K/EBKQO3C0K-mobile.mp4");
        listurl.add("http://flv2.bn.netease.com/tvmrepo/2016/4/I/G/EBKQO2SIG/SD/EBKQO2SIG-mobile.mp4");
        listurl.add("http://flv2.bn.netease.com/tvmrepo/2016/4/5/G/EBKQO085G/SD/EBKQO085G-mobile.mp4");
        listurl.add("http://flv2.bn.netease.com/tvmrepo/2016/4/U/4/EBKQN3GU4/SD/EBKQN3GU4-mobile.mp4");
        Video_rm_Bean.RetBean.ListBean.ChildListBean childListBean = list.get(position);
        Uri parse = Uri.parse(childListBean.getPic());
        holder.video_sim.setImageURI(parse);

        holder.video_sim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = listurl.get(position);
                Log.e("**", "123"+s );
                EventBus.getDefault().postSticky(new Uribean(s));
                context.startActivity(new Intent(context, VideoxiangqingActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myhoder extends RecyclerView.ViewHolder {
        SimpleDraweeView video_sim;
        public Myhoder(View itemView) {
            super(itemView);
            video_sim=itemView.findViewById(R.id.video_sim);
        }
    }
}
