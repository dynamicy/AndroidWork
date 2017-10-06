package work.example.chris.jsondealer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import work.example.chris.jsondealer.common.BillContract;

public class SettingsActivity extends AppCompatPreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    @Override
    protected void onResume() {
        super.onResume();
        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(BillContract.NotificationPref)) {
            boolean isNotificationEnable = sharedPreferences.getBoolean(key, false);
        }
    }
}
