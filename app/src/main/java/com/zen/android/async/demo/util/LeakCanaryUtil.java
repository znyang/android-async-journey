package com.zen.android.async.demo.util;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * LeakCanaryUtil
 * <p/>
 *
 * @author yangz
 * @version 2015/12/2.
 */
public class LeakCanaryUtil {

    private static RefWatcher sRefWatcher;

    public static void init(Application application) {
        sRefWatcher = LeakCanary.install(application);
    }

    public static RefWatcher getRefWatcher() {
        return sRefWatcher;
    }
}
