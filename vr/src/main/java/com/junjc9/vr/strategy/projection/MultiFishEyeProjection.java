package com.junjc9.vr.strategy.projection;

import com.junjc9.vr.common.MDDirection;
import com.junjc9.vr.model.MDMainPluginBuilder;
import com.junjc9.vr.plugins.MDAbsPlugin;
import com.junjc9.vr.plugins.MDMultiFishEyePlugin;

/**
 * Created by hzqiujiadi on 16/7/29.
 * hzqiujiadi ashqalcn@gmail.com
 */
public class MultiFishEyeProjection extends SphereProjection {

    private float radius;
    private MDDirection direction;

    public MultiFishEyeProjection(float radius, MDDirection direction) {
        this.radius = radius;
        this.direction = direction;
    }

    @Override
    public MDAbsPlugin buildMainPlugin(MDMainPluginBuilder builder) {
        return new MDMultiFishEyePlugin(builder, radius, direction);
    }
}
