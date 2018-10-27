package com.wisilica.wisesample.ui.activity;

import android.util.Log;

public class MesdDev2 extends MeshDev {
    public void main(){
        System.out.println("MeshDev222222");
        OperationData data=new OperationData();
        data.setDevice(this);
        System.out.println("22222getDevice"+ data.getDevice());

    }
}
