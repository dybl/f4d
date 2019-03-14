package com.junjc9.vr.plugins.hotspot;

import com.junjc9.vr.model.MDHitEvent;
import com.junjc9.vr.model.MDHitPoint;
import com.junjc9.vr.model.MDRay;

/**
 * Created by hzqiujiadi on 16/8/5.
 * hzqiujiadi ashqalcn@gmail.com
 */
public interface IMDHotspot {
    MDHitPoint hit(MDRay ray);

    void onEyeHitIn(MDHitEvent hitEvent);

    /**
     * @param timestamp down timestamp
     * */
    void onEyeHitOut(long timestamp);

    void onTouchHit(MDRay ray);

    String getTitle();

    String getTag();

    void rotateToCamera();
}
