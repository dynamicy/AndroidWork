package work.example.chris.jsondealer.common;

import android.net.Uri;

import work.example.chris.jsondealer.R;

public class BillContract {

    /**
     * Resources
     */
    public final static int BillResource = R.raw.bill;

    public final static String AssetsName = "billassets.json";

    /**
     * DB commons
     */
    public final static String DBName = "bill.db";

    public final static String TableName = "bill";

    /**
     * DB fields
     */
    public final static String ID = "_id";
    public final static String DATE = "cdate";
    public final static String NAME = "name";
    public final static String PRICE = "price";

    /**
     * SQL sentence
     */
    public final static String crateTable = "create table "
            + BillContract.TableName + " ("
            + BillContract.ID + " integer primary key, "
            + BillContract.DATE + " datetime, "
            + BillContract.NAME + " varchar, "
            + BillContract.PRICE + " integer)";

    public final static String crateTableRaw = "create table bill (_id integer primary key, cdate datetime, name varchar, price integer)";

    /**
     * Content Provider
     */
    public final static String AUTHORITY = "work.example.chris.jsondealer";

    public final static Uri CONTENT_URI = new Uri.Builder()
            .scheme("content")
            .authority(AUTHORITY)
            .appendPath(TableName)
            .build();

    /**
     * Bundle Key
     */
    public final static String BillRecordBundleKey = "BillRecord";

    /**
     * Shared Preference
     */
    public final static String SharedPreference = "SharedPreference";

    public final static String SortPref = "SortPref";

    public final static String NotificationPref = "NotificationPref";
}
