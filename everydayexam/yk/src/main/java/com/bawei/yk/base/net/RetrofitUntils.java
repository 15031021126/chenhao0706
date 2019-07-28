package com.bawei.yk.base.net;

import com.bawei.yk.api.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@Auther:陈浩
 *@Date: 2019/7/27
 *@Time:8:38
 *@Description:${DESCRIPTION}
 * */public class RetrofitUntils {

    private static RetrofitUntils untils;
    private final Retrofit retrofit;

    private RetrofitUntils() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                .readTimeout(10, TimeUnit.SECONDS)
//                .writeTimeout(10, TimeUnit.SECONDS)
//                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder().baseUrl(Api.BASEURL).client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 单利
     *
     * @return
     */
    public static RetrofitUntils getInstance() {
        if (untils == null) {
            synchronized (RetrofitUntils.class) {
                if (untils == null) {
                    untils = new RetrofitUntils();
                }
            }
        }
        return untils;
    }

    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
}
