package com.junjc9.vr.strategy.projection;

import android.app.Activity;
import android.graphics.RectF;

import com.junjc9.vr.model.MDMainPluginBuilder;
import com.junjc9.vr.model.MDPosition;
import com.junjc9.vr.objects.MDAbsObject3D;
import com.junjc9.vr.objects.MDDome3D;
import com.junjc9.vr.objects.MDObject3DHelper;
import com.junjc9.vr.plugins.MDAbsPlugin;
import com.junjc9.vr.plugins.MDPanoramaPlugin;

/**
 * Created by hzqiujiadi on 16/6/25.
 * hzqiujiadi ashqalcn@gmail.com
 */
public class DomeProjection extends AbsProjectionStrategy {

    MDAbsObject3D object3D;

    private float mDegree;

    private boolean mIsUpper;

    private RectF mTextureSize;

    public DomeProjection(RectF textureSize, float degree, boolean isUpper) {
        this.mTextureSize = textureSize;
        this.mDegree = degree;
        this.mIsUpper = isUpper;
    }

    @Override
    public void turnOnInGL(Activity activity) {
        object3D = new MDDome3D(mTextureSize, mDegree, mIsUpper);
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
    public MDAbsObject3D getObject3D() {
        return object3D;
    }

    @Override
    public MDPosition getModelPosition() {
        return MDPosition.getOriginalPosition();
    }

    @Override
    public MDAbsPlugin buildMainPlugin(MDMainPluginBuilder builder) {
        return new MDPanoramaPlugin(builder);
    }
}
