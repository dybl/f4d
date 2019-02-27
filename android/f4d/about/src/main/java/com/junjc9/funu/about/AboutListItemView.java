package com.junjc9.funu.about;


import android.content.Context;
import androidx.core.view.ViewCompat;
import androidx.cardview.widget.CardView;
//import androidx.widget.DefaultItemAnimator;
//import androidx.appcompat.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @MarcosCGdev on 19/02/2018.
 */

final class AboutListItemView extends RelativeLayout {

    private List<AboutItem> aboutItemList;
    private EasyAboutAdapter easyAboutAdapter;

    AboutListItemView(Context context, String title, int titleColor) {
        super(context);
        init(context, title, titleColor);
    }

    AboutListItemView(Context context, AttributeSet attrs, String title, int titleColor) {
        super(context, attrs);
        init(context, title, titleColor);
    }

    AboutListItemView(Context context, AttributeSet attrs, int defStyle, String title, int titleColor) {
        super(context, attrs, defStyle);
        init(context, title, titleColor);
    }

    private void init(Context context, String title, int titleColor) {
        inflate(getContext(), R.layout.ea_card_list, this);
        aboutItemList = new ArrayList<>();
        easyAboutAdapter = new EasyAboutAdapter(context, aboutItemList);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setNestedScrollingEnabled(false);
        ViewCompat.setNestedScrollingEnabled(recyclerView, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(easyAboutAdapter);
        TextView titleTv = findViewById(R.id.card_title);
        if (titleColor==0)
            titleColor = ColorUtils.getThemeAccentColor(context);
        titleTv.setTextColor(titleColor);
        if (title==null)
            titleTv.setVisibility(GONE);
        else titleTv.setText(title);

        int cardColor = ColorUtils.getThemeAttrColor(context, "aboutCardBackground");
        if (cardColor!= 0)
            ((CardView) findViewById(R.id.card_view)).setCardBackgroundColor(cardColor);
    }

    void addItem(AboutItem aboutItem) {
        aboutItemList.add(aboutItem);
        easyAboutAdapter.notifyDataSetChanged();
    }

    void addItems(List<AboutItem> aboutItems) {
        aboutItemList.addAll(aboutItems);
        easyAboutAdapter.notifyDataSetChanged();
    }

}
