package com.bawei.mvpdemo;

import com.bawei.base_core.base.BasePresenter;

/*
 *@Auther:陈浩
 *@Date: 2019/7/9
 *@Time:21:07
 *@Description:${DESCRIPTION}
 * */public class Persenterimpl extends BasePresenter implements Icontract.IPersente {
     private Icontract.iview iview;
     private ModelImpl model;

    @Override
    public void att(Icontract.iview iview) {
        this.iview=iview;
        model=new ModelImpl();
    }

    @Override
    public void request(String userid, String seeid) {
        model.dogetstr(userid, seeid, new CallBackStr() {
            @Override
            public void success(String s) {
                iview.show(s);
            }
        });
    }

    @Override
    public Object getModel() {
        return model;
    }
}
