package com.bawei.yk.adpter.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.yk.R;
import com.bawei.yk.entity.HomeBanner;
import com.bawei.yk.entity.HomeEntity;
import com.bawei.yk.holder.home.HomeXbannerHolder;
import com.bawei.yk.holder.home.MlssHolder1;
import com.bawei.yk.holder.home.Pzsh11;
import com.bawei.yk.holder.home.PzshHolder1;
import com.bawei.yk.holder.home.RxxpHolder1;
import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.stx.xhb.xbanner.XBanner;

import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:陈浩
 *@Date: 2019/7/27
 *@Time:11:28
 *@Description:${DESCRIPTION}
 * */public class Homeadpter extends RecyclerView.Adapter {
    private Context context;
    private HomeEntity homeEntity;
    private HomeBanner banners;

    public Homeadpter(Context context, HomeEntity homeEntity, HomeBanner banner) {
        this.context = context;
        this.homeEntity = homeEntity;
        this.banners = banner;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        switch (getItemViewType(i)) {
            case 0:
                return new HomeXbannerHolder(from.inflate(R.layout.homexbannder, viewGroup, false));
            case 1:
                return new RxxpHolder1(from.inflate(R.layout.rxxp1, viewGroup, false));
            case 2:
                return new MlssHolder1(from.inflate(R.layout.mlss1, viewGroup, false));
            case 3:
                return new PzshHolder1(from.inflate(R.layout.pzsh1, viewGroup, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        HomeEntity.ResultBean result = homeEntity.getResult();
        switch (getItemViewType(i)) {
            case 0:
                ((HomeXbannerHolder)viewHolder).homexBanner.setBannerData(banners.getResult());
                ((HomeXbannerHolder)viewHolder).homexBanner.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(context).load(banners.getResult().get(position).getImageUrl()).into((ImageView) view);
                    }
                });
                break;
            case 1:
                ((RxxpHolder1)viewHolder).rxxpname.setText(result.getRxxp().getName());
                ((RxxpHolder1)viewHolder).rxxprecy.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                //适配器
                ((RxxpHolder1)viewHolder).rxxprecy.setAdapter(new RxxpAdpter(context,result.getRxxp().getCommodityList()));
                break;
            case 2:
                ((MlssHolder1)viewHolder).mlssname.setText(result.getRxxp().getName());
                ((MlssHolder1)viewHolder).mlssrecy.setLayoutManager(new LinearLayoutManager(context));
                //适配器
                ((MlssHolder1)viewHolder).mlssrecy.setAdapter(new MlssAdpter(context,result.getMlss().getCommodityList()));
                break;
            case 3:
                ((PzshHolder1)viewHolder).pzshname.setText(result.getRxxp().getName());
                ((PzshHolder1)viewHolder).pzshrecy.setLayoutManager(new GridLayoutManager(context,2 ));
                //适配器
                ((PzshHolder1)viewHolder).pzshrecy.setAdapter(new PzshAdpter(context,result.getPzsh().getCommodityList()));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 4;
    }
}
