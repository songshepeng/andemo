package com.bwei.ssp.andemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.activity.fragment.myguanzhu.Myguabzhu_Bean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by lenovo on 2018/1/26.
 */

public class MyGuanzhu_Adapter extends RecyclerView.Adapter<MyGuanzhu_Adapter.Myhoder> {
    Context context;
    List<Myguabzhu_Bean.DataBean>list;

    public MyGuanzhu_Adapter(Context context, List<Myguabzhu_Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Myhoder onCreateViewHolder(ViewGroup parent, int viewType) {
        Fresco.initialize(context);
        View inflate = View.inflate(context, R.layout.myguanzhu_rlv_item, null);
        Myhoder myhoder = new Myhoder(inflate);
        return myhoder;
    }

    @Override
    public void onBindViewHolder(Myhoder holder, int position) {
        Myguabzhu_Bean.DataBean dataBean = list.get(position);
        Uri parse = Uri.parse("https://v2.modao.cc/uploads3/images/1102/11026803/raw_1499945498.jpeg");
        holder.myguazhu_tx.setImageURI(parse);
        holder.myguazhu_name.setText(dataBean.getNickname()+"小狼");
        holder.myguazhu_time.setText(dataBean.getCreatetime()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myhoder extends RecyclerView.ViewHolder {
        SimpleDraweeView myguazhu_tx;
        TextView myguazhu_name,myguazhu_time;
        public Myhoder(View itemView) {
            super(itemView);
            myguazhu_tx=itemView.findViewById(R.id.myguazhu_tx);
            myguazhu_name= itemView.findViewById(R.id.myguazhu_name);
            myguazhu_time=itemView.findViewById(R.id.myguazhu_time);
        }
    }
}
