package com.zen.android.async.demo.ui;

import android.annotation.TargetApi;
import android.database.Observable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.os.AsyncTaskCompat;
import android.support.v7.app.ActionBar;

import com.zen.android.async.demo.R;
import com.zen.android.async.demo.biz.SomeActive;
import com.zen.android.async.demo.ui.base.BaseCaseActivity;

import butterknife.OnClick;

/**
 * AsyncTaskCaseActivity
 * <p/>
 *
 * @author yangz
 * @version 2015/11/17
 */
public class AsyncTaskCaseActivity extends BaseCaseActivity {

    @Override
    protected void onBaseCreate(Bundle state) {
        setContentView(R.layout.activity_task_case);
    }

    @Override
    protected void onSetupActionBar(ActionBar bar) {
        super.onSetupActionBar(bar);
        bar.setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.btn_task_action)
    void onClickTask() {
        new AsyncTask<Void, Void, Void>() {

            private SomeActive mSomeActive = new SomeActive();

            @Override
            protected Void doInBackground(Void[] params) {
                mSomeActive.run();
                return null;
            }
        }.execute();
    }

    @OnClick(R.id.btn_task_action_static)
    void onClickStaticTask() {
        new SomeActiveTask().execute();
    }

    @TargetApi(11)
    @OnClick(R.id.btn_task_action_executor)
    void onStartTaskWithExecutors() {
//        if (Build.VERSION.SDK_INT >= 11) {
//            new SomeActiveTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//        } else {
//            new SomeActiveTask().execute();
//        }
        AsyncTaskCompat.executeParallel(new SomeActiveTask());
//        crazyTask();
    }

    void crazyTask() {
        for (int i = 10; --i >= 0; ) {
            AsyncTaskCompat.executeParallel(new SomeActiveTask());
        }
    }

    public static class SomeActiveTask extends AsyncTask<Void, Void, Void> {

        private SomeActive mSomeActive = new SomeActive();

        @Override
        protected Void doInBackground(Void... params) {
            mSomeActive.run();
            return null;
        }
    }
}
