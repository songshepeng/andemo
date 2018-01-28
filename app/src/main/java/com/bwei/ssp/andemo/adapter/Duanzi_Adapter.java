package com.bwei.ssp.andemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.activity.TarenjiemianActivity;
import com.bwei.ssp.andemo.bean.Duanzi_bean;
import com.bwei.ssp.andemo.bean.EventBean.UidBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by lenovo on 2018/1/25.
 */

public class Duanzi_Adapter extends RecyclerView.Adapter<Duanzi_Adapter.Myhoder> {


    Context context;
    List<Duanzi_bean.DataBean>list;

    public Duanzi_Adapter(Context context, List<Duanzi_bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Myhoder onCreateViewHolder(ViewGroup parent, int viewType) {
        Fresco.initialize(context);
        View inflate = View.inflate(context, R.layout.duanzilv_item, null);
        Myhoder myhoder = new Myhoder(inflate);
        return myhoder;
    }

    @Override
    public void onBindViewHolder(Myhoder holder, int position) {
        final Duanzi_bean.DataBean dataBean = list.get(position);

        holder.duanzi_time.setText(dataBean.getCreateTime());
        if (dataBean.getUser().getNickname()!=""){
            holder.duanzi_name.setText(dataBean.getUser().getNickname());
        }else {
            holder.duanzi_name.setText("天蝎喝牛奶");

        }
        Uri parse = Uri.parse("https://v2.modao.cc/uploads3/images/1126/11269934/raw_1500865218.jpeg");
        holder.duanzi_simp_tx.setImageURI(parse);
        if (dataBean.getContent()!=""){
            holder.duanzi_cont.setText(dataBean.getContent());
        }
        holder.duanzi_simp_tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int uid = dataBean.getUid();
                EventBus.getDefault().postSticky(new UidBean(uid));
                context.startActivity(new Intent(context, TarenjiemianActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myhoder extends RecyclerView.ViewHolder {
        TextView duanzi_name,duanzi_time,duanzi_cont;
        SimpleDraweeView duanzi_simp_tx;
        public Myhoder(View itemView) {
            super(itemView);
            duanzi_name= itemView.findViewById(R.id.duanzi_name);
            duanzi_simp_tx=itemView.findViewById(R.id.duanzi_simp_tx);
            duanzi_time=itemView.findViewById(R.id.duanzi_time);
            duanzi_cont=itemView.findViewById(R.id.duanzi_cont);
        }
    }
}
