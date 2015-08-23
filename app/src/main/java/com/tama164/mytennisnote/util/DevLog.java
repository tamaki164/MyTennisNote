package com.tama164.mytennisnote.util;

import android.util.Log;

/**
 * Created by Hiroshi on 2015/08/21.
 */
public class DevLog {

    private static final String TAG = "MyTennisNote";

    public static void e(String tag, String message) {
        Log.e(TAG, "[" + tag + "] " + message);
    }

    public static void w(String tag, String message) {
        Log.w(TAG, "[" + tag + "] " + message);
    }

    public static void i(String tag, String message) {
        Log.i(TAG, "[" + tag + "] " + message);
    }

    public static void d(String tag, String message) {
        if (AppConfig.sDebug) {
            // debug log is displayed only for debug mode
            Log.d(TAG, "[" + tag + "] " + message);
        }
    }
}
