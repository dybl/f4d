package com.junjc9.funu.f4d.ui.activity;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.File;

public class CameraPreviewActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView img = new ImageView(this);
        String path = getIntent().getStringExtra("path");
        if(path != null){
            img.setImageURI(Uri.fromFile(new File(path)));
        }
        setContentView(img);
    }
}
