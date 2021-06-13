package com.example.fastrest.fragments.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastrest.R;
import com.example.fastrest.controller.entities.MenuItem;
import com.example.fastrest.fragments.menu.MenuListAdapter;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder>{
    private List<MenuItem> menuItems;
    private LayoutInflater layoutInflater;
    private float density;

    public OrderListAdapter(List<MenuItem> menuItems, Context context, float density) {
        this.menuItems = menuItems;
        this.layoutInflater = LayoutInflater.from(context);
        this.density = density;
    }

    @NonNull
    @Override
    public OrderListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_menu_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        MenuItem item = menuItems.get(position);
        Picasso.get().load(item.getLogo())
                .placeholder(R.drawable.outline_ramen_dining_white_24)
                .error(R.drawable.outline_ramen_dining_white_24)
                .into(holder.menuLogo);
        holder.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView menuLogo;
        TextView title;
        ImageView buyButton;
        TextView price;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            menuLogo = itemView.findViewById(R.id.item_menu_logo);
            title = itemView.findViewById(R.id.title);
            buyButton = itemView.findViewById(R.id.buy);
            price = itemView.findViewById(R.id.count);
        }
    }
}
