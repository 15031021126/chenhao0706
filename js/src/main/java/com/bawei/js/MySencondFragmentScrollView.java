package com.bawei.js;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

/*
 *@Auther:陈浩
 *@Date: 2019/7/17
 *@Time:19:27
 *@Description:${DESCRIPTION}
 * */public class MySencondFragmentScrollView extends ScrollView {
    public MySencondFragmentScrollView(Context context) {
        super(context);
    }

    public MySencondFragmentScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    boolean intercepet = false;//是否拦截的变量
    private ListView mListView;
    private float mLastY;//记录y轴坐标

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        getChildListView();
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                super.onInterceptTouchEvent(ev);
                intercepet = false;
                break;
            case MotionEvent.ACTION_MOVE:
                //满足listView滑动到顶部，如果继续下滑，那就让scrollView拦截事件
                float y = ev.getY()-mLastY;
                System.out.println("lastymove:"+y);
                System.out.println("lastyevy:"+ev.getY());
                if (mListView.getFirstVisiblePosition() ==0 && y>0) {//>0继续往下滑动
                    intercepet = true;
                }
                //满足listView滑动到底部，如果继续上滑，那就让scrollView拦截事件，《0时候继续往上滑
                else if (mListView.getLastVisiblePosition() ==mListView.getCount()-1 && (ev.getY()-mLastY)<0) {
                    intercepet = true;
                } else {
                    intercepet = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                intercepet = false;
                break;
        }


        mLastY =ev.getY();
        System.out.println("lasty："+mLastY);
        return intercepet;//动态返回，根据业务逻辑
    }

    /**
     * 得到scrlloview的子view，listview
     */
    public void getChildListView() {
//        View childAt = getChildAt(0);
//        if (childAt instanceof ListView) {
//            mListView = (ListView) childAt;
//        } else {
//            if (childAt instanceof ViewGroup) {
//                ViewGroup viewGroup = (ViewGroup) childAt;
//                for (int i = 0; i < viewGroup.getChildCount() - 1; i++) {
//                    View childAt1 = viewGroup.getChildAt(i);
//                    if(childAt1 instanceof  ListView){
//                        mListView = (ListView)childAt1;
//                    }
//                }
//            }
//        }

        View layout = getChildAt(0);

        LinearLayout linearLayout = (LinearLayout) layout;

        mListView = (ListView) linearLayout.getChildAt(1);

    }
}
