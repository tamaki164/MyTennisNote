package com.tama164.mytennisnote;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.tama164.mytennisnote.util.DevLog;

public class MainActivity extends Activity {

    private final String TAG = this.getClass().getSimpleName();

    public static final String TAG_NOTE = "tag_note";
    public static final String TAG_STATISTICS = "tag_statistics";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        //if (actionBar == null) return;
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(actionBar.newTab()
                .setText(getString(R.string.tab_note))
                .setTabListener(new TabListener<NoteFragment>(this, TAG_NOTE, NoteFragment.class)));

        actionBar.addTab(actionBar.newTab()
                .setText(getString(R.string.tab_statistics))
                .setTabListener(new TabListener<StatisticsFragment>(this, TAG_STATISTICS, StatisticsFragment.class)));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add_note) {
            startActivity(new Intent(this, MemoActivity.class));
            DevLog.d(TAG, "add note is selected.");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
