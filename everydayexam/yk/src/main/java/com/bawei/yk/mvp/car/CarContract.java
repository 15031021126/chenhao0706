package com.bawei.yk.mvp.car;

import com.bawei.yk.base.mvp.BasePresenter;
import com.bawei.yk.base.mvp.IBaseModel;
import com.bawei.yk.base.mvp.IBaseView;
import com.bawei.yk.base.net.CallBackObj;

/*
 *@Auther:陈浩
 *@Date: 2019/7/26
 *@Time:21:22
 *@Description:${DESCRIPTION}
 * */public interface CarContract {
    interface CarView extends IBaseView {
        void shwoCar(Object object);
    }

    interface CarModel extends IBaseModel {
        void dogetCar(String sessionid, String userid, CallBackObj callBackObj);
    }

    abstract class CarPresenter extends BasePresenter<CarModel, CarView> {
        public abstract void requestCar(String sessionid, String userid);

        @Override
        public CarModel getModel() {
            return new CarModelImpl();
        }
    }
}
