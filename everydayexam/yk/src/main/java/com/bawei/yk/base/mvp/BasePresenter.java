package com.bawei.yk.base.mvp;

/*
 *@Auther:陈浩
 *@Date: 2019/7/26
 *@Time:20:23
 *@Description:${DESCRIPTION}
 * */public abstract class BasePresenter<M, V> {
    public M model;
    public V view;

    public void attache(V view) {
        this.view = view;
        this.model = getModel();
    }

    public void detache() {
        if (view != null) {
            view = null;
        }
        if (model != null) {
            model = null;
        }
    }


    public abstract M getModel();
}
