package com.junjc9.funu.f4d.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.junjc9.funu.f4d.R;

import androidx.appcompat.app.AppCompatActivity;

public class LoginInitActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_init);

    }

    public void oklogin(View v){
        startActivity(new Intent(this, LoginActivity.class));
    }


}
