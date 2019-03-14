package com.asha.vr.model;

import com.asha.vr.MDvrrary;

/**
 * Created by hzqiujiadi on 2017/4/12.
 * hzqiujiadi ashqalcn@gmail.com
 */

public class MDPluginBuilder {

    public float width = 2;

    public float height = 2;

    public String tag;

    public String title;

    public MDvrrary.ITouchPickListener clickListener;

    public MDPosition position;

    public MDPluginBuilder() {
    }

    public MDPluginBuilder title(String title){
        this.title = title;
        return this;
    }

    public MDPluginBuilder size(float width, float height){
        this.width = width;
        this.height = height;
        return this;
    }

    public MDPluginBuilder position(MDPosition position) {
        this.position = position;
        return this;
    }

    public MDPluginBuilder listenClick(MDvrrary.ITouchPickListener listener){
        this.clickListener = listener;
        return this;
    }

    public MDPluginBuilder tag(String tag) {
        this.tag = tag;
        return this;
    }
}
