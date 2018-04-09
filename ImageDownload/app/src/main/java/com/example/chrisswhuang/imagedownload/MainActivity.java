package com.example.chrisswhuang.imagedownload;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String HOST = "http://i.imgur.com";
    private static final String IMAGE_URL_PATTERN = "%s/%s";

    private String getUrl(Image data) {
        return String.format(Locale.getDefault(), IMAGE_URL_PATTERN, HOST, data.getImgName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        ImageView targetImageView = findViewById(R.id.imageView);

        Image thumbImage = genImageLists().get(2);
        Image resultImage = genImageLists().get(3);

        Glide.with(this)
                .load(getUrl(thumbImage))
                .thumbnail(Glide.with(this)
                        .load(getUrl(resultImage)))
                .into(targetImageView);
    }

    private Image genDemoFile() {
        Image tempImage = new Image();
        tempImage.setImgName("DvpvklR.png");
        return tempImage;
    }

    private List<Image> genImageLists() {
        List<Image> imageList = new ArrayList<>();

        Image image1 = new Image();
        image1.setImgName("rFLNqWI.jpg");
        imageList.add(image1);

        Image image2 = new Image();
        image2.setImgName("C9pBVt7.jpg");
        imageList.add(image2);

        Image image3 = new Image();
        image3.setImgName("rT5vXE1.jpg");
        imageList.add(image3);

        Image image4 = new Image();
        image4.setImgName("aIy5R2k.jpg");
        imageList.add(image4);

        Image image5 = new Image();
        image5.setImgName("MoJs9pT.jpg");
        imageList.add(image5);

        return imageList;
    }

}
