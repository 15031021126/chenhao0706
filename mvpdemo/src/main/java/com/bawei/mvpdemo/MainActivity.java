package com.bawei.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bawei.base_core.base.BaseMvpActivity;
import com.bawei.base_core.base.BasePresenter;

public class MainActivity  extends BaseMvpActivity<ModelImpl,Persenterimpl> {
    @Override
    protected void ianit() {
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter initPresenter() {
        return new Persenterimpl();
    }

    @Override
    public void failure(String msg) {
        Log.e("123", "failure: "+msg );
    }
}
