package com.junjc9.funu.f4d.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.junjc9.funu.f4d.F4d;

public class PackageUtils {

    public static int packageCode() {
        PackageManager manager = F4d.getContext().getPackageManager();
        int code = 0;
        try {
            PackageInfo info = manager.getPackageInfo(F4d.getContext().getPackageName(), 0);
            code = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return code;
    }

    public static String packageName() {
        PackageManager manager = F4d.getContext().getPackageManager();
        String name = null;
        try {
            PackageInfo info = manager.getPackageInfo(F4d.getContext().getPackageName(), 0);
            name = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return name;
    }
}
