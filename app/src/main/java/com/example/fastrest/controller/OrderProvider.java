package com.example.fastrest.controller;

import com.example.fastrest.controller.entities.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderProvider {

    private List<MenuItem> menuItems;

    private OrderProvider() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(0, "Альфредо Блю Чиз", "https://i.imgur.com/f5jANFA.png", Arrays.asList("Дор блю", "Моцарелла", "Фета", "лук", "орегано", "перец Гриль", "руккола", "сливочный соус Альфредо (основа)", "чеснок"), 100));
        menuItems.add(new MenuItem(1, "Ковбойская", "https://i.imgur.com/UyjIpJe.png", Arrays.asList("Моцарелла", "баварские колбаски", "бекон", "лук", "огурец маринованный", "чесночный соус (основа)", "шампиньоны"),100));
        menuItems.add(new MenuItem(2, "Цезарь", "https://i.imgur.com/pVLJH63.png", Arrays.asList("Моцарелла", "Пармезан", "без лука", "бекон", "курица гриль", "салат Айсберг", "соус Цезарь", "томати \"Черрі\"", "томатный соус (основа)"), 100));
        menuItems.add(new MenuItem(3, "4 сыра", "https://i.imgur.com/rQNdhhH.png", Arrays.asList("Дор блю", "Моцарелла", "Пармезан", "Чеддер", "сливочный соус Альфредо (основа)"), 100));
        menuItems.add(new MenuItem(4, "Тоскана", "https://i.imgur.com/HXUUyPg.png", Arrays.asList("Дор блю", "Моцарелла", "салями Пепперони", "чесночный соус (основа)"), 100));
        menuItems.add(new MenuItem(5, "Супер Мясная", "https://i.imgur.com/pliLJuh.png", Arrays.asList("Мит Болл", "Моцарелла", "ветчина", "говядина", "итальянские колбаски", "курица гриль", "салями Пепперони", "томатный соус (основа)"), 100));
    }

    public List<MenuItem> getItems() {
        return menuItems;
    }

    private static OrderProvider instance;

    public static OrderProvider getInstance() {
        if (instance == null)
            instance = new OrderProvider();
        return instance;
    }
}
