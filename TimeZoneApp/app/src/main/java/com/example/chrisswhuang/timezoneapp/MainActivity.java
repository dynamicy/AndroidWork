package com.example.chrisswhuang.timezoneapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class MainActivity extends AppCompatActivity {

    TextView currentTimeZoneTextView;

    TextView currentTimeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentTimeZoneTextView = findViewById(R.id.dateTimeZoneValueTextView);

        currentTimeTextView = findViewById(R.id.dateTimeValueTextView);

        DateTime dateTime = DateTime.now(DateTimeZone.getDefault());

        DateTimeZone dateTimeZone = DateTimeZone.getDefault();

        currentTimeTextView.setText(dateTime.toString());

        currentTimeZoneTextView.setText(dateTimeZone.getID());
    }

}
