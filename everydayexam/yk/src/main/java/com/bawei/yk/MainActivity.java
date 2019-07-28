package com.bawei.yk;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bawei.yk.base.BaseActivity;
import com.bawei.yk.base.mvp.BasePresenter;
import com.bawei.yk.view.frag.Frag01;
import com.bawei.yk.view.frag.Frag02;
import com.bawei.yk.view.frag.Frag03;
import com.bawei.yk.view.frag.Frag04;
import com.bawei.yk.view.frag.Frag05;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @butterknife.BindView(R.id.pager)
    ViewPager pager;
    @butterknife.BindView(R.id.bt1)
    RadioButton bt1;
    @butterknife.BindView(R.id.bt2)
    RadioButton bt2;
    @butterknife.BindView(R.id.bt3)
    RadioButton bt3;
    @butterknife.BindView(R.id.bt4)
    RadioButton bt4;
    @butterknife.BindView(R.id.bt5)
    RadioButton bt5;
    @butterknife.BindView(R.id.rg)
    RadioGroup rg;
    private ArrayList<Fragment> fragments;


    @Override
    protected void iniData() {
        //设置沉浸式状态栏
        setBar(Color.TRANSPARENT);
        fragments = new ArrayList<>();
        fragments.add(new Frag01());
        fragments.add(new Frag02());
        fragments.add(new Frag03());
        fragments.add(new Frag04());
        fragments.add(new Frag05());
        //点击切换
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        pager.setOffscreenPageLimit(fragments.size() - 1);
        //设置适配器
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                rg.check(rg.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter iniPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                pager.setCurrentItem(0);
                break;
            case R.id.bt2:
                pager.setCurrentItem(1);
                break;
            case R.id.bt3:
                pager.setCurrentItem(2);
                break;
            case R.id.bt4:
                pager.setCurrentItem(3);
                break;
            case R.id.bt5:
                pager.setCurrentItem(4);
                break;
        }
    }

    //点击返回按钮，实现点击两次退出的效果
    //上一次点击的时间
    long last = -1;
    @Override
    public void onBackPressed() {
        //将父类方法点击一次就销毁界面的方法注释掉
        //super.onBackPressed();
        //获取当前点击的时间
        long now = System.currentTimeMillis();
        //第一次点击返回键则last=-1
        if (last == -1) {
            Toast.makeText(MainActivity.this, "请再点击一次退出界面", Toast.LENGTH_SHORT).show();
            //第一次的点击事件则就变成了上一次的点击时间
            last = now;
            //如果不是第一次点击
        } else {
            //判断两次点击的时间间隔
            //时间间隔正确
            if ((now - last) < 2000) {
                Toast.makeText(MainActivity.this, "已退出", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                //如果时间间隔太长则第二次点击当做第一次处理
                last = now;
                Toast.makeText(MainActivity.this, "请再点击一次退出界面", Toast.LENGTH_SHORT).show();
            }

        }
    }


}
