package work.example.chris.jsondealer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String result = JsonHelper.getJsonFromRaw(this);

        String resultFromSpecificPath = JsonHelper.getJsonFromRaw(this, R.raw.bill);

        String resultFromAssets = JsonHelper.getJsonFromAssets(getAssets(), "billassets.json");

        Log.d(TAG, "onCreate: " + result);

        Log.d(TAG, "onCreate: " + resultFromSpecificPath);

        Log.d(TAG, "onCreate: " + resultFromAssets);
    }
}
