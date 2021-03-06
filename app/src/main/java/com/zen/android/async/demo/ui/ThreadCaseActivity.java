package com.zen.android.async.demo.ui;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.zen.android.async.demo.R;
import com.zen.android.async.demo.biz.SomeActive;
import com.zen.android.async.demo.ui.base.BaseActivity;
import com.zen.android.async.demo.ui.base.BaseCaseActivity;
import com.zen.android.async.demo.ui.base.BaseToolbarActivity;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * ThreadCaseActivity
 * <p/>
 *
 * @author yangz
 * @version 2015/11/16
 */
public class ThreadCaseActivity extends BaseCaseActivity {


    @Bind(R.id.tv_thread_content)
    TextView mTvContent;
    @Bind(R.id.tv_thread_static)
    TextView mTvStatic;
    @Bind(R.id.tv_thread_executor)
    TextView mTvExecutor;

    @Override
    protected void onBaseCreate(Bundle state) {
        setContentView(R.layout.activity_thread_case);
    }

    @Override
    protected void onSetupActionBar(ActionBar bar) {
        super.onSetupActionBar(bar);
        bar.setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.btn_thread_action)
    void onClickAction() {
        new Thread(new Runnable() {
            byte[] data = new byte[10000000];

            @Override
            public void run() {
                // 1000s
                SystemClock.sleep(1000000);
            }
        }).start();
    }

    @OnClick(R.id.btn_thread_action_static)
    void onClickActionStatic() {
        Thread thread = new Thread(new SomeActive());
        thread.start();
    }

    @OnClick(R.id.btn_thread_action_executor)
    void onClickActionWithExecutor() {
//        if (executorService == null) {
//            executorService = Executors.newFixedThreadPool(3);
//        }
//        executorService.submit(new SomeActive());
        useThread();
    }

    private static ExecutorService executorService;

    void useThread() {
        if (executorService == null) {
            executorService = Executors.newFixedThreadPool(3);
        }
        executorService.submit(new Task(new Callback() {
            @Override
            public void callback() {
                // on callback
            }
        }));
    }

    private interface Callback {
        void callback();
    }

    private static class Task implements Runnable {

        private byte[] data = new byte[1000000];
        private final WeakReference<Callback> mRef;

        public Task(Callback ref) {
            mRef = new WeakReference<>(ref);
        }

        @Override
        public void run() {
            // do something
            SystemClock.sleep(200000);
            // callback
            if (mRef.get() != null) {
                mRef.get().callback();
            }
        }
    }

    @NonNull
    private Runnable createRunnable() {
        return new Runnable() {

            @Override
            public void run() {
                new SomeActive().run();
            }
        };
    }
}
