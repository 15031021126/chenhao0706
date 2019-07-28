package com.bawei.yk.api;

/*
 *@Auther:陈浩
 *@Date: 2019/7/7
 *@Time:20:10
 *@Description:${DESCRIPTION}
 * */public class Api {
   // public static final String BASEURL = "http://172.17.8.100/";
       public static final String BASEURL = "http://mobile.bwstudent.com/";
    public static final String sessionid = "15641944610711452";
    public static final String userid = "1452";

    public static final String REGURL = "small/user/v1/register";//注册
    public static final String LOGINURL = "small/user/v1/login";//登录
    public static final String ONE = "small/commodity/v1/findFirstCategory";
    public static final String TWO = "small/commodity/v1/findSecondCategory";
    public static final String THREE = "small/commodity/v1/findCommodityByCategory";
    public static final String SYSCAR = "small/order/verify/v1/syncShoppingCart";//同步购物车
    public static final String SelectShoppingCart = "small/order/verify/v1/findShoppingCart";//查询购物车
    public static final String DELECTDD = "small/order/verify/v1/deleteOrder";//删除订单
    public static final String USERDetails = "small/user/verify/v1/getUserById";//详情
    public static final String SYSYHEAD = "small/user/verify/v1/modifyHeadPic";//上传头像
    public static final String CHANGERNIKENAME = "small/user/verify/v1/modifyUserNick";//修改昵称
    public static final String MYFOOT = "small/commodity/verify/v1/browseList";//我的足记
    public static final String SELECTAddress = "small/user/verify/v1/receiveAddressList";//我的地址
    public static final String INSERTADRESS = "small/user/verify/v1/addReceiveAddress";//添加地址
    public static final String DEFAULTADDRESS = "small/user/verify/v1/setDefaultReceiveAddress";//默认地址
    public static final String Changeaddress = "small/user/verify/v1/changeReceiveAddress";//修改地址
    public static final String USERWALLT = "small/user/verify/v1/findUserWallet";//我的钱包
    public static final String HOMEBANNER = "small/commodity/v1/bannerShow";//xbanner首页
    public static final String HomeShop = "small/commodity/v1/commodityList";//首页信息
    public static final String SEARCHome = "small/commodity/v1/findCommodityByKeyword";//首页搜索
    public static final String Commoditydetails = "small/commodity/v1/findCommodityDetailsById";//商品详情
    public static final String GET_QUAN = "small/circle/v1/findCircleList";//圈子列表
    public static final String INSERT_QUAN = "small/circle/verify/v1/releaseCircle";//发布圈子
    public static final String DELECT_QUAN = "small/circle/verify/v1/deleteCircle";//删除我发表过的圈子
    public static final String MY_QUAN = "small/circle/verify/v1/findMyCircleById";//wo 的圈子
    public static final String DIAN_ZAN = "small/circle/verify/v1/addCircleGreat";//wo 的圈子点赞
    public static final String CANCLE_ZAN = "small/circle/verify/v1/cancelCircleGreat";//wo 取消点赞
    public static final String createOrder = "small/order/verify/v1/createOrder";//wo 创建订单
    public static final String SELECT_Order = "small/order/verify/v1/findOrderListByStatus";//wo 查询订单状态
    public static final String Order_PAY = "small/order/verify/v1/pay";//wo 支付
    public static final String Order_Cancle = "small/order/verify/v1/deleteOrder";//wo 删除订单
    public static final String Order_Receipt = "small/order/verify/v1/confirmReceipt";//wo 收货
    public static final String Order_Select_Wallet = "small/order/verify/v1/findOrderInfo";//wo 查询订单明细数据（钱包）
    public static final String comment = "small/commodity/verify/v1/addCommodityComment";//wo 查询订单明细数据（钱包）
}
