package com.junjc9.funu.about.utils;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;

import com.junjc9.funu.about.ui.item.FunUBaseAboutItem;
import com.junjc9.funu.about.ui.item.FunUHeaderAboutItem;

/**
 *
 * File: FunUAboutItemBuilder.java
 *
 * Created by @junjc9 on 27/02/2019.
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

public final class FunUAboutItemBuilder {

    public static FunUHeaderAboutItem.Builder generateAppTitleItem(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return new FunUHeaderAboutItem.Builder(context)
                .setTitle(packageManager.getApplicationLabel(applicationInfo).toString())
                .setIcon(packageManager.getApplicationIcon(applicationInfo));
    }

    public static FunUBaseAboutItem.Builder generateAppVersionItem(Context context, boolean withVersionCode) {
        PackageManager packageManager = context.getPackageManager();
        String version = "";
        try {
            version = packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
            if (withVersionCode)
                version += " (" + packageManager.getPackageInfo(context.getPackageName(), 0).versionCode + ")";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new FunUBaseAboutItem.Builder(context)
                .setTitle("Version")
                .setSubtitle(version);
    }

    public static FunUBaseAboutItem.Builder generateLinkItem(final Context context, final String url) {
        return new FunUBaseAboutItem.Builder(context)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    }
                });
    }

    public static FunUBaseAboutItem.Builder generateEmailItem(final Context context, final String email) {
        return generateLinkItem(context, "mailto:" + email);
    }

    public static FunUBaseAboutItem.Builder generatePlayStoreItem(final Context context) {
        final String appPackageName = context.getPackageName();
        return new FunUBaseAboutItem.Builder(context)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (ActivityNotFoundException anfe) {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                        }
                    }
                });
    }

}

