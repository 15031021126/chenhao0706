package com.bawei.week2.presenter;

import com.bawei.my_base.mvp.BasePresenter;
import com.bawei.my_base.net.CallBackStr;
import com.bawei.week2.contract.TwoContract;
import com.bawei.week2.model.TwoMoldeimpl;

/*
 *@Auther:陈浩
 *@Date: 2019/7/13
 *@Time:10:59
 *@Description:${DESCRIPTION}
 * */public class TwoPresenterImpl extends TwoContract.ITwoPresnter {
    @Override
    public void dogetTwo(String phone, String pwd) {
            getModel().dogetTwo(phone, pwd, new CallBackStr() {
                @Override
                public void success(Object obj) {
                    view.showTwo(obj);
                }
            });
    }

    @Override
    public TwoMoldeimpl getModel() {
        return new TwoMoldeimpl();
    }


}
