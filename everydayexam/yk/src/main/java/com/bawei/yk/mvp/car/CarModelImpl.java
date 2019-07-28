package com.bawei.yk.mvp.car;

import android.util.Log;

import com.bawei.yk.api.ApiService;
import com.bawei.yk.base.net.CallBackObj;
import com.bawei.yk.base.net.RetrofitUntils;
import com.bawei.yk.entity.CarEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:陈浩
 *@Date: 2019/7/27
 *@Time:8:52
 *@Description:${DESCRIPTION}
 * */public class CarModelImpl implements CarContract.CarModel {
    @Override
    public void dogetCar(String sessionid, String userid, final CallBackObj callBackObj) {
        RetrofitUntils.getInstance().create(ApiService.class).selectCarData(userid,sessionid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CarEntity>() {
                    @Override
                    public void accept(CarEntity carEntity) throws Exception {
                callBackObj.success(carEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("123", "throwable:" + throwable);
                    }
                });

    }
}
