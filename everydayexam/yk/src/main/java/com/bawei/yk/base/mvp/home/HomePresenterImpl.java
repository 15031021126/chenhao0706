package com.bawei.yk.base.mvp.home;

import com.bawei.yk.base.net.CallBackObj;

/*
 *@Auther:陈浩
 *@Date: 2019/7/16
 *@Time:19:36
 *@Description:${DESCRIPTION}
 * */public class HomePresenterImpl extends HomeContract.IhomePresenter {
    @Override
    public void requestBanner() {
        model.dogetBanner(new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.showShopBanner(obj);
            }
        });
    }

    @Override
    public void requestSearch(String url, String page, String count) {
        model.getSearch(url, page, count, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.showSearch(obj);
            }
        });
    }


    @Override
    public void requestShop() {
        model.dogetShop(new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.showHomeShOP(obj);
            }
        });

    }
}
