package work.example.chris.jsondealer;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import work.example.chris.jsondealer.common.BillContract;
import work.example.chris.jsondealer.component.BillDataRecyclerViewAdapter;
import work.example.chris.jsondealer.model.BillModel;
import work.example.chris.jsondealer.model.BillModelSets;
import work.example.chris.jsondealer.utils.BillDBHelper;
import work.example.chris.jsondealer.utils.JsonHelper;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;

    private BillDataRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager linerLayouManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linerLayouManager);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) ==
            PackageManager.PERMISSION_GRANTED) {
            Cursor cursor = getContentResolver().query(BillContract.CONTENT_URI, null, null, null, null);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        adapter = new BillDataRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void readDataFromProvider() {
        Cursor cursor = getContentResolver().query(BillContract.CONTENT_URI, null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(BillContract.ID));
            String date = cursor.getString(cursor.getColumnIndex(BillContract.DATE));
            String name = cursor.getString(cursor.getColumnIndex(BillContract.NAME));
            int price = cursor.getInt(cursor.getColumnIndex(BillContract.PRICE));

            Log.d(TAG, "id: " + id + ", date: " + date + ", name: " + name + ", price: " + price);
        }
    }

    /**
     * Dump data info
     */
    private void readDataFromJson() {

        BillDBHelper billDBHelper = new BillDBHelper(this);

        Cursor cursor = billDBHelper.getReadableDatabase()
                                    .query(BillContract.TableName, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(BillContract.ID));
            String date = cursor.getString(cursor.getColumnIndex(BillContract.DATE));
            String name = cursor.getString(cursor.getColumnIndex(BillContract.NAME));
            int price = cursor.getInt(cursor.getColumnIndex(BillContract.PRICE));

            Log.d(TAG, "id: " + id + ", date: " + date + ", name: " + name + ", price: " + price);
        }
    }

    private void dumpDataSets(BillModelSets billModelLists) {
        for (BillModel item : billModelLists.getRetail()) {
            Log.d(TAG, "Date: " + item.getCdate());
            Log.d(TAG, "Name: " + item.getName());
            Log.d(TAG, "Price: " + item.getPrice());
        }
    }
}
