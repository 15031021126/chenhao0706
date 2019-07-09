package com.bawei.mvpdemo;

import android.util.Log;

import com.bawei.base_core.base.IBaseModel;
import com.bawei.mvpdemo.net.ApiService;
import com.bawei.mvpdemo.net.HttpUntils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/*
 *@Auther:陈浩
 *@Date: 2019/7/9
 *@Time:21:01
 *@Description:${DESCRIPTION}
 * */public class ModelImpl implements Icontract.IModel, IBaseModel {
    @Override
    public void dogetstr(String userid, String seeid, final CallBackStr callBackStr) {
        ApiService getcreate = HttpUntils.getInstance().getcreate(ApiService.class);

        //请求
        getcreate.select("15624026012001452", "1452")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())

        .subscribe(new Consumer<ResponseBody>() {
            @Override
            public void accept(ResponseBody responseBody) throws Exception {

                callBackStr.success(responseBody.string());
                Log.e("123", "accept: "+responseBody.string() );
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e("123", "accept: "+throwable.toString() );
            }
        });

    }
}
