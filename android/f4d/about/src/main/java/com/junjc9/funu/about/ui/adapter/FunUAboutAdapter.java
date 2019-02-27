package com.junjc9.funu.about.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import com.junjc9.funu.about.R;
import com.junjc9.funu.about.ui.item.FunUAboutItem;
import com.junjc9.funu.about.ui.item.FunUAuthorAboutItem;
import com.junjc9.funu.about.ui.item.FunUBaseAboutItem;
import com.junjc9.funu.about.ui.item.FunUHeaderAboutItem;
import com.junjc9.funu.about.ui.view.FunUIconView;
import com.junjc9.funu.about.utils.FunUMaterialDesignColorUtils;


/**
 *
 * File: FunUAboutAdapter.java
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

public final class FunUAboutAdapter extends RecyclerView.Adapter<FunUAboutAdapter.FunUViewHolder> {

    private Context context;
    private List<FunUAboutItem> aboutItemList;

    private final int ITEM_TYPE_HEADER = 0;
    private final int ITEM_TYPE_BASE = 1;
    private final int ITEM_TYPE_AUTHOR = 2;

    public FunUAboutAdapter(@NonNull Context context, List<FunUAboutItem> aboutItemList) {
        this.context = context;
        this.aboutItemList = aboutItemList;
    }

    class FunUViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout container;
        private TextView title, subtitle;
        private AppCompatImageView icon;

        FunUViewHolder(View view) {
            super(view);
            container = view.findViewById(R.id.item_container);
            title = view.findViewById(R.id.title);
            subtitle = view.findViewById(R.id.subtitle);
            icon = view.findViewById(R.id.icon);
        }
    }

    @Override
    public void onBindViewHolder(FunUViewHolder holder, int position) {
        FunUAboutItem aboutItem = aboutItemList.get(holder.getAdapterPosition());

        int color = FunUMaterialDesignColorUtils.getThemeAttrColor(context, "aboutCardBackground");
        if (color != 0) {
            int primaryColor = FunUMaterialDesignColorUtils.isDark(color) ? getClr(R.color.about_primary_text_color_dark) : getClr(R.color.about_primary_text_color_light);
            int secondaryColor = FunUMaterialDesignColorUtils.isDark(color) ? getClr(R.color.about_secondary_text_color_dark) : getClr(R.color.about_secondary_text_color_light);

            if (holder.icon instanceof FunUIconView)
                ((FunUIconView) holder.icon).setColor(secondaryColor);

            holder.title.setTextColor(primaryColor);
            holder.subtitle.setTextColor(secondaryColor);
        }

        if (aboutItem.getTitle()==null)
            holder.title.setVisibility(View.GONE);
        else holder.title.setText(aboutItem.getTitle());

        if (aboutItem.getSubtitle()==null)
            holder.subtitle.setVisibility(View.GONE);
        else holder.subtitle.setText(aboutItem.getSubtitle());

        if (aboutItem.getIcon()==null)
            holder.icon.setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
        else holder.icon.setImageDrawable(aboutItem.getIcon());

        if (aboutItem.getOnClickListener()!=null)
            holder.container.setOnClickListener(aboutItem.getOnClickListener());
        if (aboutItem.getOnLongClickListener()!=null)
            holder.container.setOnLongClickListener(aboutItem.getOnLongClickListener());
    }

    @Override
    public FunUViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout;

        if (viewType == ITEM_TYPE_HEADER)
            layout = R.layout.funu_about_header_item;
        else if (viewType == ITEM_TYPE_BASE)
            layout = R.layout.funu_about_base_item;
        else if (viewType == ITEM_TYPE_AUTHOR)
            layout = R.layout.funu_about_author_item;
        else layout = R.layout.funu_about_base_item;

        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new FunUViewHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        FunUAboutItem aboutItem = aboutItemList.get(position);

        if (aboutItem instanceof FunUHeaderAboutItem)
            return ITEM_TYPE_HEADER;
        else if (aboutItem instanceof FunUBaseAboutItem)
            return ITEM_TYPE_BASE;
        else if (aboutItem instanceof FunUAuthorAboutItem)
            return ITEM_TYPE_AUTHOR;
        else return ITEM_TYPE_BASE;
    }

    @Override
    public int getItemCount() {
        return aboutItemList.size();
    }

    private int getClr(int colorRes) {
        return context.getResources().getColor(colorRes);
    }

}
