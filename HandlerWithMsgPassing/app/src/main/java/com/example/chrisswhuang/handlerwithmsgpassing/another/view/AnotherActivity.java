package com.example.chrisswhuang.handlerwithmsgpassing.another.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.chrisswhuang.handlerwithmsgpassing.R;
import com.example.chrisswhuang.handlerwithmsgpassing.another.presenter.AnotherPresenter;
import com.example.chrisswhuang.handlerwithmsgpassing.common.IPresenter;
import com.example.chrisswhuang.handlerwithmsgpassing.common.IView;

/**
 * Title: com.example.chrisswhuang.handlerwithmsgpassing.another.view.AnotherActivity<br>
 * Description: AnotherActivity
 *
 * @author chris
 * @version 1.0
 */
public class AnotherActivity extends AppCompatActivity implements IView {

    // Show result
    private TextView resultTextView;

    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        intiView();

        // Presenter
        presenter = new AnotherPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.doThreadStuff();
    }

    /**
     * Initial view
     */
    private void intiView() {
        resultTextView = findViewById(R.id.resultTextView);
    }

    @Override
    public void setText(int result) {
        resultTextView.setText(result);
    }

    @Override
    public void gotoActivity() {
        //
    }
}
