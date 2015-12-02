package com.zen.android.async.demo.ui.dummy;

import android.app.Activity;

import com.zen.android.async.demo.ui.AsyncTaskCaseActivity;
import com.zen.android.async.demo.ui.HandlerBtActivity;
import com.zen.android.async.demo.ui.HandlerCaseActivity;
import com.zen.android.async.demo.ui.ThreadCaseActivity;
import com.zen.android.async.demo.ui.TimerCaseActivity;
import com.zen.android.async.demo.ui.home.HomeActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        addItem(new DummyItem("1", "Thread Case", "", ThreadCaseActivity.class));
        addItem(new DummyItem("2", "Handler Case", "", HandlerCaseActivity.class));
        addItem(new DummyItem("3", "Handler Case 2", "", HandlerBtActivity.class));
        addItem(new DummyItem("4", "Timer Case", "", TimerCaseActivity.class));
        addItem(new DummyItem("5", "AsyncTask Case", "", AsyncTaskCaseActivity.class));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem implements Serializable {
        public final String                    id;
        public final String                    content;
        public final String                    details;
        public final Class<? extends Activity> clazz;

        public DummyItem(String id, String content, String details, Class<? extends Activity> clazz) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.clazz = clazz;
        }

        @Override
        public String toString() {
            return content;
        }

        public Class<? extends Activity> getClazz() {
            return clazz;
        }
    }
}
