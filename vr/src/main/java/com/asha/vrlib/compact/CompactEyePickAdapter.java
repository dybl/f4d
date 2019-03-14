package com.asha.vr.compact;

import com.asha.vr.MDvrrary;
import com.asha.vr.model.MDHitEvent;

/**
 * Created by hzqiujiadi on 2017/4/20.
 * hzqiujiadi ashqalcn@gmail.com
 */

public class CompactEyePickAdapter implements MDvrrary.IEyePickListener2 {

    private final MDvrrary.IEyePickListener listener;

    public CompactEyePickAdapter(MDvrrary.IEyePickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onHotspotHit(MDHitEvent hitEvent) {
        if (listener != null){
            listener.onHotspotHit(hitEvent.getHotspot(), hitEvent.getTimestamp());
        }
    }
}
