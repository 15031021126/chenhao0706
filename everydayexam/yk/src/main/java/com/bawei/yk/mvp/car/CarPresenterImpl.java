package com.bawei.yk.mvp.car;

import com.bawei.yk.base.net.CallBackObj;

/*
 *@Auther:陈浩
 *@Date: 2019/7/27
 *@Time:8:56
 *@Description:${DESCRIPTION}
 * */public class CarPresenterImpl extends CarContract.CarPresenter {
    @Override
    public void requestCar(String sessionid, String userid) {
        model.dogetCar(sessionid, userid, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.shwoCar(obj);
            }
        });
    }
}
