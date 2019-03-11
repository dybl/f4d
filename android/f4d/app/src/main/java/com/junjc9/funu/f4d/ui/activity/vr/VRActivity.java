package com.junjc9.funu.f4d.ui.activity.vr;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import com.junjc9.funu.f4d.R;
import com.junjc9.funu.f4d.model.PanoramaImageModel;
import com.junjc9.funu.f4d.ui.adapter.VRImageAdapter;
import com.junjc9.funu.f4d.utils.VRModelUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VRActivity extends AppCompatActivity {

    public VrPanoramaView vrPanoramaView;
    private RecyclerView recyclerView;

    private VRImageAdapter mAdapter;
    private int currPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_vr);


        initView();
        initListener();
    }

    private void initView() {
       
        //LoadImageFromAssets.colorImageViewDrawable(ivMine, R.color.transparent60_white);

        vrPanoramaView = findViewById(R.id.vrPanoramaView);
        vrPanoramaView.setTouchTrackingEnabled(true);
        vrPanoramaView.setFullscreenButtonEnabled(true);
        vrPanoramaView.setInfoButtonEnabled(false);
        vrPanoramaView.setStereoModeButtonEnabled(false);
        currPosition = new Random().nextInt(VRModelUtils.getPanoramaImageList().size());
        PanoramaImageModel model = VRModelUtils.getPanoramaImageList().get(currPosition);
        loadPanoramaImage(model);

        recyclerView = findViewById(R.id.vr_recyclerV);
        mAdapter = new VRImageAdapter(this, VRModelUtils.getPanoramaImageList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }

    private void initListener() {

        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            if (currPosition == position) return;
            currPosition = position;
            PanoramaImageModel model = mAdapter.getData().get(position);
            loadPanoramaImage(model);
        });
    }

    private void loadPanoramaImage(PanoramaImageModel model) {
        loadPanoramaImage(getBitmapFromAssets(model.assetName));
        //tvTitle.setText(model.title);
    }

    private void loadPanoramaImage(Bitmap bitmap) {
        if (bitmap == null) return;
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        options.inputType = VrPanoramaView.Options.TYPE_MONO;
        vrPanoramaView.loadImageFromBitmap(bitmap, options);
    }

    private Bitmap getBitmapFromAssets(String fileName) {
        if (TextUtils.isEmpty(fileName)) return null;
        try {
            InputStream inputStream = getAssets().open(fileName);
            return BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        vrPanoramaView.resumeRendering();
    }

    @Override
    protected void onPause() {
        super.onPause();
        vrPanoramaView.pauseRendering();
    }

    @Override
    protected void onDestroy() {
        vrPanoramaView.shutdown();
        super.onDestroy();
    }
}
