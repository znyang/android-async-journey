package com.zen.android.async.demo.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

import com.zen.android.async.demo.R;
import com.zen.android.async.demo.ui.base.BaseCaseActivity;

import butterknife.OnClick;

/**
 * HandlerCaseActivity
 *
 * @author zeny
 * @version 2015.11.19
 */
public class HandlerCaseActivity extends BaseCaseActivity {

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("HandlerCase", "handleMessage " + msg.what);
        }
    };

    @Override
    protected void onBaseCreate(Bundle state) {
        setContentView(R.layout.activity_handler_case);
    }

    @OnClick(R.id.btn_handler_action)
    void onClickAciton() {
        mHandler.sendEmptyMessage(0);
    }

    @OnClick(R.id.btn_handler_action_delay)
    void onClickAcitonDelay() {
        mHandler.sendEmptyMessageDelayed(0, 100000);
    }

    @OnClick(R.id.btn_handler_action_thread)
    void onClickActionWithThread() {
        new Thread(new DoSomeThing()).start();
    }

    private class DoSomeThing implements Runnable {

        @Override
        public void run() {
            SystemClock.sleep(100000);
            mHandler.sendEmptyMessage(0);
        }
    }

}
