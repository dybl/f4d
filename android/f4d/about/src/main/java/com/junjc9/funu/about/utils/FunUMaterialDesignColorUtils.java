package com.junjc9.funu.about.utils;

import android.content.Context;
import android.os.Build;
import android.util.TypedValue;

/**
 *
 * File: FunUMaterialDesignColorUtils.java
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

public final class FunUMaterialDesignColorUtils {

    public static int getThemeAccentColor(Context context) {
        int colorAttr;
        if (Build.VERSION.SDK_INT >= 21) {
            colorAttr = android.R.attr.colorAccent;
        } else {
            colorAttr = context.getResources().getIdentifier("colorAccent", "attr", context.getPackageName());
        }
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(colorAttr, outValue, true);
        return outValue.data;
    }

    public static int getThemeAttrColor(Context context, String attrName) {
        int value = 0;
        try {
            int colorAttr = context.getResources().getIdentifier(attrName, "attr", context.getPackageName());
            TypedValue outValue = new TypedValue();
            context.getTheme().resolveAttribute(colorAttr, outValue, true);
            value = outValue.data;
        } catch (Exception e) {}
        return value;
    }

    public static boolean isDark(int color) {
        return androidx.core.graphics.ColorUtils.calculateLuminance(color) < 0.4;
    }

}
