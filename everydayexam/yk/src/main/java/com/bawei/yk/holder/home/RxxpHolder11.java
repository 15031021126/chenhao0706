package com.bawei.yk.holder.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yk.R;
import com.facebook.drawee.view.SimpleDraweeView;

/*
 *@Auther:陈浩
 *@Date: 2019/6/20
 *@Time:20:43
 *@Description:${DESCRIPTION}
 * */public class RxxpHolder11 extends RecyclerView.ViewHolder {

    public final TextView rxxpprice;
    public final TextView name;
    public final SimpleDraweeView rxxpimg;

    public RxxpHolder11(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        rxxpimg = itemView.findViewById(R.id.rxxpimg);
        rxxpprice = itemView.findViewById(R.id.rxxpprice);
    }
}
