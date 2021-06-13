package com.example.fastrest.fragments.menu;

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
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.ViewHolder> {

    private List<MenuItem> menuItems;
    private LayoutInflater layoutInflater;
    private float density;

    public MenuListAdapter(List<MenuItem> menuItems, Context context, float density) {
        this.menuItems = menuItems;
        this.layoutInflater = LayoutInflater.from(context);
        this.density = density;
    }
    

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_menu, parent, false);
        return new MenuListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuItem menuItem = menuItems.get(position);
        Picasso.get().load(menuItem.getLogo())
                .placeholder(R.drawable.outline_ramen_dining_white_24)
                .error(R.drawable.outline_ramen_dining_white_24)
                .resize((int) density * 64, (int) density * 64)
                .into(holder.menuLogo);
        holder.title.setText(menuItem.getTitle());
        holder.ingredients.setText(menuItem.getIngredients().toString());
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView menuLogo;
        TextView title;
        ImageView buyButton;
        TextView ingredients;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            menuLogo = itemView.findViewById(R.id.item_menu_logo);
            title = itemView.findViewById(R.id.title);
            buyButton = itemView.findViewById(R.id.buy);
            ingredients = itemView.findViewById(R.id.count);
        }
    }
}
