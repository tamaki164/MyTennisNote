package com.tama164.mytennisnote;

import java.util.Date;

/**
 * Created by Hiroshi on 2015/08/19.
 */
public class BaseData {
    int mId;
    Type mType;
    String mTitle;
    Date mDate;
    Surface mSurface;

    public int getId() {
        return mId;
    }

    public boolean isMatch() {
        return mType == Type.MATCH;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public Surface getSurface() {
        return mSurface;
    }

    enum Type {MATCH, PRACTICE}

    enum Surface {OMNI, CRAY, HARD}
}
