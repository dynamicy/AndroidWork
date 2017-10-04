package work.example.chris.jsondealer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import work.example.chris.jsondealer.common.BillContract;
import work.example.chris.jsondealer.model.BillModel;
import work.example.chris.jsondealer.model.BillModelSets;
import work.example.chris.jsondealer.utils.JsonHelper;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String result = JsonHelper.getJsonFromRaw(this);

        String resultFromSpecificPath = JsonHelper.getJsonFromRaw(this, BillContract.BillResource);

        String resultFromAssets = JsonHelper.getJsonFromAssets(getAssets(), BillContract.AssetsName);

        BillModelSets billModelLists = JsonHelper.getModelFromRaw(this, R.raw.bill);

        dumpDataSets(billModelLists);

        Log.d(TAG, "onCreate: " + result);

        Log.d(TAG, "onCreate: " + resultFromSpecificPath);

        Log.d(TAG, "onCreate: " + resultFromAssets);
    }

    private void dumpDataSets(BillModelSets billModelLists) {
        for (BillModel item : billModelLists.getRetail()) {
            Log.d(TAG, "Date: " + item.getCdate());
            Log.d(TAG, "Name: " + item.getName());
            Log.d(TAG, "Price: " + item.getPrice());
        }
    }
}
