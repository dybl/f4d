package com.junjc9.funu.about.ui.item;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 *
 * File: FunUAboutItem.java
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

public class FunUAboutItem {

    private Drawable icon;
    private String title, subtitle;
    private View.OnClickListener onClickListener;
    private View.OnLongClickListener onLongClickListener;

    public FunUAboutItem(String title, String subtitle, Drawable icon, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        this.icon = icon;
        this.title = title;
        this.subtitle = subtitle;
        this.onClickListener = onClickListener;
        this.onLongClickListener = onLongClickListener;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Drawable getIcon() {
        return icon;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public View.OnLongClickListener getOnLongClickListener() {
        return onLongClickListener;
    }
}
