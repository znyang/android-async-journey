package com.zen.android.async.demo.service;

import android.app.IntentService;
import android.content.Intent;

/**
 * SimpleIntentService
 *
 * @author zeny
 * @version 2015.11.19
 */
public class SimpleIntentService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public SimpleIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
