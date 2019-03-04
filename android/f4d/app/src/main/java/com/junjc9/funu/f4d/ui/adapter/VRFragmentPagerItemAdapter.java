package com.junjc9.funu.f4d.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.junjc9.funu.f4d.ui.fragment.VRFragmentPagerItem;
/**
 *
 * File: VRVRFragmentPagerItemAdapter.java
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


public class VRVRFragmentPagerItemAdapter extends FragmentPagerAdapter {

    private Context context;
    private List<VRFragmentPagerItem> items;
    private SparseArray<Fragment> fragments = new SparseArray<>();
    private OnInstantiateFragmentListener listener;

    private VRFragmentPagerItemAdapter(Context context, FragmentManager fragmentManager, List<VRFragmentPagerItem> items) {
        super(fragmentManager);
        this.context = context;
        this.items = items;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        fragments.put(position, fragment);
        if (listener != null) {
            listener.onInstantiate(position, fragment, items.get(position).getArgs());
        }
        return fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return items.get(position).newInstance(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        fragments.remove(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public Fragment getFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public String getPageTitle(int position) {
        return items.get(position).getPageTitle();
    }

    public void setOnInstantiateFragmentListener(OnInstantiateFragmentListener listener) {
        this.listener = listener;
    }

    public interface OnInstantiateFragmentListener {
        void onInstantiate(int position, Fragment fragment, Bundle args);
    }

    public static class Builder {

        private Context context;
        private FragmentManager fragmentManager;
        private List<VRFragmentPagerItem> items = new ArrayList<>();

        public Builder(Context context, FragmentManager fragmentManager) {
            this.context = context;
            this.fragmentManager = fragmentManager;
        }

        public Builder add(VRFragmentPagerItem item) {
            items.add(item);
            return this;
        }

        public Builder add(int resId, Fragment fragment) {
            return add(context.getString(resId), fragment);
        }

        public Builder add(int resId, Class<? extends Fragment> clazz) {
            return add(context.getString(resId), clazz);
        }

        public Builder add(int resId, Class<? extends Fragment> clazz, Bundle args) {
            return add(context.getString(resId), clazz, args);
        }

        public Builder add(String title, Fragment fragment) {
            return add(VRFragmentPagerItem.create(title, fragment));
        }

        public Builder add(String title, Class<? extends Fragment> clazz) {
            return add(VRFragmentPagerItem.create(title, clazz));
        }

        public Builder add(String title, Class<? extends Fragment> clazz, Bundle args) {
            return add(VRFragmentPagerItem.create(title, clazz, args));
        }

        public VRFragmentPagerItemAdapter build() {
            return new VRFragmentPagerItemAdapter(context, fragmentManager, items);
        }
    }
}
