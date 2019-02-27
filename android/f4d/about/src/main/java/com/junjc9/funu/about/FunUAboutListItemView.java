package com.junjc9.funu.about;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.junjc9.funu.about.R;
import com.junjc9.funu.about.ui.adapter.FunUAboutAdapter;
import com.junjc9.funu.about.ui.item.FunUAboutItem;
import com.junjc9.funu.about.utils.FunUMaterialDesignColorUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 *
 * File: FunUAboutListItemView.java
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
final class FunUAboutListItemView extends RelativeLayout {

    private List<FunUAboutItem> aboutItemList;
    private FunUAboutAdapter AboutAdapter;

    FunUAboutListItemView(Context context, String title, int titleColor) {
        super(context);
        init(context, title, titleColor);
    }

    FunUAboutListItemView(Context context, AttributeSet attrs, String title, int titleColor) {
        super(context, attrs);
        init(context, title, titleColor);
    }

    FunUAboutListItemView(Context context, AttributeSet attrs, int defStyle, String title, int titleColor) {
        super(context, attrs, defStyle);
        init(context, title, titleColor);
    }

    private void init(Context context, String title, int titleColor) {
        inflate(getContext(), R.layout.funu_card_list, this);
        aboutItemList = new ArrayList<>();
        AboutAdapter = new FunUAboutAdapter(context, aboutItemList);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setNestedScrollingEnabled(false);
        ViewCompat.setNestedScrollingEnabled(recyclerView, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(AboutAdapter);
        TextView titleTv = findViewById(R.id.card_title);
        if (titleColor==0)
            titleColor = FunUMaterialDesignColorUtils.getThemeAccentColor(context);
        titleTv.setTextColor(titleColor);
        if (title==null)
            titleTv.setVisibility(GONE);
        else titleTv.setText(title);

        int cardColor = FunUMaterialDesignColorUtils.getThemeAttrColor(context, "aboutCardBackground");
        if (cardColor!= 0)
            ((CardView) findViewById(R.id.card_view)).setCardBackgroundColor(cardColor);
    }

    void addItem(FunUAboutItem aboutItem) {
        aboutItemList.add(aboutItem);
        AboutAdapter.notifyDataSetChanged();
    }

    void addItems(List<FunUAboutItem> aboutItems) {
        aboutItemList.addAll(aboutItems);
        AboutAdapter.notifyDataSetChanged();
    }

}
