package com.junjc9.funu.app.f4d;

import android.app.Application;

public class F4d extends Application {

    private static F4d context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        F4dInit.initTimber();
        F4dInit.initOKHttp(this);
    }

    public static F4d getContext() {
        return context;
    }
}
