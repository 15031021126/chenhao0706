package com.bawei.mvpdemo;

/*
 *@Auther:陈浩
 *@Date: 2019/7/9
 *@Time:20:59
 *@Description:${DESCRIPTION}
 * */public interface Icontract {
    interface iview {
        void show(String str);
    }

    interface IModel {

        void dogetstr(String userid, String seeid, CallBackStr callBackStr);
    }

    interface IPersente {
        void att(iview iview);
        void request(String userid, String seeid);
    }
}
