package com.bawei.yk.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.bawei.yk.base.mvp.BasePresenter;
import com.bawei.yk.base.mvp.IBaseModel;
import com.bawei.yk.base.mvp.IBaseView;
import com.blankj.utilcode.util.BarUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:陈浩
 *@Date: 2019/7/26
 *@Time:20:22
 *@Description:${DESCRIPTION}
 * */public abstract class BaseActivity<M extends IBaseModel, P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    public M model;
    public P presenter;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        unbinder = ButterKnife.bind(this);
        presenter = (P) iniPresenter();
        if (presenter != null) {
            model = (M) presenter.getModel();
            if (model != null) {
                presenter.attache(this);
            }
        }//初始化
        iniData();
    }

    /**
     * s状态栏颜色
     * @param bar
     */
    public void setBar(int bar) {
        BarUtils.setStatusBarColor(this, bar);
    }

    protected abstract void iniData();

    protected abstract int bindLayout();

    /**
     * 销毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detache();
        }
        unbinder.unbind();
    }
}
