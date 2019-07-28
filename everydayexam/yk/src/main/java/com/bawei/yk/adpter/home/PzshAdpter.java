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
import com.bawei.yk.holder.home.Pzsh11;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/*
 *@Auther:陈浩
 *@Date: 2019/6/20
 *@Time:20:49
 *@Description:${DESCRIPTION}
 * */public class PzshAdpter extends RecyclerView.Adapter<Pzsh11> {
    private Context context;
    List<HomeEntity.ResultBean.PzshBean.CommodityListBeanX> commodityList2;

    public PzshAdpter(Context context, List<HomeEntity.ResultBean.PzshBean.CommodityListBeanX> commodityList2) {
        this.context = context;
        this.commodityList2 = commodityList2;
    }

    @NonNull
    @Override
    public Pzsh11 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        return new Pzsh11(from.inflate(R.layout.pzsh11, viewGroup, false));
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull Pzsh11 pzsh11, int i) {
            pzsh11.name3.setText(commodityList2.get(i).getCommodityName());
            pzsh11.pzshprice.setText("￥" + commodityList2.get(i).getPrice());
            Glide.with(context).load(commodityList2.get(i).getMasterPic()).into(pzsh11.pzshimg);
        //跳转打动详情页面
        final int commodityId = commodityList2.get(i).getCommodityId();
    }


    @Override
    public int getItemCount() {
        return commodityList2.size();
    }
}
