package com.example.chrisswhuang.asynctask.common;

import android.os.AsyncTask;

import com.example.chrisswhuang.asynctask.R;
import com.example.chrisswhuang.asynctask.view.IView;

/**
 * Title: com.example.chrisswhuang.asynctask.common.MyTask<br>
 * Description: MyTask
 *
 * @author chris
 * @version 1.0
 */
public class MyTask extends AsyncTask<String, Integer, String> {

    private IView myView;

    public MyTask(IView myView) {
        this.myView = myView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        myView.setProgressBar(0);
        myView.setText(R.string.start);
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

        myView.updateProgressBar(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        myView.setProgressBar(100);
        myView.setText(R.string.done);
    }

}
