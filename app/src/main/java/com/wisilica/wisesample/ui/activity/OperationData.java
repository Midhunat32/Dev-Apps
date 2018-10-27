package com.wisilica.wisesample.ui.activity;

public class OperationData {
    MeshDev device;

    public MeshDev getDevice() {
        return device;
    }

    public void setDevice(MeshDev device) {
        this.device = device;
    }
    public OperationData() {
    }

    public OperationData(String type, String top) {
        this.type = type;
        this.top = top;
    }

    String type,top;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }
}
