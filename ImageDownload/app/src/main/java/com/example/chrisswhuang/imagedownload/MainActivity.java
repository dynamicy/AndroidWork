package com.example.chrisswhuang.imagedownload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        ImageView targetImageView = findViewById(R.id.imageView);

        String internetUrl = "http://i.imgur.com/DvpvklR.png";

        Glide.with(this).load(internetUrl).into(targetImageView);
    }

}
