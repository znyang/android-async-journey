package com.zen.android.async.demo.biz;

import java.util.ArrayList;
import java.util.List;

/**
 * UserManager
 * <p/>
 *
 * @author yangz
 * @version 2015/11/17
 */
public class UserManager {

    private static List<UserStateChanged> listeners = new ArrayList<>();



    public interface UserStateChanged {
        void onLogin();

        void onLogout();
    }
}
