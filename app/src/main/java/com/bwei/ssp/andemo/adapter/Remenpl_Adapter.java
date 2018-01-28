package com.bwei.ssp.andemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.bean.Remen_Bean;

import java.util.List;

/**
 * Created by lenovo on 2018/1/24.
 */

public class Remenpl_Adapter extends RecyclerView.Adapter<Remenpl_Adapter.Myhoder>{
    Context context;
    List<Remen_Bean.DataBean.CommentsBean> list;

    public Remenpl_Adapter(Context context, List<Remen_Bean.DataBean.CommentsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Myhoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.remen_pinglun_item, null);
        Myhoder myhoder = new Myhoder(inflate);
        return myhoder;
    }

    @Override
    public void onBindViewHolder(Myhoder holder, int position) {
        Remen_Bean.DataBean.CommentsBean commentsBean = list.get(position);
        holder.name.setText(commentsBean.getNickname()+":  ");
        holder.tv.setText("  "+commentsBean.getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myhoder extends RecyclerView.ViewHolder {
        TextView name,tv;
        public Myhoder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            tv=itemView.findViewById(R.id.tv_conter);
        }
    }
}
