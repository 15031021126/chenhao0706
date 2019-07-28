package com.bawei.yk.adpter.home;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.yk.R;
import com.bawei.yk.entity.HomeEntity;
import com.bawei.yk.holder.home.Mlss11;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/*
 *@Auther:陈浩
 *@Date: 2019/6/20
 *@Time:20:49
 *@Description:${DESCRIPTION}
 * */public class MlssAdpter extends RecyclerView.Adapter<Mlss11> {
    private Context context;
    List<HomeEntity.ResultBean.MlssBean.CommodityListBeanXX> commodityList;

    public MlssAdpter(Context context, List<HomeEntity.ResultBean.MlssBean.CommodityListBeanXX> commodityList) {
        this.context = context;
        this.commodityList = commodityList;
    }

    @NonNull
    @Override
    public Mlss11 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        return new Mlss11(from.inflate(R.layout.mlss11, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Mlss11 mlss11, int i) {
        mlss11.mlssname.setText(commodityList.get(i).getCommodityName());
        mlss11.mlssprice.setText("￥" + commodityList.get(i).getPrice());
        Glide.with(context).load(commodityList.get(i).getMasterPic()).into(mlss11.mlssimg);
      //跳转打动详情页面
        final int commodityId = commodityList.get(i).getCommodityId();

    }


    @Override
    public int getItemCount() {
        return commodityList.size();
    }
}
