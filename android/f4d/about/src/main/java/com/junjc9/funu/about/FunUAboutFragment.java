package com.junjc9.funu.about;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.junjc9.funu.about.ui.item.FunUAboutCard;
import com.junjc9.funu.about.FunUAboutListItemView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.widget.NestedScrollView;


/**
 *
 * File: FunUAboutFragment.java
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

public abstract class FunUAboutFragment extends Fragment {

    private View rootView;
    private List<FunUAboutCard> aboutCardList;
    private LinearLayout mainView;
    private NestedScrollView scrollView;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.funu_fragment_about, container, false);

        aboutCardList = new ArrayList<>();

        mainView = rootView.findViewById(R.id.main_view);
        scrollView = rootView.findViewById(R.id.scroll_view);

        configureFragment(getContext(), rootView, savedInstanceState);

        return rootView;
    }

    protected abstract void configureFragment(Context context, View rootView, Bundle savedInstanceState);

    public void addCard(FunUAboutCard aboutCard) {
        FunUAboutListItemView aboutItemView = new FunUAboutListItemView(getContext(), aboutCard.getTitle(), aboutCard.getTitleColor());
        aboutItemView.addItems(aboutCard.getAboutItemList());
        mainView.addView(aboutItemView);
    }

    public NestedScrollView getScrollView() {
        return scrollView;
    }
}
