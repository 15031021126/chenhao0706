package com.bawei.randomview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.blankj.utilcode.util.ScreenUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *@Auther:陈浩
 *@Date: 2019/7/23
 *@Time:10:57
 *@Description:${DESCRIPTION}
 * */public class MyRandomView extends View {

    private Paint pointpaint;
    private Paint circlepaint;
    private int whith = ScreenUtils.getScreenWidth();//屏幕款高
    private int height = ScreenUtils.getScreenHeight();

    List<Point> list = new ArrayList<>();

    public MyRandomView(Context context) {
        this(context, null);
    }

    public MyRandomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyRandomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        iniview(context, attrs);
    }

    private void iniview(Context content, AttributeSet attrs) {
        //文字的画笔
        pointpaint = new Paint();
        pointpaint.setColor(Color.RED);//设置颜色
        pointpaint.setAntiAlias(true);//设置抗锯齿
        pointpaint.setStrokeWidth(5);//设置宽度
        //pointpaint.setStyle(Paint.Style.FILL);//填充
        pointpaint.setTextSize(20);
        pointpaint.setTextAlign(Paint.Align.CENTER);
        //点的画笔
        circlepaint = new Paint();
        circlepaint.setColor(Color.BLUE);
        circlepaint.setAntiAlias(true);
        circlepaint.setStyle(Paint.Style.FILL);
    }

    //布局
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
    //当前XY
    private int x;
    private int y;
    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("点击添加", 100, height - 200, pointpaint);
        canvas.drawText("点击清空", whith - 100, height - 200, pointpaint);
        canvas.drawText("[" + x + "," + y + "]", whith / 2, 50, pointpaint);
        //画点
        Drawpoint(canvas);
    }

    private void Drawpoint(Canvas canvas) {
        //随机数
        int cx = new Random().nextInt(whith);
        int cy = new Random().nextInt(height);
        Point point = new Point();
        point.x = cx;
        point.y = cy;
        list.add(point);
        //添加点击事件

        for (int i = 0; i < list.size(); i++) {
            if (point.x>x&&point.x<x&&point.y>y&&point.y<y) {
                canvas.drawCircle(list.get(i).x, list.get(i).y, 10, circlepaint);
            }else{
                canvas.drawCircle(list.get(i).x, list.get(i).y, 10, circlepaint);
            }
        }
        Log.e("123", "onDraw: " + cx);

        //清空点击事件
        if ((x > 400 && x < 480) && y > 741 && y < 762) {
            Toast.makeText(getContext(), "清空", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                x = (int) event.getX();
                y = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        invalidate();
        return true;
    }
}
