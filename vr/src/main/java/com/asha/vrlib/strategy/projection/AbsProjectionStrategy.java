package com.asha.vr.strategy.projection;

import android.content.Context;

import com.asha.vr.MD360DirectorFactory;
import com.asha.vr.model.MDMainPluginBuilder;
import com.asha.vr.plugins.MDAbsPlugin;
import com.asha.vr.strategy.IModeStrategy;

/**
 * Created by hzqiujiadi on 16/6/25.
 * hzqiujiadi ashqalcn@gmail.com
 */
public abstract class AbsProjectionStrategy implements IModeStrategy, IProjectionMode {

    @Override
    public void onResume(Context context) {

    }

    @Override
    public void onPause(Context context) {

    }

    protected MD360DirectorFactory hijackDirectorFactory(){ return null; }

    abstract MDAbsPlugin buildMainPlugin(MDMainPluginBuilder builder);
}
