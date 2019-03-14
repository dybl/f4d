package com.asha.vr.strategy.projection;

import com.asha.vr.model.MDPosition;
import com.asha.vr.objects.MDAbsObject3D;

/**
 * Created by hzqiujiadi on 16/6/25.
 * hzqiujiadi ashqalcn@gmail.com
 */
public interface IProjectionMode {
    MDAbsObject3D getObject3D();
    MDPosition getModelPosition();
}
