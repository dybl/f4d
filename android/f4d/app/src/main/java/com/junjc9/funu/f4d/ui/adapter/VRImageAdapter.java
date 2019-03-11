package com.junjc9.funu.f4d.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.junjc9.funu.f4d.R;
import com.junjc9.funu.f4d.model.PanoramaImageModel;

import java.util.List;

/**
 * @author sunfusheng on 2017/8/25.
 */
public class VRImageAdapter extends BaseMultiItemQuickAdapter<PanoramaImageModel, BaseViewHolder> {

    private Context context;

    public VRImageAdapter(Context context, List<PanoramaImageModel> data) {
        super(data);
        this.context = context;
        addItemType(0, R.layout.item_vr_image);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    @Override
    protected void convert(BaseViewHolder helper, PanoramaImageModel item) {
        helper.setText(R.id.tv_title, item.title);
        helper.setText(R.id.tv_desc, item.desc);
        helper.setImageResource(R.id.imageView, item.resourceName);
    }

}
