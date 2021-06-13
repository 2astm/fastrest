package com.example.fastrest.fragments.restaurants;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastrest.R;
import com.example.fastrest.controller.entities.Restaurant;
import com.example.fastrest.helpers.PicassoMarker;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.ViewHolder> {

    private List<Restaurant> restaurantList;
    private LayoutInflater layoutInflater;
    private float density;
    private ItemClicked listener;

    public RestaurantListAdapter(List<Restaurant> restaurantList, Context context, float density) {
        this.restaurantList = restaurantList;
        this.layoutInflater = LayoutInflater.from(context);
        this.density = density;
    }

    public void setListener(ItemClicked listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_restaurant, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(v -> {
            if (listener != null)
                listener.itemClicked(vh.getAdapterPosition());
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);
        if (restaurant.getCompanyIcon() != null)
            Picasso.get()
                    .load(restaurant.getCompanyIcon())
                    .placeholder(R.drawable.outline_storefront_24)
                    .error(R.drawable.outline_storefront_24)
                    .resize((int)(65 * density) , (int)(65 * density))
                    .into(holder.icon);
        else
            holder.icon.setImageResource(R.drawable.outline_storefront_24);
        holder.title.setText(restaurant.getTitle());
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView icon;
        protected TextView title;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.logo);
            title = itemView.findViewById(R.id.title);
        }
    }

    public static interface ItemClicked {
        void itemClicked(int position);
    }
}
