package work.example.chris.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        applySharedPref(R.string.onCreate, "stage: onCreate");
    }

    @Override
    protected void onStart() {

        super.onStart();
        applySharedPref(R.string.onStart, "stage: onStart");
    }

    @Override
    protected void onResume() {

        super.onResume();

        applySharedPref(R.string.onResume, "stage: onResume");

        // Dump all values
        String stageOnCreate = sharedPreferences.getString(getString(R.string.onCreate), null);

        String stageOnStart = sharedPreferences.getString(getString(R.string.onStart), null);

        String stageOnResume = sharedPreferences.getString(getString(R.string.onResume), null);

        Log.d(TAG, "stageOnCreate: " + stageOnCreate);

        Log.d(TAG, "stageOnStart: " + stageOnStart);

        Log.d(TAG, "stageOnResume: " + stageOnResume);
    }

    @Override
    protected void onPause() {
        super.onPause();
        applySharedPref(R.string.onPause, "stage: onPause");

        String stageOnPause = sharedPreferences.getString(getString(R.string.onPause), null);

        Log.d(TAG, "stageOnPause: " + stageOnPause);
    }

    @Override
    protected void onStop() {
        super.onStop();
        applySharedPref(R.string.onStop, "stage: onStop");

        String stageOnStop = sharedPreferences.getString(getString(R.string.onStop), null);

        Log.d(TAG, "stageOnStop: " + stageOnStop);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        applySharedPref(R.string.onDestroy, "stage: onDestroy");

        String stageOnDestroy = sharedPreferences.getString(getString(R.string.onDestroy), null);

        Log.d(TAG, "stageOnDestroy: " + stageOnDestroy);
    }

    private void applySharedPref(int res, String context) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(res), context);
        editor.apply();
    }
}
