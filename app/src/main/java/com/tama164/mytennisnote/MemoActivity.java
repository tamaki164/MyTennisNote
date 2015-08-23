package com.tama164.mytennisnote;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Hiroshi on 2015/08/23.
 */
public class MemoActivity extends Activity {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
    }
}
