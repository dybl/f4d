package com.junjc9.vr.strategy.projection;

import android.content.Context;

import com.junjc9.vr.MD360DirectorFactory;
import com.junjc9.vr.model.MDMainPluginBuilder;
import com.junjc9.vr.plugins.MDAbsPlugin;
import com.junjc9.vr.strategy.IModeStrategy;

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
