package com.marton.base.juc.complate;

import java.io.Serializable;


public class MyPacket implements Serializable {


    private String request;

    private String response;

    private int watchFlag;

    public int getWatchFlag() {
        return watchFlag;
    }

    public String getResponse() {
        return response;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setWatchFlag(int watchFlag) {
        this.watchFlag = watchFlag;
    }
}
