package com.zen.android.async.demo.biz;

import android.os.SystemClock;
import android.util.Log;

/**
 * SomeActive
 * <p>
 *
 * @author yangz
 * @version 2015/11/16
 */
public class SomeActive implements Runnable {

    private byte[] data = new byte[1000000];

    @Override
    public void run() {
        Log.d("SomeActive", "run start");
//        Thread thread = Thread.currentThread();
//        thread.setName(thread.getName() + " for SomeActive");
        SystemClock.sleep(2000000);
    }
}
