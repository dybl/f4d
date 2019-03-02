package com.junjc9.funu.f4d.ui.activity.about;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.KeyEvent;

import com.junjc9.funu.f4d.R;

/**
 *
 * File: AboutActivity.java
 *
 * Created by @junjc9 on 03/03/2019.
 *
 * Copyright [2019] [https:github.com/junjc9]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class AboutActivity extends AppCompatActivity {

    WebViewWrapper webViewWrapper;

    private String url = "file:///android_asset/about.html";

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, AboutActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        initView();
        initToolBar();
        webViewWrapper.loadUrl(url);
    }

    private void initView() {
        webViewWrapper = (WebViewWrapper) findViewById(R.id.webVWrapper);
    }

    private void initToolBar() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        webViewWrapper.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        webViewWrapper.onPause();
    }

    @Override
    protected void onDestroy() {
        webViewWrapper.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webViewWrapper.goBack()) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
