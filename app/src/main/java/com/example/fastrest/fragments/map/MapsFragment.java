package com.example.fastrest.fragments.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fastrest.R;
import com.example.fastrest.controller.RestaurantsProvider;
import com.example.fastrest.helpers.PicassoMarker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapsFragment extends Fragment implements OnMapReadyCallback {


    private static final String TAG = "MapsFragment";
    private RestaurantsProvider restaurantsProvider;
    private List<PicassoMarker> picassoMarkerList;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        picassoMarkerList = new ArrayList<>();
        Picasso.get().setLoggingEnabled(true);
        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(requireContext(), R.raw.map_night_style));
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng odessa = new LatLng(46.4825, 30.7233);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(odessa, 10));
        restaurantsProvider.getRestaurants().forEach((restaurant) -> {
            MarkerOptions restMarkerOptions = new MarkerOptions();
            restMarkerOptions
                    .title(restaurant.getTitle());
            if (restaurant.getLocations() != null)
                Arrays.stream(restaurant.getLocations()).forEach(position -> {
                    Marker marker = googleMap.addMarker(restMarkerOptions.position(position));
                    PicassoMarker pcMarker = new PicassoMarker(marker);
                    picassoMarkerList.add(pcMarker);
                    Picasso.get()
                            .load(restaurant.getMarkerPicture())
                            .placeholder(R.drawable.outline_dining_white_24)
                            .error(R.drawable.outline_dining_white_24)
                            .resize((int) (24 * getResources().getDisplayMetrics().density), (int) (24 * getResources().getDisplayMetrics().density))
                            .into(pcMarker);
    //                Log.d(TAG, restaurant.getMarkerPicture());
                });
        });
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.restaurantsProvider = RestaurantsProvider.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }
}