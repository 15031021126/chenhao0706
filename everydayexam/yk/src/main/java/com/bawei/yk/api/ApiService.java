package com.bawei.yk.api;



import com.bawei.yk.entity.CarEntity;
import com.bawei.yk.entity.HomeBanner;
import com.bawei.yk.entity.HomeEntity;
import com.bawei.yk.entity.HomeSearch;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Url;

/*
 *@Auther:陈浩
 *@Date: 2019/7/7
 *@Time:20:12
 *@Description:${动态}
 * */public interface ApiService {

    //注册
    @POST(Api.REGURL)
    @FormUrlEncoded
    Observable<ResponseBody> useReg(@Field("phone") String phone, @Field("pwd") String pwd);

    /**
     * 登录
     *
     * @param phone
     * @param pwd
     * @return
     */
    @POST
    @FormUrlEncoded
    Observable<ResponseBody> login(@Url String url, @Field("phone") String phone, @Field("pwd") String pwd);

    /**
     * 查询商品
     *
     * @param url
     * @param sessionId
     * @param userId
     * @return
     */
    @GET
    Observable<ResponseBody> getShop(@Url String url, @Header("sessionId") String sessionId, @Header("userId") String userId);

    /**
     * 单图
     *
     * @param file
     * @return
     */
    @POST(Api.SYSYHEAD)
    @Multipart
    Observable<ResponseBody> onepic(@Header("sessionId") String sessionId, @Header("userId") String userId, @Part MultipartBody.Part file);

    /**
     * 修改昵称
     *
     * @param sessionId
     * @param userId
     * @param nikename
     * @return
     */
    @PUT(Api.CHANGERNIKENAME)
    @FormUrlEncoded
    Observable<ResponseBody> changeNikeName(@Header("sessionId") String sessionId, @Header("userId") String userId, @Field("nickName") String nikename);

    /**
     * 多图上传
     *
     * @return
     */
//    @POST()
//    @Multipart
//    Observable<这> uploadPics(, @Part List<MultipartBody.Part> file);
//    @POST
//    @Multipart
//    Observable<ResponseBody> somePic(@Url String url, @Header("sessionId") String sessionId, @Header("userId") String userId,
//                                     List<MultipartBody.Part> fils);

//    /**
//     * 订单查询
//     *
//     * @param
//     * @param sessionId
//     * @param userId
//     * @param status
//     * @param page
//     * @param count
//     * @return
//     */
//    @GET(Api.SELECT_Order)
//    Observable<OrderEntity> getOrderData(@Header("sessionId") String sessionId, @Header("userId") String userId,
//                                         @Query("status") String status, @Query("page") String page, @Query("count") String count);

    /**
     * 删除订单
     *
     * @param
     * @return
     */
    @DELETE(Api.DELECTDD)
    Observable<ResponseBody> deleteOrder(@Header("sessionId") String sessionId, @Header("userId") String userId,
                                         @Query("orderId") String orderId);

//    /**
//     * 获取用户资料
//     *
//     * @param sessionId
//     * @param userId
//     * @return
//     */
//    @GET(Api.USERDetails)
//    Observable<UserDetails> getUSERDetails(@Header("sessionId") String sessionId, @Header("userId") String userId);
//
//    /**
//     * 获取我的足记
//     *
//     * @param sessionId
//     * @param userId
//     * @return
//     */
//    @GET(Api.MYFOOT)
//    Observable<MyFootEntity> getMyFoot(@Header("sessionId") String sessionId, @Header("userId") String userId,
//                                       @Query("page") String page, @Query("count") String count);
//
//    /**
//     * 查询我的收获地址
//     *
//     * @param sessionId
//     * @param userId
//     * @return
//     */
//    @GET(Api.SELECTAddress)
//    Observable<MyAddress> getMyAddress(@Header("sessionId") String sessionId, @Header("userId") String userId);

    /**
     * 添加地址
     *
     * @param sessionId
     * @param userId
     * @param realName
     * @param phone
     * @param address
     * @param zipCode
     * @return
     */
    @POST
    Observable<ResponseBody> insertAddress(@Url String url, @Header("sessionId") String sessionId, @Header("userId") String userId
            , @Query("id") String id

            , @Query("realName") String realName,
                                           @Query("phone") String phone, @Query("address") String address, @Query("zipCode") String zipCode
    );

    /**
     * 默认地址
     *
     * @param sessionId
     * @param userId
     * @param id
     * @return
     */
    @POST(Api.DEFAULTADDRESS)
    Observable<ResponseBody> defaultAddress(@Header("sessionId") String sessionId, @Header("userId") String userId
            , @Query("id") String id);

    /**
     * 修改地址
     *
     * @param sessionId
     * @param userId
     * @param id
     * @param realName
     * @param phone
     * @param address
     * @param zipCode
     * @return
     */
    @PUT
    Observable<ResponseBody> changeAddress(@Url String url, @Header("sessionId") String sessionId, @Header("userId") String userId
            , @Query("id") String id
            , @Query("realName") String realName,
                                           @Query("phone") String phone, @Query("address") String address, @Query("zipCode") String zipCode
    );
//
//    @GET(Api.USERWALLT)
//    Observable<WalltEntity> getWallet(@Header("sessionId") String sessionId, @Header("userId") String userId,
//                                      @Query("page") String page, @Query("count") String count);
//
    /**
     * 首页数据
     *
     * @return
     */
    @GET(Api.HomeShop)
    Observable<HomeEntity> getHome();

    /**
     * 首页轮播
     *
     * @return
     */
    @GET(Api.HOMEBANNER)
    Observable<HomeBanner> getHomeXbanner();

    /**
     * 首页轮播
     *
     * @return
     */
    @GET(Api.SEARCHome)
    Observable<HomeSearch> HomeSearch(@Query("keyword") String keyword, @Query("page") String page, @Query("count") String count);

//
//    /**
//     * 详情
//     *
//     * @param userId
//     * @param sessionId
//     * @return
//     */
//    @GET(Api.Commoditydetails)
//    Observable<DetalisEntity> getCommodityDetalles(@Header("userId") String userId,
//                                                   @Header("sessionId") String sessionId, @Query("commodityId") int commodityId);
//
    /**
     * 查询购物车
     *
     * @param userId
     * @param sessionId
     * @return
     */
    @GET(Api.SelectShoppingCart)
    Observable<CarEntity> selectCarData(@Header("userId") String userId,
                                        @Header("sessionId") String sessionId);
//
//    /**
//     * 圈子列表
//     *
//     * @param userId
//     * @param sessionId
//     * @return
//     */
//    @GET
//    Observable<SelectQuanEntity> getQuan(@Url String url, @Header("userId") String userId,
//                                         @Header("sessionId") String sessionId, @Query("page") String page, @Query("count") String count);

    /**评论
     *
     *
     * @param userId
     * @param sessionId
     * @param commodityId
     * @param content
     * @param
     * @return
     */
    @POST(Api.INSERT_QUAN)
    @Multipart
   // @FormUrlEncoded
    Observable<ResponseBody> insertQuan(@Header("userId") String userId,
                                        @Header("sessionId") String sessionId,
                                        @Query("commodityId") String commodityId,
                                        @Query("content") String content,
                                        @PartMap Map<String, RequestBody> maps);/*List<MultipartBody.Part> fils,*/


    /**
     *  发布圈子
     * @param userId
     * @param sessionId
     * @param commodityId
     * @param content
     * @param maps
     * @return
     */
    @POST(Api.comment)
    @Multipart
    Observable<ResponseBody> comment(@Header("userId") String userId,
                                     @Header("sessionId") String sessionId,
                                     @Query("commodityId") String commodityId,
                                     @Query("orderId") String orderId,
                                     @Query("content") String content,
                                     @PartMap Map<String, RequestBody> maps);/*List<MultipartBody.Part> fils,*/


    /**
     * 删除圈子
     *
     * @param sessionId
     * @param userId
     * @param circleId
     * @return
     */
    @DELETE(Api.DELECT_QUAN)
    Observable<ResponseBody> deleteQuan(@Header("sessionId") String sessionId, @Header("userId") String userId,
                                        @Query("circleId") String circleId);

    /**
     * 赞赞赞
     *
     * @param userId
     * @param sessionId
     * @param circleId
     * @return
     */
    @POST(Api.DIAN_ZAN)
    @FormUrlEncoded
    Observable<ResponseBody> zanQuan(@Header("userId") String userId,
                                     @Header("sessionId") String sessionId, @Field("circleId") String circleId);

    /**
     * 取消赞
     *
     * @param userId
     * @param sessionId
     * @param circleId
     * @return
     */
    @DELETE(Api.CANCLE_ZAN)
    Observable<ResponseBody> CancleQuan(@Header("userId") String userId,
                                        @Header("sessionId") String sessionId, @Query("circleId") String circleId);

    /**
     * 创建订单
     *
     * @param userId
     * @param sessionId
     * @param orderInfo
     * @param totalPrice
     * @param addressId
     * @return
     */
    @POST(Api.createOrder)
    @FormUrlEncoded
    Observable<ResponseBody> creatOrder(@Header("userId") String userId,
                                        @Header("sessionId") String sessionId,
                                        @Field("orderInfo") String orderInfo, @Field("totalPrice") String totalPrice,
                                        @Field("addressId") int addressId);

    /**
     * 支付
     *
     * @param userId
     * @param sessionId
     * @param orderId
     * @param payType
     * @return
     */
    @POST(Api.Order_PAY)
    @FormUrlEncoded
    Observable<ResponseBody> orderPay(@Header("userId") String userId,
                                      @Header("sessionId") String sessionId, @Field("orderId") String orderId, @Field("payType") String payType);

    /**
     * 取消订单
     *
     * @param userId
     * @param sessionId
     * @param orderId
     * @return
     */
    @DELETE(Api.Order_Cancle)
    Observable<ResponseBody> orderCancle(@Header("userId") String userId,
                                         @Header("sessionId") String sessionId, @Query("orderId") String orderId);

    //.查询订单明细数据
    @GET(Api.Order_Select_Wallet)
    Observable<ResponseBody> selectWalletdetails(@Header("userId") String userId, @Query("orderId") String orderId);

    /**
     * 收货
     * @param userId
     * @param sessionId
     * @param orderId
     * @return
     */
    @PUT(Api.Order_Receipt)
    Observable<ResponseBody> Receipt(@Header("userId") String userId,
                                     @Header("sessionId") String sessionId, @Query("orderId") String orderId);

}

