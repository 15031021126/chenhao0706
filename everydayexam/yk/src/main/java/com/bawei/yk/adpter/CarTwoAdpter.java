package com.bawei.yk.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.yk.R;
import com.bawei.yk.entity.CarEntity;
import com.bawei.yk.holder.CarTwoHolder;
import com.bumptech.glide.Glide;

import java.util.List;

/*
 *@Auther:陈浩
 *@Date: 2019/7/27
 *@Time:9:15
 *@Description:${DESCRIPTION}
 * */public class CarTwoAdpter extends RecyclerView.Adapter<CarTwoHolder> {
    private Context context;
    private List<CarEntity.ResultBean.ShoppingCartListBean> shoppingCartList;

    public CarTwoAdpter(Context context, List<CarEntity.ResultBean.ShoppingCartListBean> shoppingCartList) {
        this.context = context;
        this.shoppingCartList = shoppingCartList;
    }

    @NonNull
    @Override
    public CarTwoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        return new CarTwoHolder(from.inflate(R.layout.car_two, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final CarTwoHolder carTwoHolder, int i) {
        final CarEntity.ResultBean.ShoppingCartListBean listBean = shoppingCartList.get(i);
        carTwoHolder.twocheck.setChecked(listBean.getTwocheck());
        carTwoHolder.cardname.setText(listBean.getCommodityName());
        carTwoHolder.cardprice.setText("￥" + listBean.getPrice());
        carTwoHolder.cardnum.setText("" + listBean.getCount());
        Glide.with(context).load(listBean.getPic()).into(carTwoHolder.cardimg);
        carTwoHolder.twocheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listBean.setTwocheck(carTwoHolder.twocheck.isChecked());
                twoclick.twoclick();
            }
        });

            //加减器
            carTwoHolder.jia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = listBean.getCount();
                    count++;
                    listBean.setCount(count);
                    notifyDataSetChanged();
                    twoclick.twoclick();
                }
            });
        carTwoHolder.jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = listBean.getCount();
                if (count <= 1) {
                    return;
                }
                count--;
                listBean.setCount(count);
                notifyDataSetChanged();
                twoclick.twoclick();
            }
        });

    }

    @Override
    public int getItemCount() {
        return shoppingCartList.size();
    }

    private Twoclick twoclick;

    public void setTwoclick(Twoclick twoclick) {
        this.twoclick = twoclick;
    }

    public interface Twoclick {
        void twoclick();
    }
}
