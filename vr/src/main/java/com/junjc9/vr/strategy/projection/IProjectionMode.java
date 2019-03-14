package com.junjc9.vr.strategy.projection;

import com.junjc9.vr.model.MDPosition;
import com.junjc9.vr.objects.MDAbsObject3D;

/**
 * Created by hzqiujiadi on 16/6/25.
 * hzqiujiadi ashqalcn@gmail.com
 */
public interface IProjectionMode {
    MDAbsObject3D getObject3D();
    MDPosition getModelPosition();
}
