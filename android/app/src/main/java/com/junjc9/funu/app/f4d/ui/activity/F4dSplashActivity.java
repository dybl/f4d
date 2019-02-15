package com.junjc9.funu.app.f4d.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.view.View;
import android.view.View.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.junjc9.funu.app.f4d.R;

public class F4dSplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f4d_splash);
        Button bt=(Button) findViewById(R.id.bt); //获取按钮在xml中的id
        bt.setOnClickListener(new OnClickListener() {	//bt按钮的点击事件
            @Override
            public void onClick(View arg0) {  //重载onClick方法
                Intent intent=new Intent();  //实例化Intnent对象
                intent.setClass(HelloActivity.this,MainActivity.class); //设置HelloActivity.class,MainActivity.class两个类
                HelloActivity.this.startActivity(intent); //启动MainActivity.class
            }
        });
        RoundImageView img_round = (RoundImageView) findViewById(R.id.img_round); //获取圆形图像视图在xml中的id
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_f4d); //通过xml的路径静态调用mipmap中的图片资源
        img_round.setBitmap(bitmap); //显示位图
}