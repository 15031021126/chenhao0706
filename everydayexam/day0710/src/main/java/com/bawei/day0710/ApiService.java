package com.bawei.day0710;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.POST;

/*
 *@Auther:陈浩
 *@Date: 2019/7/10
 *@Time:9:03
 *@Description:${DESCRIPTION}
 * */public interface ApiService {

    @POST("download/png/1208666/768/")
    Observable<ResponseBody> get();
}
