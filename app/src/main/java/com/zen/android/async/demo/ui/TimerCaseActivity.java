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
 * <p/>
 *
 * @author yangz
 * @version 2015/11/17
 */
public class TimerCaseActivity extends BaseCaseActivity {

    private Timer mTimer;

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

    @OnClick(R.id.btn_timer_action_static)
    void onStartTimerStatic() {
        new Timer().schedule(new SimpleTimerTask(), 1000, 2000);
    }

    @OnClick(R.id.btn_timer_action_executor)
    void onStartTimerBetter() {
        if (mTimer != null) {
            mTimer.cancel();
        }
        mTimer = new Timer();
        mTimer.schedule(new SimpleTimerTask(), 1000, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimer != null) {
            mTimer.cancel();
        }
    }

    private static class SimpleTimerTask extends TimerTask {

        private byte[] data = new byte[1000000];

        @Override
        public void run() {
            Log.d("Timer", "Running");
        }
    }

}
