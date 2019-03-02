package com.junjc9.funu.f4d.ui.activity;

/*
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.danielstone.materialaboutlibrary.MaterialAboutActivity;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
//import com.danielstone.materialaboutlibrary.items.MaterialAboutItemOnClickAction;
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem;
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;

import com.junjc9.funu.f4d.R;


public class AboutActivity extends MaterialAboutActivity {

    public static void show(@NonNull Context context){
        Intent intent = new Intent(context, AboutActivity.class);
        context.startActivity(intent);
    }
    private boolean isAlive = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        isAlive = true;
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    protected MaterialAboutList getMaterialAboutList(@NonNull Context context) {
        MaterialAboutCard.Builder appBuilder = new MaterialAboutCard.Builder();
        buildApp(appBuilder, context);
        MaterialAboutCard.Builder authorBuilder = new MaterialAboutCard.Builder();
        buildAuthor(authorBuilder, context);
        MaterialAboutCard.Builder shareBuilder = new MaterialAboutCard.Builder();
        buildShare(shareBuilder, context);
        return new MaterialAboutList(appBuilder.build(), authorBuilder.build(), shareBuilder.build());
    }

    @Nullable
    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.about);
    }

    private void buildApp(MaterialAboutCard.Builder appBuilder, final Context context){
        appBuilder.addItem(new MaterialAboutTitleItem.Builder()
                .text(getString(R.string.app_name))
                .desc(getString(R.string.splash_copyright))
                .icon(R.mipmap.ic_launcher_round)
                .build());
        appBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.version)
                .icon(R.drawable.ic_menu_about)
                .build());
        appBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.source_code)
                .subText(R.string.source_code_wishes)
                .icon(R.drawable.ic_code)
                .build());
    }

    private void buildAuthor(MaterialAboutCard.Builder appBuilder, final Context context){
        appBuilder.title(R.string.author);
        appBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.author_name)
                .subText(R.string.author_location)
                .icon(R.drawable.ic_menu_person)
                .build());
        appBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.follow_on_github)
                .icon(R.drawable.ic_github)
                .build());
        appBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.email)
                .subText(R.string.auth_email_address)
                .icon(R.drawable.ic_email)
                .build());
    }

    private void buildShare(MaterialAboutCard.Builder appBuilder, final Context context) {
        appBuilder.title(R.string.feedback_and_share);
        appBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.share_to_friends)
                .icon(R.drawable.ic_menu_share)
                .build());
        appBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.rate_in_market)
                .icon(R.drawable.ic_menu_star)
                .build());
        appBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.feedback)
                .icon(R.drawable.ic_menu_feedback)
                .build());
    }


}
*/
