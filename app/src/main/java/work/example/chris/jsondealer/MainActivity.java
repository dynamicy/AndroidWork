package work.example.chris.jsondealer;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import work.example.chris.jsondealer.common.BillContract;
import work.example.chris.jsondealer.component.BillDataRecyclerViewAdapter;
import work.example.chris.jsondealer.component.OnItemClickListener;
import work.example.chris.jsondealer.model.BillModel;
import work.example.chris.jsondealer.model.BillModelSets;
import work.example.chris.jsondealer.model.BillRecord;
import work.example.chris.jsondealer.utils.BillDBHelper;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, OnItemClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();

    private final static int LOADER = 100;

    private RecyclerView recyclerView;

    private BillDataRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();

        setupRecyclerView();

        getLoaderManager().initLoader(LOADER, null, this);
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

    private void setupRecyclerView() {
        adapter = new BillDataRecyclerViewAdapter();
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);

        getLoaderManager().restartLoader(LOADER, null, this);
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager linerLayouManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linerLayouManager);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("Menu1");
        menu.add("Menu2");

        getMenuInflater().inflate(R.menu.layout_menu_mainactivity, menu);
        return true;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, BillContract.CONTENT_URI, null, null, null, BillContract.NAME);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        this.adapter.setCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        this.adapter.setCursor(null);
    }

    @Override
    public void onItemClick(int position, BillRecord billRecord) {
        Intent intentToItemDetail = new Intent(this, ItemDetailActivity.class);
        intentToItemDetail.putExtra(BillContract.BillRecordBundleKey, billRecord);
        startActivity(intentToItemDetail);
    }
}
