package com.junjc9.funu.f4d.ui.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.junjc9.funu.f4d.R;
import com.junjc9.funu.f4d.utils.PackageUtils;
import com.junjc9.funu.f4d.utils.ResUtils;

public class SettingFragment extends Fragment {

    private TextView tv_app_version;

    public static SettingFragment newInstance() {
        SettingFragment fg = new SettingFragment();
        return fg;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        tv_app_version = view.findViewById(R.id.tv_app_version);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String version = PackageUtils.packageName();
        if(version != null) {
            String msg = String.format(ResUtils.getString(R.string.cur_version), version);
            tv_app_version.setText(msg);
        }
    }
}