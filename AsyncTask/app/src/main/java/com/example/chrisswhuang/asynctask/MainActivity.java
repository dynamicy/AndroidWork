package com.example.chrisswhuang.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Title: com.example.chrisswhuang.asynctask.MainActivity<br>
 * Description: MainActivity
 *
 * @author chris
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        new MyTask().execute();
    }

    private void initView() {
        progressBar = findViewById(R.id.progressBar);
        resultTextView = findViewById(R.id.resultTextView);
    }

    private class MyTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            resultTextView.setText("Start");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.incrementProgressBy(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressBar.setProgress(100);
            resultTextView.setText("DONE");
        }

    }

}