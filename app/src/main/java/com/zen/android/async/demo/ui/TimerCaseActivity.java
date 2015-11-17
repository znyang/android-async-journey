package com.zen.android.async.demo.ui;

import android.os.Bundle;
import android.util.Log;

import com.zen.android.async.demo.R;
import com.zen.android.async.demo.ui.base.BaseCaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.OnClick;

/**
 * TimerCaseActivity
 * <p>
 *
 * @author yangz
 * @version 2015/11/17
 */
public class TimerCaseActivity extends BaseCaseActivity {
    @Override
    protected void onBaseCreate(Bundle state) {
        setContentView(R.layout.activity_timer_case);
    }

    @OnClick(R.id.btn_timer_action)
    void onStartTimer() {
        new Timer().schedule(new TimerTask() {

            private byte[] data = new byte[1000000];

            @Override
            public void run() {
                Log.d("Timer", "Running");
            }
        }, 1000, 2000);
    }

}
