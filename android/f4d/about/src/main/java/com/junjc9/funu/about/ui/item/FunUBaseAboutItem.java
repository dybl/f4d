package com.junjc9.funu.about.ui.item;


import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import android.view.View;

/**
 *
 * File: FunUBaseAboutItem.java
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

public final class FunUBaseAboutItem extends FunUAboutItem {

    private FunUBaseAboutItem(FunUBaseAboutItem.Builder builder) {
        super(builder.title, builder.subtitle, builder.icon, builder.onClickListener, builder.onLongClickListener);
    }

    public static class Builder {

        private Context context;
        private String title, subtitle;
        private Drawable icon;
        private View.OnClickListener onClickListener;
        private View.OnLongClickListener onLongClickListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTitle(@StringRes int title) {
            this.title = context.getResources().getString(title);
            return this;
        }

        public Builder setSubtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public Builder setSubtitle(@StringRes int subtitle) {
            this.subtitle = context.getResources().getString(subtitle);
            return this;
        }

        public Builder setIcon(Drawable icon) {
            this.icon = icon;
            return this;
        }

        public Builder setIcon(@DrawableRes int icon) {
            this.icon = context.getResources().getDrawable(icon);
            return this;
        }

        public Builder setOnClickListener(View.OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
            return this;
        }

        public Builder setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
            this.onLongClickListener = onLongClickListener;
            return this;
        }

        public FunUBaseAboutItem build() {
            return new FunUBaseAboutItem(this);
        }

    }

}