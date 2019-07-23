package com.bawei.randomview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.bawei.randomview.R;
import com.blankj.utilcode.util.ScreenUtils;

/*
 *@Auther:陈浩
 *@Date: 2019/7/23
 *@Time:15:19
 *@Description:${DESCRIPTION}
 * */public class MyLineView extends View {

    private Paint paintline;
    private int screenHeight = ScreenUtils.getScreenHeight();
    private int screenWidth = ScreenUtils.getScreenWidth();
    private Bitmap bitmap;
    private Paint paint2;

    public MyLineView(Context context) {
        this(context, null);
    }

    public MyLineView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);

    }

    private void init() {
        paintline = new Paint();
        paint2 = new Paint();
        paint2.setTextSize(20);
        paint2.setTextAlign(Paint.Align.CENTER);
        paintline.setAntiAlias(true);
        paintline.setDither(true);
        paintline.setStrokeWidth(10);
        paintline.setColor(Color.YELLOW);
        paint2.setColor(Color.RED);
        paintline.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int num=3;
        canvas.drawLine(0, screenHeight / 2+50, screenWidth, screenHeight / 2+50, paintline);
        int i1 = screenWidth / 5;

        for (int i = 1; i < 5; i++) {
            canvas.drawBitmap(bitmap, i * i1-40, screenHeight / 2+70, paintline);
            canvas.drawLine(i * i1, screenHeight / 2, i * i1, screenHeight / 2 + 50, paintline);
            canvas.drawText("踩踩踩",i * i1, screenHeight / 2-20,  paint2);
        }
        for (int i = 0; i < num; i++) {
            canvas.drawLine(0, screenHeight / 2+50, i1*i, screenHeight / 2+50, paint2);
            canvas.drawCircle(i1*i,screenHeight / 2+50,5,paint2);
                    }

    }
}
