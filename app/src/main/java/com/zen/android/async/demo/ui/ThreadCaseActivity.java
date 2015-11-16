package com.zen.android.async.demo.ui;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.zen.android.async.demo.R;
import com.zen.android.async.demo.biz.SomeActive;
import com.zen.android.async.demo.ui.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * ThreadCaseActivity
 * <p/>
 *
 * @author yangz
 * @version 2015/11/16
 */
public class ThreadCaseActivity extends BaseActivity {

    @Bind(R.id.tv_thread_content)
    TextView mTvContent;
    @Bind(R.id.toolbar)
    Toolbar  mToolbar;

    private byte[] data = new byte[10240000];

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
        Thread thread = new Thread(new SomeActive());
        thread.start();
    }

    @OnClick(R.id.btn_thread_action_inner)
    void onClickActionInner() {
        Thread thread = new Thread(new Runnable() {

            private byte[] data = new byte[5000000];

            @Override
            public void run() {
                Thread.currentThread().setName("SomeActive InnerClass");
                SystemClock.sleep(100000);
            }
        });
        thread.start();
    }
}
