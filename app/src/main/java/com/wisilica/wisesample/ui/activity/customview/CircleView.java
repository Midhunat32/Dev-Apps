package com.wisilica.wisesample.ui.activity.customview;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;

import com.wisilica.wisesample.R;

/**
 * author midhun
 */

public class CircleView extends View {
    int  raduis = 200,defRadius,duration=600;
    static int imageWidth=60,imageHeight=60;;
    Paint paintCircle, paintImage,paintProgress,paintArc;
    Bitmap imageOriginal, resizedBitmap;
    int cx, cy, bx, by,px,py,arcStartingPoint=-90,arcSweepValue=0;
    private RectF mRect;

    Context mConetx;

    public CircleView(Context context) {
        super(context);
        init(context,null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        mConetx = context;

        paintImage = new Paint();
        paintCircle = new Paint();
        paintProgress =new Paint();
        paintCircle.setAntiAlias(true);
        paintCircle.setColor(Color.RED);
        paintProgress = new Paint();
        paintProgress.setColor(Color.BLUE);
        paintProgress.setAntiAlias(true);
        paintProgress.setStyle(Paint.Style.STROKE);
        paintProgress.setStrokeWidth(8);
        paintProgress.setStrokeJoin(Paint.Join.ROUND);
        paintProgress.setPathEffect(new CornerPathEffect(50) );
        paintArc =new Paint();
        paintArc.setColor(Color.parseColor("#00FFFFFF"));



        if (attrs!= null){
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
            int circleColor = ta.getColor(R.styleable.CircleView_circle_color,Color.RED);
            raduis =  ta.getInt(R.styleable.CircleView_circle_radius,50);
            duration = ta.getInt(R.styleable.CircleView_animation_duration,duration);
            imageWidth = ta.getInt(R.styleable.CircleView_image_width,imageWidth);
            imageHeight = ta.getInt(R.styleable.CircleView_image_width,imageHeight);

            defRadius =raduis;
            paintCircle.setColor(circleColor);
        }
        imageOriginal = BitmapFactory.decodeResource(getResources(), R.drawable.group_1);
        resizedBitmap = scaleBitMapImage(imageOriginal, raduis, true);

        animateCircle();
        animateArc();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        cx = getWidth() / 2;
        cy = getHeight() / 2;
        canvas.drawCircle(cx, cy, raduis, paintCircle);

        bx = cx - resizedBitmap.getWidth() / 2;
        by = cy - resizedBitmap.getHeight() / 2;
        px = cx + resizedBitmap.getWidth()/2;
        py = cy + resizedBitmap.getHeight()/2;
        canvas.drawBitmap(resizedBitmap, bx, by, paintImage);

        mRect = new RectF(bx-30, by-30, px+30, py+30);
        canvas.drawArc(mRect,arcStartingPoint,arcSweepValue,false,paintProgress);

        canvas.drawCircle(cx, cy, raduis, paintArc);

    }


    private void animateCircle() {
        int recalculatedRadius = (int) Math.round(defRadius*(0.75));
        ValueAnimator valueAnimator = ValueAnimator.ofInt(defRadius,recalculatedRadius);
        valueAnimator.setDuration(600);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(animation -> {
            raduis  = (int) animation.getAnimatedValue();
            invalidate();
        });
        valueAnimator.start();
    }

    private void animateArc(){
        ValueAnimator circleAnimator =ValueAnimator.ofInt(0,360);
        circleAnimator.setDuration(2000);
        circleAnimator.setInterpolator(new LinearInterpolator());
        circleAnimator.addUpdateListener(animation -> {
            arcSweepValue = (int) animation.getAnimatedValue();
            invalidate();
        });
        circleAnimator.start();

    }



    public static Bitmap scaleBitMapImage(Bitmap realImage, float maxImageSize, boolean filter) {
        //float ratio = Math.min(maxImageSize / realImage.getWidth(), (maxImageSize / realImage.getHeight()));
       // int width = Math.round((float) ratio * realImage.getWidth());
        //int height = Math.round((float) ratio * realImage.getHeight());
        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, imageWidth, imageHeight, filter);
        return newBitmap;
    }
}
