package com.example.klear2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    Button camera;
    Button diy;
    Button donate;
    Button pickup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        camera = (Button)findViewById(R.id.classify);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        diy = (Button)findViewById(R.id.diy);
        diy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,YoutubeActivity.class);
                startActivity(intent);
            }
        });
        donate = (Button)findViewById(R.id.donate);
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSeMi6jaDEGQhE0_UIuP_2aDUQIJ5GRBQRWYvnK8FMkqZzUgiQ/viewform?usp=sf_link"));
                startActivity(browserIntent);
            }
        });
        pickup = (Button)findViewById(R.id.pickup);
        pickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,PickupActivity.class);
                startActivity(intent);
            }
        });
    }
}