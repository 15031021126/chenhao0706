package com.bawei.yk.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.yk.R;


/*
 *@Auther:陈浩
 *@Date: 2019/7/27
 *@Time:9:04
 *@Description:${DESCRIPTION}
 * */public class CarOneHolder extends RecyclerView.ViewHolder {

    public CheckBox chekone;

    public TextView cardhome;

    public RecyclerView carrecy;

    public CarOneHolder(@NonNull View itemView) {
        super(itemView);
        chekone = itemView.findViewById(R.id.chekfather);
        cardhome = itemView.findViewById(R.id.cardhome);
        carrecy = itemView.findViewById(R.id.carrecy);
    }
}
