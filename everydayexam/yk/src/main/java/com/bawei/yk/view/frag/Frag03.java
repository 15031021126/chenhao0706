package com.bawei.yk.view.frag;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.yk.R;
import com.bawei.yk.adpter.CarOneAdpter;
import com.bawei.yk.api.Api;
import com.bawei.yk.base.BaseFragment;
import com.bawei.yk.base.mvp.BasePresenter;
import com.bawei.yk.entity.CarEntity;
import com.bawei.yk.mvp.car.CarContract;
import com.bawei.yk.mvp.car.CarModelImpl;
import com.bawei.yk.mvp.car.CarPresenterImpl;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:陈浩
 *@Date: 2019/7/26
 *@Time:20:43
 *@Description:${DESCRIPTION}
 * */public class Frag03 extends BaseFragment<CarModelImpl, CarPresenterImpl> implements CarContract.CarView {
    @BindView(R.id.shop_recy)
    XRecyclerView shopRecy;
    @BindView(R.id.qx)
    CheckBox qx;
    @BindView(R.id.zj)
    TextView zj;
    @BindView(R.id.js)
    TextView js;
    private ArrayList<CarEntity.ResultBean> resultBeans = new ArrayList<>();
    private CarOneAdpter caradpter;

    @Override
    protected void iniData() {
        presenter.requestCar(Api.sessionid, Api.userid);
        shopRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (resultBeans != null) {
            //适配器
            caradpter = new CarOneAdpter(getActivity(), resultBeans);
            shopRecy.setAdapter(caradpter);
        }
        shopRecy.setLoadingMoreEnabled(false);
        shopRecy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                resultBeans.clear();
                presenter.requestCar(Api.sessionid, Api.userid);
                shopRecy.refreshComplete();
                caradpter.notifyDataSetChanged();
                zj.setText("0");
                qx.setChecked(false);
            }

            @Override
            public void onLoadMore() {

            }
        });
        //全选
        qxischek();
    }


    private void qxischek() {
        qx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < resultBeans.size(); i++) {
                    resultBeans.get(i).setOnecheck(qx.isChecked());
                    for (int j = 0; j < resultBeans.get(i).getShoppingCartList().size(); j++) {
                        resultBeans.get(i).getShoppingCartList().get(j).setTwocheck(qx.isChecked());
                    }
                }
                caradpter.notifyDataSetChanged();
                setzj();
            }
        });

        caradpter.setOnechecked(new CarOneAdpter.Onechecked() {
            @Override
            public void Onecheck() {
                Boolean flag = true;
                for (int i = 0; i < resultBeans.size(); i++) {
                    Boolean onecheck = resultBeans.get(i).getOnecheck();
                    flag = flag & onecheck;
                    Log.d("111", "flag:" + flag);
                    for (int j = 0; j < resultBeans.get(i).getShoppingCartList().size(); j++) {
                        Boolean twocheck = resultBeans.get(i).getShoppingCartList().get(j).getTwocheck();
                        flag = flag & twocheck;
                        Log.d("222", "flag:" + flag);
                    }
                }
                Log.d("Frag03", "flag:" + flag);
                qx.setChecked(flag);
                //总价
                setzj();
            }
        });

    }

    private void setzj() {
        double zongjia = 0;
        for (int i = 0; i < resultBeans.size(); i++) {
            for (int j = 0; j < resultBeans.get(i).getShoppingCartList().size(); j++) {
                int count = resultBeans.get(i).getShoppingCartList().get(j).getCount();
                int price = resultBeans.get(i).getShoppingCartList().get(j).getPrice();
                if (resultBeans.get(i).getShoppingCartList().get(j).getTwocheck()) {
                    zongjia += count * price;
                }

            }
        }
        zj.setText(zongjia + "");

    }

    @Override
    protected int bindLayout() {
        return R.layout.frag03;
    }

    @Override
    public BasePresenter iniPresenter() {
        return new CarPresenterImpl();
    }

    /**
     * 查询购物车接口的数据
     *
     * @param object
     */
    @Override
    public void shwoCar(Object object) {
        CarEntity carEntity = (CarEntity) object;
        Toast.makeText(getActivity(), carEntity.getMessage(), Toast.LENGTH_SHORT).show();
        if (carEntity.getResult().size() != 0) {
            for (int i = 0; i < carEntity.getResult().size(); i++) {
                resultBeans.add(carEntity.getResult().get(i));
                resultBeans.get(i).setOnecheck(false);
                for (int i1 = 0; i1 < resultBeans.get(i).getShoppingCartList().size(); i1++) {
                    resultBeans.get(i).getShoppingCartList().get(i1).setTwocheck(false);
                }
            }
            caradpter.notifyDataSetChanged();
        }
    }
}
