package com.bawei.yk.view.frag;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
 * */public class Frag05 extends BaseFragment<CarModelImpl, CarPresenterImpl> implements CarContract.CarView {
    @BindView(R.id.shop_recy)
    XRecyclerView shopRecy;
    @BindView(R.id.qx)
    CheckBox qx;
    @BindView(R.id.zj)
    TextView zj;
    @BindView(R.id.js)
    TextView js;
    private ArrayList<CarEntity.ResultBean> resultBeans = new ArrayList<>();

    @Override
    protected void iniData() {
        presenter.requestCar(Api.sessionid, Api.userid);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.requestCar(Api.sessionid, Api.userid);
        }


    }

    @Override
    protected int bindLayout() {
        return R.layout.frag05;
    }

    @Override
    public BasePresenter iniPresenter() {
        return null;
    }

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
        }
    }
}
