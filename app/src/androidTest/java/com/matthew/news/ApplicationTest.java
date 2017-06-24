package com.matthew.news;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class ApplicationTest extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}