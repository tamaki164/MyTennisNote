package com.tama164.mytennisnote;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by Hiroshi on 2015/08/13.
 */
public class TabListener<T extends Fragment> implements ActionBar.TabListener {

    private Fragment mFragment;
    private final Activity mActivity;
    private final String mTag;
    private final Class<T> mClass;

    public TabListener(Activity activity, String tag, Class<T> cls) {
        mActivity = activity;
        mTag = tag;
        mClass = cls;
        mFragment = mActivity.getFragmentManager().findFragmentByTag(mTag);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        FragmentManager manager = mActivity.getFragmentManager();

        if (mFragment == null) {
            mFragment = Fragment.instantiate(mActivity, mClass.getName());
            manager.beginTransaction().add(R.id.fragment, mFragment, mTag).commit();
        } else {
            manager.beginTransaction().attach(mFragment).commit();
        }

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        if (mFragment != null) {
            FragmentManager manager = mActivity.getFragmentManager();
            manager.beginTransaction().detach(mFragment).commit();
        }

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
