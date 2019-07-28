package com.bawei.yk.view.frag;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.yk.R;
import com.bawei.yk.adpter.home.Homeadpter;
import com.bawei.yk.base.BaseFragment;
import com.bawei.yk.base.mvp.BasePresenter;
import com.bawei.yk.base.mvp.home.HomeContract;
import com.bawei.yk.base.mvp.home.HomeModelImpl;
import com.bawei.yk.base.mvp.home.HomePresenterImpl;
import com.bawei.yk.entity.HomeBanner;
import com.bawei.yk.entity.HomeEntity;
import com.bawei.yk.entity.HomeSearch;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:陈浩
 *@Date: 2019/7/26
 *@Time:20:43
 *@Description:${DESCRIPTION}
 * */public class Frag01 extends BaseFragment<HomeModelImpl, HomePresenterImpl> implements HomeContract.IhomeView {
    @BindView(R.id.san)
    ImageView san;
    @BindView(R.id.homesearch)
    ImageView homesearch;
    @BindView(R.id.homerecy)
    RecyclerView homerecy;
    private HomeBanner banner;

    @Override
    protected void iniData() {
        presenter.requestBanner();
        presenter.requestShop();
    }

    @Override
    protected int bindLayout() {
        return R.layout.frag01;
    }

    @Override
    public BasePresenter iniPresenter() {
        return new HomePresenterImpl();
    }

    @Override
    public void showShopBanner(Object obj) {
        HomeBanner banner = (HomeBanner) obj;
        this.banner = banner;
    }

    @Override
    public void showSearch(Object obj) {
        HomeSearch search = (HomeSearch) obj;
    }

    @Override
    public void showHomeShOP(Object obj) {
        HomeEntity homeEntity = (HomeEntity) obj;
        if (homeEntity.getResult() != null) {
            homerecy.setLayoutManager(new LinearLayoutManager(getActivity()));
            if (banner != null) {
                homerecy.setAdapter(new Homeadpter(getActivity(), homeEntity, banner));
            }
        }
    }

}
