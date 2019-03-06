package com.example.funu.ui.activity.splash;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;xs
import androidx.appcompat.app.AppCompatActivity;
import com.example.funu.R;
import com.example.funu.ui.activity.DrawActivity;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;
    private Handler handler;
    private ImageView img;
    private boolean enableExit=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);


        img = (ImageView)findViewById(R.id.splash_img);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_studio);
        img.setImageBitmap(bitmap);
        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, DrawActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

        /*
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
            @Override
            public void run() {
            Intent intent = new Intent(LoginPage.this,MainPage.class);
            startActivity(intent);
            }
            };
            timer.schedule(task, 2000);
         */
    }


    /*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            if(!enableExit) {
                enableExit = true;
                Toast.makeText(this,"再按一次退出", Toast.LENGTH_LONG).show();
                handler.sendEmptyMessageDelayed(0,3000);
            }else {
//                finish();
                System.exit(0);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
