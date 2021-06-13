package com.example.fastrest.fragments.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fastrest.R;
import com.example.fastrest.controller.MenuProvider;
import com.example.fastrest.controller.entities.MenuItem;

import java.util.List;

public class MenuFragment extends Fragment {

    private View root;
    private MenuListAdapter menuAdapter;
    private static final String TAG = "MenuFragment";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "created");
        root = inflater.inflate(R.layout.fragment_menu, container, false);
        List<MenuItem> items = MenuProvider.getInstance().getItems();
        menuAdapter = new MenuListAdapter(items, requireContext(), getResources().getDisplayMetrics().density);
        RecyclerView recyclerView = root.findViewById(R.id.list);
        recyclerView.setAdapter(menuAdapter);
        return root;
    }
}