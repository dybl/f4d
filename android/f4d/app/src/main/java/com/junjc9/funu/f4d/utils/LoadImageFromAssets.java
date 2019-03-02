package com.junjc9.funu.f4d.utils;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.core.graphics.drawable.DrawableCompat;

import android.widget.ImageView;

public class LoadImageFromAssets {

    @SuppressWarnings("deprecation")
    public static void colorImageViewDrawable(ImageView imageView, @ColorRes int id) {
        if (imageView == null) {
            return;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, new ColorStateList(new int[][]{new int[]{}}, new int[]{imageView.getContext().getResources().getColor(id)}));
            imageView.setImageDrawable(drawable);
        }
    }
}

