package com.bawei.week2.contract;

import android.telecom.Call;

import com.bawei.my_base.mvp.BasePresenter;
import com.bawei.my_base.mvp.IBasView;
import com.bawei.my_base.mvp.IBaseModel;
import com.bawei.my_base.net.CallBackStr;
import com.bawei.week2.model.TwoMoldeimpl;

/*
 *@Auther:陈浩
 *@Date: 2019/7/13
 *@Time:10:52
 *@Description:${DESCRIPTION}
 * */public interface TwoContract {

    interface ITwoView extends IBasView {
        void showTwo(Object string);
    }

    interface ITwoModel extends IBaseModel {
        void dogetTwo(String phone, String pwd, CallBackStr callBackStr);
    }

    abstract  class ITwoPresnter extends  BasePresenter<TwoMoldeimpl,ITwoView> {

        public abstract void dogetTwo(String phone, String pwd);
    }
}
