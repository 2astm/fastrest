package com.example.fastrest.helpers;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.example.fastrest.ImageHelper;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.lang.ref.WeakReference;

public class PicassoMarker implements Target {
    private final static String TAG = "PicassoMarker";
    private final Marker marker;

    public PicassoMarker(Marker marker) {
        this.marker = marker;
    }


    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        Log.d(TAG, "bitmap loaded");
        marker.setIcon(BitmapDescriptorFactory.fromBitmap(bitmap));
    }

    @Override
    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
        Log.d(TAG, "Bitmap Failed");
        if (errorDrawable != null)
            marker.setIcon(BitmapDescriptorFactory.fromBitmap(ImageHelper.drawableToBitmap(errorDrawable)));
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {
        Log.d(TAG, "Prepare load");
        if (placeHolderDrawable != null)
            marker.setIcon(BitmapDescriptorFactory.fromBitmap(ImageHelper.drawableToBitmap(placeHolderDrawable)));
    }
}
