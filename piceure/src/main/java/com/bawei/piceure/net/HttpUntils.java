package com.bawei.piceure.net;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@Auther:陈浩
 *@Date: 2019/7/2
 *@Time:14:18
 *@Description:${网络请求类}
 * */public class HttpUntils {

    private static HttpUntils untils;
    private final Retrofit retrofit;

    private HttpUntils() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        retrofit = new Retrofit.Builder().baseUrl("http://172.17.8.100/").client(client).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    /**
     * 双重检验所
     *
     * @return
     */
    public static HttpUntils getInstance() {
        if (untils == null) {
            synchronized (HttpUntils.class) {
                if (untils == null) {
                    untils = new HttpUntils();
                }
            }
        }
        return untils;
    }

    /**
     * 动态获取
     *
     * @param service
     * @param <T>
     * @return
     */
    public <T> T getcreate(final Class<T> service) {
        return retrofit.create(service);
    }
}
