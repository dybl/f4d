package com.junjc9.vr.strategy.projection;

import android.app.Activity;

import com.junjc9.vr.model.MDMainPluginBuilder;
import com.junjc9.vr.model.MDPosition;
import com.junjc9.vr.objects.MDAbsObject3D;
import com.junjc9.vr.objects.MDObject3DHelper;
import com.junjc9.vr.objects.MDSphere3D;
import com.junjc9.vr.plugins.MDAbsPlugin;
import com.junjc9.vr.plugins.MDPanoramaPlugin;

/**
 * Created by hzqiujiadi on 16/6/25.
 * hzqiujiadi ashqalcn@gmail.com
 */
public class SphereProjection extends AbsProjectionStrategy {

    private MDAbsObject3D object3D;

    public SphereProjection() {

    }

    @Override
    public MDAbsObject3D getObject3D() {
        return object3D;
    }

    @Override
    public MDPosition getModelPosition() {
        return MDPosition.getOriginalPosition();
    }

    @Override
    public void turnOnInGL(Activity activity) {
        object3D = new MDSphere3D();
        MDObject3DHelper.loadObj(activity, object3D);
    }

    @Override
    public void turnOffInGL(Activity activity) {
    }

    @Override
    public boolean isSupport(Activity activity) {
        return true;
    }

    @Override
    public MDAbsPlugin buildMainPlugin(MDMainPluginBuilder builder) {
        return new MDPanoramaPlugin(builder);
    }
}
