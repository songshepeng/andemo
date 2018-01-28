package com.bwei.ssp.andemo.activity.fragment.video_rm;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by lenovo on 2018/1/25.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        //第一个不设置间隔,否则顶部有空白
        if (parent.getChildPosition(view) == 0 || parent.getChildPosition(view) == 1) {
            outRect.top = space;
        }
    }
}
