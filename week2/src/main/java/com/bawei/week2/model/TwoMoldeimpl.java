package com.bawei.week2.model;

import android.util.Log;

import com.bawei.my_base.api.ApiService;
import com.bawei.my_base.mvp.IBaseModel;
import com.bawei.my_base.net.CallBackStr;
import com.bawei.my_base.net.HttpUntils;
import com.bawei.week2.contract.TwoContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/*
 *@Auther:陈浩
 *@Date: 2019/7/13
 *@Time:10:56
 *@Description:${DESCRIPTION}
 * */public class TwoMoldeimpl implements TwoContract.ITwoModel {
    @Override
    public void dogetTwo(String phone, String pwd, final CallBackStr callBackStr) {
        HttpUntils.getInstance().getcreate(ApiService.class).select("15629839580853377", "3377")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        callBackStr.success(responseBody.string());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("TwoMoldeimpl", "throwable:" + throwable);
                    }
                })
        ;
    }
}
