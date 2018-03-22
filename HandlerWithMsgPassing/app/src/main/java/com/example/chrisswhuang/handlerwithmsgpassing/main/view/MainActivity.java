package com.example.chrisswhuang.handlerwithmsgpassing.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chrisswhuang.handlerwithmsgpassing.R;
import com.example.chrisswhuang.handlerwithmsgpassing.another.view.AnotherActivity;
import com.example.chrisswhuang.handlerwithmsgpassing.common.IPresenter;
import com.example.chrisswhuang.handlerwithmsgpassing.common.IView;
import com.example.chrisswhuang.handlerwithmsgpassing.main.presenter.MainPresenter;

/**
 * Title: com.example.chrisswhuang.handlerwithmsgpassing.main.view.MainActivity<br>
 * Description: MainActivity
 *
 * @author chris
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener {

    // Show result
    private TextView resultTextView;

    // Goto another activity
    private Button gotoButton;

    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiView();

        // Presenter
        presenter = new MainPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.doThreadStuff();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gotoButton:
                Intent gotoIntent = new Intent(this, AnotherActivity.class);
                startActivity(gotoIntent);
                break;
            default:
                break;
        }
    }

    /**
     * Initial view
     */
    private void intiView() {
        resultTextView = findViewById(R.id.resultTextView);
        gotoButton = findViewById(R.id.gotoButton);
        gotoButton.setOnClickListener(this);
    }

    @Override
    public void setText(int result) {
        resultTextView.setText(result);
    }

    @Override
    public void gotoActivity() {
        Intent gotoIntent = new Intent(this, AnotherActivity.class);
        startActivity(gotoIntent);
    }

}
