package com.junjc9.funu.f4d.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 *
 * File: VRFragmentPagerItem.java
 *
 * Created by @junjc9 on 03/03/2019.
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

public class VRFragmentPagerItem  {

    private String title;
    private Fragment fragment;
    private Class<? extends Fragment> clazz;
    private Bundle args;

    protected VRFragmentPagerItem(String title, @NonNull Fragment fragment) {
        this(title, fragment.getClass(), fragment.getArguments());
        this.fragment = fragment;
    }

    protected VRFragmentPagerItem(String title, Class<? extends Fragment> clazz, Bundle args) {
        this.title = title;
        this.clazz = clazz;
        this.args = args;
    }

    public static VRFragmentPagerItem create(String title, @NonNull Fragment fragment) {
        return new VRFragmentPagerItem(title, fragment);
    }

    public static VRFragmentPagerItem create(String title, Class<? extends Fragment> clazz) {
        return create(title, clazz, null);
    }

    public static VRFragmentPagerItem create(String title, Class<? extends Fragment> clazz, Bundle args) {
        return new VRFragmentPagerItem(title, clazz, args);
    }

    public String getPageTitle() {
        return title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public Fragment newInstance(Context context) {
        return Fragment.instantiate(context, clazz.getName(), args);
    }

    public Bundle getArgs() {
        return args;
    }


}
