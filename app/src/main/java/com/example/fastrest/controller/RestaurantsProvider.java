package com.example.fastrest.controller;

import com.example.fastrest.controller.entities.Restaurant;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsProvider {

    private ArrayList<Restaurant> restaurants;
    private Restaurant active;

    private RestaurantsProvider() {
        restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant();
//        restaurant.setBackgroundPicture(Picasso.get().load("").get());
        restaurant.setTitle("Pizza Od Ua");
        restaurant.setLocations(new LatLng[]{
                new LatLng(46.58152316777323, 30.791059293771895),
                new LatLng(46.44644310777506, 30.701651878018836),
                new LatLng(46.48028908098073, 30.742142655819144),
                new LatLng(46.3958146233272, 30.72362134313412),
                new LatLng(46.453787720577175, 30.745922297512703)});
        restaurant.setMarkerPicture("https://i.imgur.com/OhBBqq2.png");
        restaurant.setCompanyIcon("https://i.imgur.com/OhBBqq2.png");
        restaurants.add(restaurant);
        restaurant = new Restaurant();
        restaurant.setTitle("Melody Grill");
        restaurant.setLocations(new LatLng[]{ new LatLng(46.45058984552158, 30.753378357273554)});
        restaurants.add(restaurant);
        restaurants.add(new Restaurant("Облака", "https://i.imgur.com/yQnkwAO.jpg"));
        restaurants.add(new Restaurant("Дача", "https://i.imgur.com/wrOxu05.png"));
        restaurants.add(new Restaurant("Reef", "https://i.imgur.com/hHrhlfe.jpg"));
        restaurants.add(new Restaurant("Шаурма на Говорова", null));
        restaurants.add(new Restaurant("Mario's", "https://i.imgur.com/LUkbGVr.jpg"));
        restaurants.add(new Restaurant("Merry Berry", "https://i.imgur.com/W4bzGXm.jpg"));
        restaurants.add(new Restaurant("Mafia", "https://i.imgur.com/gKmPSMh.png"));
    }

    public List<Restaurant> getRestaurantsOnMap() {
        if (active != null) {
            List<Restaurant> list = new ArrayList<>();
            list.add(active);
            return list;
        }else {
            return restaurants;
        }
    }

    public void setActive(Restaurant active) {
        this.active = active;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }


    private static RestaurantsProvider instance;

    public static RestaurantsProvider getInstance() {
        if (instance == null)
            instance = new RestaurantsProvider();
        return instance;
    }

}
