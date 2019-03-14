package com.asha.vr.plugins;

import com.asha.vr.model.MDHotspotBuilder;
import com.asha.vr.plugins.hotspot.MDSimpleHotspot;

/**
 * Created by hzqiujiadi on 16/8/2.
 * hzqiujiadi ashqalcn@gmail.com
 *
 * @deprecated MDHotspotPlugin
 *
 * Please use {@link MDSimpleHotspot} instead.
 */
@Deprecated
public class MDHotspotPlugin extends MDSimpleHotspot {

    public MDHotspotPlugin(MDHotspotBuilder builder) {
        super(builder);
    }
}
