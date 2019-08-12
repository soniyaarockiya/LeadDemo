package com.example.a91user.leaddemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class DisplayActivity extends AppCompatActivity {


    //ui Element
    private ImageView displayImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //get bitmap data from intent and display in the image view
        displayImage = findViewById(R.id.displayImage);
        Bundle extras = getIntent().getExtras();
        Bitmap bmp = extras.getParcelable("Bitmap");
        displayImage.setImageBitmap(bmp);


    }
}
