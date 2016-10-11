package com.example.administrator.pulltorefreshlistview.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 实现：
 * 1.上下滑动需要拦截
 * 2.向右滑动并且当前是第一个页面,需要拦截
 * 3.向左滑动并且当前是最后一个页面,需要拦截
 * 的自定义viewpager
 * Created by Administrator on 2016-10-11.
 */
public class TopViewPager extends ViewPager {

    private int startX;
    private int startY;

    public TopViewPager(Context context) {
        super(context);
    }

    public TopViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 在该方法实现具体的功能
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        这句话是告诉父view，我的事件自己处理
        getParent().requestDisallowInterceptTouchEvent(true);


        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = (int) ev.getX();
                startY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:

                int endX = (int) ev.getX();
                int endY = (int) ev.getY();

                int dx = endX - startX;
                int dy = endY - startY;

                if (Math.abs(dy) < Math.abs(dx)) {
                    int currentItem = getCurrentItem();
                    //左右滑
                    if (dx > 0) {
                        //右滑
                        if (currentItem == 0) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    } else {
                        //左滑
                        int count = getAdapter().getCount();
                        if (currentItem == count - 1) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                } else {
                    //上下滑，需要拦截
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
