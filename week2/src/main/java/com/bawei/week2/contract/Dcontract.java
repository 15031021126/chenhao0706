package com.bawei.week2.contract;

import android.content.Context;

import com.bawei.my_base.mvp.BasePresenter;
import com.bawei.my_base.mvp.IBasView;
import com.bawei.my_base.mvp.IBaseModel;
import com.bawei.my_base.net.CallBackStr;
import com.bawei.week2.model.ModelImpl;

/*
 *@Auther:陈浩
 *@Date: 2019/7/13
 *@Time:10:16
 *@Description:${DESCRIPTION}
 * */public interface Dcontract {
    interface Iview extends IBasView {

        void finish();//完成
        void error();//下载失败

        BasePresenter initPresenter();

        void progress(int progress);//下载进度
    }

    interface IModel extends IBaseModel {
        void download(Context mContext, String loadurl, String filepath, CallBackStr callBackStr);

        void pause();//暂停

        void cancel();//取消

        void start();//继续
    }

    abstract static class Ipresenter extends BasePresenter<IModel, Iview> {
        @Override
        public IModel getModel() {
            return new ModelImpl();
        }

        protected abstract void download(Context mContext, String loadurl, String filepath);

        protected abstract void pause();//暂停

        protected abstract void cancel();//取消

        protected abstract void start();//继续
    }

}
