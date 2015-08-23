package com.tama164.mytennisnote.db;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import com.tama164.mytennisnote.util.DevLog;

/**
 * Created by Hiroshi on 2015/08/21.
 */
public class MyContentProvider extends ContentProvider {

    private final String TAG = this.getClass().getSimpleName();

    public static final String AUTHORITY = "com.tama164.mytennisnote";

    private MyDBHelper mDBHelper;

    @Override
    public boolean onCreate() {
        mDBHelper = new MyDBHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        DevLog.d(TAG, "query: " + uri);
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(MyColumns.TABLE);
        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        Cursor cursor = queryBuilder.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        DevLog.d(TAG, "insert: " + uri);
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        long rowId = db.insert(MyColumns.TABLE, null, values);
        if (rowId > 0) {
            Uri returnUri = ContentUris.withAppendedId(MyColumns.CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(returnUri, null);
            return returnUri;
        } else {
            throw new IllegalArgumentException("Failed to insert row into " + uri);
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        DevLog.d(TAG, "delete: " + uri);
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        int count = db.delete(MyColumns.TABLE, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        DevLog.d(TAG, "update: " + uri);
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String id = uri.getPathSegments().get(1);
        int count = db.update(MyColumns.TABLE, values, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}
