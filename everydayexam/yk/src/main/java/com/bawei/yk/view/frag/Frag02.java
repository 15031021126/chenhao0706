package com.bawei.yk.view.frag;

import android.util.Log;

import com.bawei.yk.R;
import com.bawei.yk.base.BaseFragment;
import com.bawei.yk.base.mvp.BasePresenter;

/*
 *@Auther:陈浩
 *@Date: 2019/7/26
 *@Time:20:43
 *@Description:${DESCRIPTION}
 * */public class Frag02 extends BaseFragment {
    @Override
    protected void iniData() {
        Log.e("123", "iniData: ;"+this );
    }

    @Override
    protected int bindLayout() {
        return R.layout.frag02;
    }

    @Override
    public BasePresenter iniPresenter() {
        return null;
    }
}
