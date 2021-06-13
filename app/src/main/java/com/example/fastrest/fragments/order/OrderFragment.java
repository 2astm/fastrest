package com.example.fastrest.fragments.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fastrest.R;
import com.example.fastrest.controller.OrderProvider;
import com.example.fastrest.controller.entities.MenuItem;

import java.util.List;


public class OrderFragment extends Fragment {

    private List<MenuItem> items;
    private OrderListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_order, container, false);
        items = OrderProvider.getInstance().getItems();
        RecyclerView recyclerView = root.findViewById(R.id.list);
        adapter = new OrderListAdapter(items, requireContext(), getResources().getDisplayMetrics().density);
        recyclerView.setAdapter(adapter);
        return root;
    }
}