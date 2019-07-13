package com.bawei.week2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

import com.bawei.my_base.base.BaseActivity;
import com.bawei.my_base.mvp.BasePresenter;
import com.bawei.week2.contract.Dcontract;
import com.bawei.week2.model.ModelImpl;
import com.bawei.week2.presenter.PresenterImpe;
import com.bumptech.glide.load.model.ModelLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<ModelImpl,PresenterImpe> implements Dcontract.Iview {


    @BindView(R.id.progressBar2)
    ProgressBar progressBar2;
    @BindView(R.id.bt1)
    Button bt1;
    @BindView(R.id.bt2)
    Button bt2;
    @BindView(R.id.bt3)
    Button bt3;
    @BindView(R.id.bt4)
    Button bt4;

    @Override
    protected void iniData() {
        setBar();
        sA(TwoActivity.class);

    }

    @Override
    protected int bindlayout() {
        return R.layout.activity_main;
    }

    @Override
    public void error() {

    }

    @Override
    public void progress(int progress) {

    }

    @Override
    public BasePresenter initPresenter() {
        return new PresenterImpe();
    }



}
