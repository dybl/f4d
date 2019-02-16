package com.junjc9.funu.app.face4d;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); //内容视图是hello.xml
        Button bt= (Button) findViewById(R.id.splash_bt); //获取按钮在xml中的id
        bt.setOnClickListener(new OnClickListener() {	//bt按钮的点击事件
            @Override
            public void onClick(View arg0) {  //重载onClick方法
                Intent intent=new Intent();  //实例化Intnent对象
                intent.setClass(SplashActivity.this,MainActivity.class); //设置HelloActivity.class,MainActivity.class两个类
                SplashActivity.this.startActivity(intent); //启动MainActivity.class
            }
        });
        RoundImageView splash_img = (RoundImageView) findViewById(R.id.splash_img); //获取圆形图像视图在xml中的id
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_hello); //通过xml的路径静态调用mipmap中的图片资源
        splash_img.setBitmap(bitmap); //显示位图

/*
    private final int SPLASH_DISPLAY_LENGHT = 3000;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        RoundImageView splash_img = (RoundImageView) findViewById(R.id.splash_img);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_splash);
        splash_img.setBitmap(bitmap);

        handler = new Handler();
        // 延迟SPLASH_DISPLAY_LENGHT时间然后跳转到MainActivity
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,
                        MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
*/


    }
}