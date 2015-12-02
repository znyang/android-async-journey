package com.zen.android.async.demo.ui.base;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.zen.android.async.demo.R;

/**
 * BaseToolbarActivity
 * <p/>
 *
 * @author yangz
 * @version 2015/12/2.
 */
public abstract class BaseToolbarActivity extends BaseActivity {

    private Toolbar mToolbar;

    @Override
    protected void afterCreate(Bundle state) {
        super.afterCreate(state);
        onSetupToolbar(getToolbar());
    }

    protected Toolbar getToolbar() {
        if (mToolbar == null) {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
        }
        return mToolbar;
    }

    protected void onSetupToolbar(Toolbar toolbar) {
        if (toolbar == null) {
            return;
        }
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            onSetupActionBar(actionBar);
        }
    }

    protected void onSetupActionBar(ActionBar bar) {
        bar.setTitle(getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
