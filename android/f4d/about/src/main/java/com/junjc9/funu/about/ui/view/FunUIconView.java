package com.junjc9.funu.about.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import androidx.appcompat.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.TypedValue;

/**
 *
 * File: FunUIconView.java
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

public final class FunUIconView extends AppCompatImageView {

    public FunUIconView (Context context) {
        super(context);
        tint(context);
    }

    public FunUIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        tint(context);
    }

    public FunUIconView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        tint(context);
    }

    public FunUIconView setColor(int color) {
        setColorFilter(color, PorterDuff.Mode.SRC_IN);
        return this;
    }

    private void tint(Context ctx) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = ctx.getTheme();
        theme.resolveAttribute(android.R.attr.textColorPrimary, typedValue, true);
        TypedArray arr =
                ctx.obtainStyledAttributes(typedValue.data, new int[]{
                        android.R.attr.textColorSecondary});
        int secondaryColor = arr.getColor(0, -1);
        setColorFilter(secondaryColor, PorterDuff.Mode.SRC_IN);
        arr.recycle();
    }
}