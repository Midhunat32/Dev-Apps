package com.wisilica.wisesample.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity  extends AppCompatActivity implements View.OnClickListener {
    public abstract void initUI();
    public abstract void registerListeners();
    public abstract void initObjects();

}
