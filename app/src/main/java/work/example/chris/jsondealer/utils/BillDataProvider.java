package work.example.chris.jsondealer.utils;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import work.example.chris.jsondealer.common.BillContract;

public class BillDataProvider extends ContentProvider {

    private final static String TAG = BillDataProvider.class.getSimpleName();

    private final static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private final static int BILL = 100;

    private final static int BILL_ID = 101;

    private final static int BILL_NAME = 102;

    private BillDBHelper billDBHelper;

    static {
        uriMatcher.addURI(BillContract.AUTHORITY, BillContract.TableName, BILL);
        uriMatcher.addURI(BillContract.AUTHORITY, BillContract.TableName + "/#", BILL_ID);
        uriMatcher.addURI(BillContract.AUTHORITY, BillContract.TableName + "/#", BILL_NAME);
    }

    private BillDBHelper getInstance() {
        return new BillDBHelper(getContext());
    }

    @Override
    public boolean onCreate() {
        billDBHelper = getInstance();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {

        Cursor cursor;
        long id;

        switch (uriMatcher.match(uri)) {
            case BILL:
                break;
            case BILL_ID:
                id = ContentUris.parseId(uri);
                selection = BillContract.ID + " = " + id;
                break;
            case BILL_NAME:
                id = ContentUris.parseId(uri);
                selection = BillContract.NAME + " = " + id;
            default:
                break;
        }

        cursor = getInstance().getReadableDatabase().query(BillContract.TableName,
                                                           projection, selection, selectionArgs, null, null, sortOrder);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long id = this.getInstance().getWritableDatabase().insert(BillContract.TableName, null, values);
        return ContentUris.withAppendedId(BillContract.CONTENT_URI, id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    public BillDBHelper getBillDBHelper() {
        return billDBHelper;
    }

    public void setBillDBHelper(BillDBHelper billDBHelper) {
        this.billDBHelper = billDBHelper;
    }
}
