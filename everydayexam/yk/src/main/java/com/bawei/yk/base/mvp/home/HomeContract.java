package com.bawei.yk.base.mvp.home;

import com.bawei.yk.base.mvp.BasePresenter;
import com.bawei.yk.base.mvp.IBaseModel;
import com.bawei.yk.base.mvp.IBaseView;
import com.bawei.yk.base.net.CallBackObj;

/*
 *@Auther:陈浩
 *@Date: 2019/7/27
 *@Time:11:20
 *@Description:${DESCRIPTION}
 * */public interface HomeContract {
    interface IhomeView extends IBaseView {
        void showShopBanner(Object obj);
        void showSearch(Object obj);
        void showHomeShOP(Object obj);
    }

    interface IhomeModel extends IBaseModel {
        void dogetBanner(CallBackObj callBackObj);
        void getSearch( String keyword, String page,String count,CallBackObj callBackStr);
        void dogetShop(CallBackObj callBackObj);
    }

    abstract class IhomePresenter extends BasePresenter<IhomeModel, IhomeView> {
        public abstract void requestBanner();
        public abstract void requestSearch(String url,String page,String count);

        public abstract void requestShop();

        @Override
        public IhomeModel getModel() {
            return new HomeModelImpl();

        }
    }
}
