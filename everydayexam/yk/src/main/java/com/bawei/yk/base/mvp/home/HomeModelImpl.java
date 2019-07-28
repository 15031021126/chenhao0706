package com.bawei.yk.base.mvp.home;

import android.util.Log;

import com.bawei.yk.api.ApiService;
import com.bawei.yk.base.net.CallBackObj;
import com.bawei.yk.base.net.RetrofitUntils;
import com.bawei.yk.entity.HomeBanner;
import com.bawei.yk.entity.HomeEntity;
import com.bawei.yk.entity.HomeSearch;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:陈浩
 *@Date: 2019/7/16
 *@Time:19:32
 *@Description:${DESCRIPTION}
 * */public class HomeModelImpl implements HomeContract.IhomeModel {
    @Override
    public void dogetBanner(final CallBackObj callBackObj) {
        RetrofitUntils.getInstance().create(ApiService.class).getHomeXbanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeBanner>() {
                    @Override
                    public void accept(HomeBanner homeBanner) throws Exception {
                        callBackObj.success(homeBanner);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("123", "throwable:" + throwable);
                    }
                });
    }

    @Override
    public void getSearch(String keyword, String page,String count,final CallBackObj callBackStr) {
        RetrofitUntils.getInstance().create(ApiService.class).HomeSearch(keyword,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeSearch>() {
                    @Override
                    public void accept(HomeSearch homeBanner) throws Exception {
                        callBackStr.success(homeBanner);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("123", "throwable:" + throwable);
                    }
                });
    }

    @Override
    public void dogetShop(final CallBackObj callBackObj) {
        RetrofitUntils.getInstance().create(ApiService.class).getHome()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeEntity>() {
                    @Override
                    public void accept(HomeEntity homeBanner) throws Exception {
                        callBackObj.success(homeBanner);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("123", "throwable:" + throwable);
                    }
                });
    }


}
