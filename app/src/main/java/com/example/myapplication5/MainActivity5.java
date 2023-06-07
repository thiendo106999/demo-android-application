package com.example.myapplication5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity5 extends AppCompatActivity {
    Intent intent;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Button button = findViewById(R.id.share_button);
        button.setOnClickListener(v -> {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here");
            String app_url = " https://play.google.com/store/apps/details?id=my.example.javatpoint";
            intent.putExtra(Intent.EXTRA_TEXT, app_url);
            startActivity(Intent.createChooser(intent, "Share via"));
        });

        Button button1 = findViewById(R.id.share_open_web);
        button1.setOnClickListener(v -> {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.google.com"));
            startActivity(intent);
        });

        Button button2 = findViewById(R.id.open_camera);
        button2.setOnClickListener(v -> {
            intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            ImageView imageview = (ImageView) findViewById(R.id.imv);
            imageview.setImageBitmap(image);
        }
    }
//    https://viblo.asia/p/mot-so-implicit-intent-pho-bien-trong-android-rNkKxxOvKlm
}