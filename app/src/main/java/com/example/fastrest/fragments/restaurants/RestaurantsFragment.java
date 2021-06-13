package com.example.fastrest.fragments.restaurants;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fastrest.R;
import com.example.fastrest.controller.RestaurantsProvider;
import com.example.fastrest.controller.entities.Restaurant;

import java.util.List;

public class RestaurantsFragment extends Fragment implements RestaurantListAdapter.ItemClicked {

    private List<Restaurant> restaurantList;
    private RestaurantListAdapter adapter;
    private View root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_restaurants, container, false);
        restaurantList = RestaurantsProvider.getInstance().getRestaurants();
        RecyclerView recyclerView = root.findViewById(R.id.list);
        RestaurantListAdapter adapter = new RestaurantListAdapter(restaurantList, getContext(), getResources().getDisplayMetrics().density);
        recyclerView.setAdapter(adapter);
        adapter.setListener(this);
        return root;
    }

    @Override
    public void itemClicked(int position) {
        Navigation.findNavController(root).navigate(R.id.action_navigation_restaurants_to_navigation_menu);
    }
}