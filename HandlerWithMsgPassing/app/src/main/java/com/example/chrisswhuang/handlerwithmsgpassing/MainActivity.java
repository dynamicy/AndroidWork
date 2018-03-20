package com.example.chrisswhuang.handlerwithmsgpassing;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Title: com.example.chrisswhuang.handlerwithmsgpassing.MainActivity<br>
 * Description: MainActivity
 *
 * @author chris
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    private final static int TASK_COMPLETE = 0x999;

    // Show result
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiView();

        new MyThread().start();
    }

    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message inputMessage) {
            if (inputMessage.what == TASK_COMPLETE) {
                resultTextView.setText(R.string.hint);
            }
        }
    };

    class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.sendEmptyMessage(TASK_COMPLETE);
        }
    }

    /**
     * Initial view
     */
    private void intiView() {
        resultTextView = findViewById(R.id.resultTextView);
    }
}
