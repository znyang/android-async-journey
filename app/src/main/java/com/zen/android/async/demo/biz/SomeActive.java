package com.zen.android.async.demo.biz;

import android.os.SystemClock;

/**
 * SomeActive
 * <p/>
 *
 * @author yangz
 * @version 2015/11/16
 */
public class SomeActive implements Runnable {

    private byte[] data = new byte[5000000];

    @Override
    public void run() {
        Thread.currentThread().setName("SomeActive");
        SystemClock.sleep(100000);
    }
}
