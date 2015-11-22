package com.zen.android.async.demo.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.zen.android.async.demo.R;
import com.zen.android.async.demo.ui.base.BaseCaseActivity;

import butterknife.OnClick;

/**
 * HandlerBtActivity
 *
 * @author zeny
 * @version 2015.11.22
 */
public class HandlerBtActivity extends BaseCaseActivity {

    private BtHandler mHandler;

    @Override
    protected void onBaseCreate(Bundle state) {
        setContentView(R.layout.activity_handler_case);
    }

    @OnClick(R.id.btn_handler_action)
    void onClickAciton() {
        mHandler = new BtHandler();
        mHandler.sendEmptyMessageDelayed(0, 1000000);
    }

    @OnClick(R.id.btn_handler_action_delay)
    void onClickAcitonDelay() {
        new BtHandler().sendEmptyMessageDelayed(0, 10000);
    }

    @OnClick(R.id.btn_handler_action_thread)
    void onClickActionWithThread() {

    }

    private static class BtHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("HandlerCase", "handleMessage " + msg.what);
        }
    }
}
