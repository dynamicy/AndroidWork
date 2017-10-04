package work.example.chris.jsondealer.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import work.example.chris.jsondealer.common.BillContract;
import work.example.chris.jsondealer.model.BillModel;
import work.example.chris.jsondealer.model.BillModelSets;

public class BillDBHelper extends SQLiteOpenHelper {

    private final static String TAG = BillDBHelper.class.getSimpleName();

    private Context context;

    public BillDBHelper(Context context) {
        super(context, BillContract.DBName, null, 1);
        this.context = context;
    }

    private BillDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private BillDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version,
                        DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(BillContract.crateTable);
        readData(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * Read expense from resource
     *
     * @param sqLiteDatabase
     */
    private void readData(SQLiteDatabase sqLiteDatabase) {
        BillModelSets billModelSets = JsonHelper.getModelFromRaw(context, BillContract.BillResource);

        for (BillModel item : billModelSets.getRetail()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(BillContract.DATE, item.getCdate());
            contentValues.put(BillContract.NAME, item.getName());
            contentValues.put(BillContract.PRICE, item.getPrice());

            long id = sqLiteDatabase.insert(BillContract.TableName, null, contentValues);

            Log.d(TAG, "id: " + id);
        }
    }
}
