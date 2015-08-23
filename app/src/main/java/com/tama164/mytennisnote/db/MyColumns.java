package com.tama164.mytennisnote.db;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Hiroshi on 2015/08/21.
 */
public class MyColumns implements BaseColumns {

    public static final String PATH = "data";

    public static final Uri CONTENT_URI = Uri.parse("content://" + MyContentProvider.AUTHORITY + "/" + PATH);

    public static final String TABLE = "mytennisdata";

    public static final String ID = "id";

    public static final String TITLE = "title";

    public static final String DATE = "DATE";

    public static final String SURFACE = "surface";

    public static final String TYPE = "type";

    public static final String SCORE_MY = "score_my";

    public static final String SCORE_OP = "score_op";

    public static final String SCORE_MY_SUB = "score_my_sub";

    public static final String SCORE_OP_SUB = "score_op_sub";
}
