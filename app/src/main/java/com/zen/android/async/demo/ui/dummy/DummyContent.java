package com.zen.android.async.demo.ui.dummy;

import android.app.Activity;

import com.zen.android.async.demo.ui.AsyncTaskCaseActivity;
import com.zen.android.async.demo.ui.HandlerBtActivity;
import com.zen.android.async.demo.ui.HandlerCaseActivity;
import com.zen.android.async.demo.ui.ThreadCaseActivity;
import com.zen.android.async.demo.ui.TimerCaseActivity;

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

    private static final int COUNT = 25;

    static {
        // Add some sample items.
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDummyItem(i));
//        }
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

//    private static DummyItem createDummyItem(int position) {
//        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
//    }

//    private static String makeDetails(int position) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Details about Item: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore details information here.");
//        }
//        return builder.toString();
//    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
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
    }
}
