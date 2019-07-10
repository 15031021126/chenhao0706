package com.bawei.day0710;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUntils {

    private static volatile HttpUntils singleton;
    private final Retrofit retrofit;

    private HttpUntils() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        retrofit = new Retrofit.Builder().baseUrl("https://www.easyicon.net/").client(client).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    }

    public static HttpUntils getInstance() {
        if (singleton == null) {
            synchronized (HttpUntils.class) {
                if (singleton == null) {
                    singleton = new HttpUntils();
                }
            }
        }
        return singleton;
    }

    public <T> T getcreate(final Class<T> service) {
        return retrofit.create(service);
    }
}