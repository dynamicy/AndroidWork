package com.example.chrisswhuang.handlerwithmsgpassing.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.example.chrisswhuang.handlerwithmsgpassing.R;

/**
 * Title: com.example.chrisswhuang.handlerwithmsgpassing.common.MyThread<br>
 * Description: AnotherActivity
 *
 * @author chris
 * @version 1.0
 */
public class MyThread extends Thread {

    private final static int TASK_COMPLETE = 0x999;

    private IView myView;

    public MyThread(IView myView) {
        this.myView = myView;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handler.sendEmptyMessage(TASK_COMPLETE);
    }

    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message inputMessage) {
            if (inputMessage.what == TASK_COMPLETE) {
                myView.setText(R.string.hint);
            }
        }
    };
}
