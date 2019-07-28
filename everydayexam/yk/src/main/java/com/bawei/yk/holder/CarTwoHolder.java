package com.bawei.yk.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yk.R;


/*
 *@Auther:陈浩
 *@Date: 2019/7/27
 *@Time:9:04
 *@Description:${DESCRIPTION}
 * */public class CarTwoHolder extends RecyclerView.ViewHolder {


    public CheckBox twocheck;

    public ImageView cardimg;

    public TextView cardname;

    public TextView cardprice;

    public TextView jian;

    public EditText cardnum;

    public TextView jia;

    public CarTwoHolder(@NonNull View itemView) {
        super(itemView);
        twocheck = itemView.findViewById(R.id.twocheck);
        cardimg = itemView.findViewById(R.id.cardimg);
        cardname = itemView.findViewById(R.id.cardname);
        cardprice = itemView.findViewById(R.id.cardprice);
        jian = itemView.findViewById(R.id.jian);
        cardnum = itemView.findViewById(R.id.cardnum);
        jia = itemView.findViewById(R.id.jia);
    }
}
