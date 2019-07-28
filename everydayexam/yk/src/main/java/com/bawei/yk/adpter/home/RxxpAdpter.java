package com.bawei.yk.adpter.home;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.yk.R;
import com.bawei.yk.entity.HomeEntity;
import com.bawei.yk.holder.home.RxxpHolder11;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.List;

/*
 *@Auther:陈浩
 *@Date: 2019/7/27
 *@Time:11:51
 *@Description:${DESCRIPTION}
 * */public class RxxpAdpter extends RecyclerView.Adapter<RxxpHolder11> {
    private Context context;
    private List<HomeEntity.ResultBean.RxxpBean.CommodityListBean> commodityList;

    public RxxpAdpter(Context context, List<HomeEntity.ResultBean.RxxpBean.CommodityListBean> commodityList) {
        this.context = context;
        this.commodityList = commodityList;
    }

    @NonNull
    @Override
    public RxxpHolder11 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        return new RxxpHolder11(from.inflate(R.layout.rxxp11, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RxxpHolder11 rxxpHolder11, int i) {
        HomeEntity.ResultBean.RxxpBean.CommodityListBean bean = commodityList.get(i);
        rxxpHolder11.name.setText(bean.getCommodityName());
        rxxpHolder11.rxxpprice.setText("￥" + bean.getPrice());

        Uri uri = Uri.parse(bean.getMasterPic());//网络图片资源
        ImageRequest build = ImageRequestBuilder.newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true).build();//设置渐进渲染已启用
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                .setOldController(rxxpHolder11.rxxpimg.getController())
                .setImageRequest(build)
                .build();
        rxxpHolder11.rxxpimg.setController(controller);
    }

    @Override
    public int getItemCount() {
        return commodityList.size();
    }
}
