package work.example.chris.jsonhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import work.example.chris.jsonhelper.model.Record;
import work.example.chris.jsonhelper.model.RecordSets;
import work.example.chris.jsonhelper.utils.JsonHelper;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStart() {

        Log.d(TAG, "onStart: ");

        super.onStart();

        RecordSets dataLists = JsonHelper.getModelFromRaw(this);

        for(Record item : dataLists.getRecord()) {
            Log.d(TAG, "Date: " + item.getCdate());
            Log.d(TAG, "Name: " + item.getName());
            Log.d(TAG, "Type: " + item.getType());
            Log.d(TAG, "Price: " + item.getPrice());
        }
    }
}
