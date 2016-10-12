package com.blumental.treamertestapp;

import android.app.Application;

import com.blumental.treamertestapp.di.ApplicationComponent;
import com.blumental.treamertestapp.di.DaggerApplicationComponent;

public class App extends Application {

    public static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.create();
    }
}
