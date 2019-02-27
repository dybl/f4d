package com.junjc9.funu.about.ui.item;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * File: FunUAboutCard.java
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

public final class FunUAboutCard {

    private List<FunUAboutItem> aboutItemList;
    private String title;
    private int titleColor = 0;

    private FunUAboutCard(FunUAboutCard.Builder builder) {
        aboutItemList = builder.aboutItemList;
        title = builder.title;
        titleColor = builder.titleColor;
    }

    public List<FunUAboutItem> getAboutItemList() {
        return aboutItemList;
    }

    public String getTitle() {
        return title;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public static class Builder {

        private Context context;
        private String title;
        private int titleColor = 0;

        private List<FunUAboutItem> aboutItemList;

        public Builder(Context context) {
            this.context = context;
            aboutItemList = new ArrayList<>();
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTitle(@StringRes int title) {
            this.title = context.getResources().getString(title);
            return this;
        }

        public Builder setTitleColor(@ColorInt int titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        public Builder setTitleColorRes(@ColorRes int titleColorRes) {
            this.titleColor = context.getResources().getColor(titleColorRes);
            return this;
        }

        public Builder addItem(FunUAboutItem aboutItem) {
            aboutItemList.add(aboutItem);
            return this;
        }

        public Builder addItem(FunUHeaderAboutItem.Builder builder) {
            aboutItemList.add(builder.build());
            return this;
        }

        public Builder addItem(FunUBaseAboutItem.Builder builder) {
            aboutItemList.add(builder.build());
            return this;
        }

        public FunUAboutCard build() {
            return new FunUAboutCard(this);
        }
    }

}

