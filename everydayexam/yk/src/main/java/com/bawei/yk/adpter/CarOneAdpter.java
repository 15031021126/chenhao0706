package com.bawei.yk.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.yk.R;
import com.bawei.yk.entity.CarEntity;
import com.bawei.yk.holder.CarOneHolder;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/7/27
 *@Time:9:10
 *@Description:${DESCRIPTION}
 * */public class CarOneAdpter extends RecyclerView.Adapter<CarOneHolder> {
    private Context context;
    private ArrayList<CarEntity.ResultBean> resultBeans;

    public CarOneAdpter(Context context, ArrayList<CarEntity.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public CarOneHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        return new CarOneHolder(from.inflate(R.layout.car_one, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final CarOneHolder carOneHolder, final int i) {
        carOneHolder.cardhome.setText(resultBeans.get(i).getCategoryName());
        Log.d("CarOneAdpter", "resultBeans.get(i).getOnecheck():" + resultBeans.get(i).getOnecheck());
        carOneHolder.chekone.setChecked(resultBeans.get(i).getOnecheck());
        carOneHolder.carrecy.setLayoutManager(new LinearLayoutManager(context));
        final CarTwoAdpter carTwoAdpter = new CarTwoAdpter(context, resultBeans.get(i).getShoppingCartList());
        carOneHolder.carrecy.setAdapter(carTwoAdpter);

        //点击一级选择设置二级ben的状态
        carOneHolder.chekone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBeans.get(i).setOnecheck(carOneHolder.chekone.isChecked());
                for (int i1 = 0; i1 < resultBeans.get(i).getShoppingCartList().size(); i1++) {
                    resultBeans.get(i).getShoppingCartList().get(i1).setTwocheck(carOneHolder.chekone.isChecked());
                }
                carTwoAdpter.notifyDataSetChanged();
                onechecked.Onecheck();

            }
        });
        //二级条目点击事假
        carTwoAdpter.setTwoclick(new CarTwoAdpter.Twoclick() {
            @Override
            public void twoclick() {
                Boolean flag = true;
                for (int j = 0; j < resultBeans.get(i).getShoppingCartList().size(); j++) {
                    flag = flag & resultBeans.get(i).getShoppingCartList().get(j).getTwocheck();
                }
                Log.d("CarOneAdpter", "flag:" + flag);
                resultBeans.get(i).setOnecheck(flag);
                carOneHolder.chekone.setChecked(flag);
                //回调到外面
                onechecked.Onecheck();
            }
        });

    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public void setOnechecked(Onechecked onechecked) {
        this.onechecked = onechecked;
    }

    private Onechecked onechecked;

    public interface Onechecked {
        void Onecheck();
    }
}
