package com.junjc9.funu.f4d.ui.activity.login;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;

import com.junjc9.funu.f4d.R;
import com.junjc9.funu.f4d.ui.activity.MainActivity;


public class LoginSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_success);

        Explode explode = new Explode();
        explode.setDuration(500);
        getWindow().setExitTransition(explode);
        getWindow().setEnterTransition(explode);
    }

    public void okall(View v){
        startActivity(new Intent(this, MainActivity.class));
    }
}
