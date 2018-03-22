package com.example.chrisswhuang.asynctask.view;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.chrisswhuang.asynctask.R;
import com.example.chrisswhuang.asynctask.presenter.IPresenter;
import com.example.chrisswhuang.asynctask.presenter.Presenter;

/**
 * Title: com.example.chrisswhuang.asynctask.view.MainActivity<br>
 * Description: MainActivity
 *
 * @author chris
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity implements IView {

    private ProgressBar progressBar;

    private TextView resultTextView;

    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        presenter = new Presenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.doThreadStuff();
    }

    private void initView() {
        progressBar = findViewById(R.id.progressBar);
        resultTextView = findViewById(R.id.resultTextView);
    }

    @Override
    public void setText(int resource) {
        resultTextView.setText(resource);
    }

    @Override
    public void setProgressBar(int progress) {
        progressBar.setProgress(progress);
    }

    @Override
    public void updateProgressBar(int progress) {
        progressBar.incrementProgressBy(progress);
    }

}