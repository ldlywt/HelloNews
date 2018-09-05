package com.ldlywt.hello;

import android.app.Activity;
import android.app.Application;
import android.provider.SyncStateContract;
import android.support.v4.app.Fragment;


import com.blankj.utilcode.util.Utils;
import com.ldlywt.hello.dagger.component.DaggerAppComponent;
import com.zhouyou.http.EasyHttp;

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

    private static App mBaseApp;
    @Inject
    DispatchingAndroidInjector<Activity> mDispatchingAndroidInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentDispatchingAndroidInjector;

    public static App getInstance() {
        return mBaseApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseApp = this;
        Utils.init(this);
        DaggerAppComponent.create().inject(this);
        initHttp();
    }

    private void initHttp() {
        EasyHttp.init(this);
        EasyHttp
                .getInstance()
                .setBaseUrl(Constant.WAN_ANDROID_HOST_URL)
                .debug("EasyHttp", true);
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