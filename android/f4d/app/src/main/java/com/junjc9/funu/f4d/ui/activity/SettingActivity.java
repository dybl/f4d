package com.junjc9.funu.f4d.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.junjc9.funu.f4d.R;
import com.junjc9.funu.f4d.ui.fragment.SettingFragment;


public class SettingActivity extends AppCompatActivity{

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initData();
        initView();
    }

    private void initData() {

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setOnClickListener(view -> finish());
        /*
        {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        */

        getSupportFragmentManager().beginTransaction().replace(R.id.cly_root, SettingFragment.newInstance()).commit();

    }


}
