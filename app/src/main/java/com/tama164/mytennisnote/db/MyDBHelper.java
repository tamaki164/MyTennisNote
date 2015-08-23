package com.tama164.mytennisnote.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hiroshi on 2015/08/21.
 */
public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "database";
    private static final int DB_VERSION = 1;

    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
