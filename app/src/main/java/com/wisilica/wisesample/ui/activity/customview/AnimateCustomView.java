package com.wisilica.wisesample.ui.activity.customview;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.wisilica.wisesample.R;

public class AnimateCustomView extends AppCompatActivity {

    CircleView custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animate_custom_view);

        custom = findViewById(R.id.custom);



//        ObjectAnimator animation = ObjectAnimator.ofFloat(custom, "translationX", 800f);
//        animation.setDuration(2000);
//        animation.start();


    }
}
