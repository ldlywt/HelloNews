package com.ldlywt.hello;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;


import com.blankj.utilcode.util.Utils;
import com.ldlywt.hello.dagger.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;


/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/09/03
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class App extends Application implements HasSupportFragmentInjector, HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mDispatchingAndroidInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentDispatchingAndroidInjector;

    private static App mBaseApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseApp = this;
        Utils.init(this);
        DaggerAppComponent.create().inject(this);
    }

    public static App getInstance(){
        return mBaseApp;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentDispatchingAndroidInjector;
    }
}