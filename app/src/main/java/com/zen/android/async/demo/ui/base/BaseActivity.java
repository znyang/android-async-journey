package com.zen.android.async.demo.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.leakcanary.LeakCanary;
import com.zen.android.async.demo.util.LeakCanaryUtil;

import butterknife.ButterKnife;

/**
 * BaseActivity
 * <p/>
 *
 * @author yangz
 * @version 2015/11/16
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeCreate();
        onBaseCreate(savedInstanceState);
        afterCreate(savedInstanceState);
    }

    protected void beforeCreate() {
        // empty
    }

    protected abstract void onBaseCreate(Bundle state);

    protected void afterCreate(Bundle state) {
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        LeakCanaryUtil.getRefWatcher().watch(this);
    }
}
