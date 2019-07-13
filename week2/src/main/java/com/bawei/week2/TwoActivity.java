package com.bawei.week2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bawei.my_base.base.BaseActivity;
import com.bawei.my_base.mvp.BasePresenter;
import com.bawei.week2.contract.TwoContract;
import com.bawei.week2.model.ModelImpl;
import com.bawei.week2.model.TwoMoldeimpl;
import com.bawei.week2.presenter.TwoPresenterImpl;

public class TwoActivity extends BaseActivity<TwoMoldeimpl, TwoPresenterImpl> implements TwoContract.ITwoView {
    @Override
    protected void iniData() {
        presenter.dogetTwo("15629839580853377","3377");
    }

    @Override
    protected int bindlayout() {
        return R.layout.activity_two;
    }

    @Override
    public BasePresenter initPresenter() {
        return new TwoPresenterImpl();
    }

    @Override
    public void showTwo(Object string) {
        Log.d("TwoActivity", "string:" + string);
    }
}
