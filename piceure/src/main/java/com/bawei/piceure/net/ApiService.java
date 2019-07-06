package com.bawei.piceure.net;


import com.bawei.piceure.Bean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;

/*
 *@Auther:陈浩
 *@Date: 2019/7/2
 *@Time:14:20
 *@Description:${接口请求}
 * */public interface ApiService {
    /**
     * 查询商品列表
     *
     * @param categoryId
     * @param page
     * @param count
     * @return
     */
    @GET(Api.ONE)
    Observable<ResponseBody> one(@Query("categoryId") String categoryId, @Query("page") String page, @Query("count") String count);

    /**
     * 添加购物车
     *
     * @param sessionId
     * @param userId
     * @param data
     * @return
     */
    @PUT(Api.TWO)
    Observable<ResponseBody> two(@Header("sessionId") String sessionId, @Header("userId") String userId, @Query("data") String data);

    /**
     * 查询购物车
     *
     * @param sessionId
     * @param userId
     * @return
     */
    @GET(Api.THREE)
    Observable<ResponseBody> select(@Header("sessionId") String sessionId, @Header("userId") String userId);
    /**
     * 单图
     *
     * @param file
     * @return
     */
    @POST(Api.PIC)
    @Multipart
    Observable<Bean> onepic(@Header("sessionId") String sessionId, @Header("userId") String userId, @Part() MultipartBody.Part file);

}
