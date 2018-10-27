package com.wisilica.wisesample.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MeshDev  {
    public void main(){
        System.out.println("MeshDev11111111");
        OperationData data=new OperationData();
        data.setDevice(this);
        System.out.println("111111getDevice"+ data.getDevice());

    }
}
