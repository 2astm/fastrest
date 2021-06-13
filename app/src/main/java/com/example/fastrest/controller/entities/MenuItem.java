package com.example.fastrest.controller.entities;

import java.util.List;

public class MenuItem {

    private int id;

    private String title;

    private String logo;

    private List<String> ingredients;

    private float price;

    private float count;

    public MenuItem(int id, String title, String logo, List<String> ingredients, float price) {
        this.id = id;
        this.title = title;
        this.logo = logo;
        this.ingredients = ingredients;
        this.price = price;
    }

    public MenuItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }
}
