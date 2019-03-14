package com.asha.vr.compact;

import com.asha.vr.MDvrrary;
import com.asha.vr.MDvrrary.ITouchPickListener2;
import com.asha.vr.model.MDHitEvent;

/**
 * Created by hzqiujiadi on 2017/4/20.
 * hzqiujiadi ashqalcn@gmail.com
 */

public class CompactTouchPickAdapter implements ITouchPickListener2 {

    private final MDvrrary.ITouchPickListener listener;

    public CompactTouchPickAdapter(MDvrrary.ITouchPickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onHotspotHit(MDHitEvent hitEvent) {
        if (listener != null){
            listener.onHotspotHit(hitEvent.getHotspot(), hitEvent.getRay());
        }
    }
}
