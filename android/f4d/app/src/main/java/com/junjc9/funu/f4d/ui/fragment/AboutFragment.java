package com.junjc9.funu.f4d.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.junjc9.funu.about.FunUAboutFragment;
import com.junjc9.funu.about.ui.item.FunUAboutCard;
import com.junjc9.funu.about.ui.item.FunUAuthorAboutItem;
import com.junjc9.funu.about.ui.item.FunUBaseAboutItem;
import com.junjc9.funu.about.utils.FunUAboutItemBuilder;
import com.junjc9.funu.f4d.R;


public class AboutFragment extends FunUAboutFragment {

    @Override
    protected void configureFragment(final Context context, View rootView, Bundle savedInstanceState) {
        addCard(new FunUAboutCard.Builder(context)
                .addItem(FunUAboutItemBuilder.generateAppTitleItem(context)
                        .setSubtitle("by @MarcosCGdev."))
                .addItem(FunUAboutItemBuilder.generateAppVersionItem(context, true)
                        .setIcon(R.drawable.ic_menu_about))
                /*.addItem(new FunUBaseAboutItem.Builder(context)
                        .setTitle("Licenses")
                        .setIcon(R.drawable.ic_description_black_24dp)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                DemoUtils.showLicensesDialog(context);
                            }
                        })
                        .build())*/
                .build());

        addCard(new FunUAboutCard.Builder(context)
                .setTitle("Author")
                .addItem(new FunUAuthorAboutItem.Builder(context)
                        .setTitle("Marcos Calvo García")
                        .setSubtitle("Zaragoza, Spain.")
                        .setIcon(R.drawable.ic_menu_person)
                        .build())
                .addItem(FunUAboutItemBuilder.generateLinkItem(context, "https://github.com/dybl/face4d")
                        .setTitle("Fork on GitHub")
                        .setIcon(R.drawable.ic_github))
                .addItem(FunUAboutItemBuilder.generateLinkItem(context, "https://blog.funu.junjc9.com")
                        .setTitle("Visit my website")
                        .setIcon(R.drawable.ic_chrome))
                .addItem(FunUAboutItemBuilder.generateEmailItem(context, "junjc9@gmail.com")
                        .setTitle("Send me an email")
                        .setIcon(R.drawable.ic_email))
                .build());

        addCard(new FunUAboutCard.Builder(context)
                .setTitle("Support")
                .addItem(FunUAboutItemBuilder.generatePlayStoreItem(context)
                        .setTitle("Rate application")
                        .setIcon(R.drawable.ic_menu_star))
                .addItem(FunUAboutItemBuilder.generateLinkItem(context, "https://github.com/marcoscgdev/EasyAbout/issues/new")
                        .setTitle("Report bugs")
                        .setIcon(R.drawable.ic_bug_report))
                .addItem(new FunUBaseAboutItem.Builder(context)
                        .setTitle("Clickable item")
                        .setSubtitle("This item has onClick and onLongClick listener.")
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(context, "onClick", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View view) {
                                Toast.makeText(context, "onLongClick", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        })
                        .setIcon(R.drawable.ic_mouse)
                        .build())
                .build());
    }
}
