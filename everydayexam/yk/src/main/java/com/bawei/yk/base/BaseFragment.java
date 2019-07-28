package com.bawei.yk.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.yk.base.mvp.BasePresenter;
import com.bawei.yk.base.mvp.IBaseModel;
import com.bawei.yk.base.mvp.IBaseView;

import butterknife.ButterKnife;

/*
 *@Auther:陈浩
 *@Date: 2019/7/26
 *@Time:20:22
 *@Description:${DESCRIPTION}
 * */public abstract class BaseFragment<M extends IBaseModel, P extends BasePresenter> extends Fragment implements IBaseView {
    public M model;
    public P presenter;
    private Boolean iscreat = false;
    private Boolean isuserhit = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(bindLayout(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iscreat = true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isuserhit = true;
            if (isuserhit && iscreat) {
                layini();
            }
        } else {
            isuserhit = false;
        }
    }

    protected void layini() {
        if (isuserhit && iscreat) {
            Log.e("123", "setUserVisibleHint: " + this);
            presenter = (P) iniPresenter();
            if (presenter != null) {
                model = (M) presenter.getModel();
                if (model != null) {
                    presenter.attache(this);
                    iniData();
                }
            }//初始化

            isuserhit = false;
            iscreat = false;
        }
    }

    protected abstract void iniData();

    protected abstract int bindLayout();

    /**
     * 销毁
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detache();
        }
    }
}
