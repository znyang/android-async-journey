package com.zen.android.async.demo.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.zen.android.async.demo.R;
import com.zen.android.async.demo.biz.SomeActive;
import com.zen.android.async.demo.ui.base.BaseActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * ThreadCaseActivity
 * <p>
 *
 * @author yangz
 * @version 2015/11/16
 */
public class ThreadCaseActivity extends BaseActivity {

    private static ExecutorService executorService;

    @Bind(R.id.tv_thread_content)
    TextView mTvContent;
    @Bind(R.id.toolbar)
    Toolbar  mToolbar;

    private byte[] data = new byte[2000000];

    @Override
    protected void onBaseCreate(Bundle state) {
        setContentView(R.layout.activity_thread_case);
    }

    @Override
    protected void afterCreate(Bundle state) {
        super.afterCreate(state);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(getTitle());
    }

    @OnClick(R.id.btn_thread_action)
    void onClickAction() {
        Thread thread = new Thread(createRunnable());
        thread.start();
    }

    @OnClick(R.id.btn_thread_action_static)
    void onClickActionStatic() {
        Thread thread = new Thread(new SomeActive());
        thread.start();
    }

    @OnClick(R.id.btn_thread_action_executor)
    void onClickActionWithExecutor() {
        if (executorService == null) {
            executorService = Executors.newFixedThreadPool(3);
        }
        executorService.submit(new SomeActive());
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
