package com.zen.android.async.demo;

import android.app.Application;

import com.zen.android.async.demo.util.LeakCanaryUtil;

/**
 * DemoApp
 * <p/>
 *
 * @author yangz
 * @version 2015/12/2.
 */
public class DemoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanaryUtil.init(this);
    }
}
