package com.example.fastrest.controller;

import com.example.fastrest.controller.entities.MenuItem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuProvider {

    private List<MenuItem> menuItems;

    private MenuProvider() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(0, "Чикен блю чиз", "https://i.imgur.com/1PdN3rH.png", Arrays.asList("Дор блю", "Моцарелла", "груша", "журавлина (в'ялена)", "курица гриль", "сливочный соус Альфредо (основа)", "шпинат"), 100));
        menuItems.add(new MenuItem(0, "Альфредо Блю Чиз", "https://i.imgur.com/f5jANFA.png", Arrays.asList("Дор блю", "Моцарелла", "Фета", "лук", "орегано", "перец Гриль", "руккола", "сливочный соус Альфредо (основа)", "чеснок"), 100));
        menuItems.add(new MenuItem(0, "Ковбойская", "https://i.imgur.com/UyjIpJe.png", Arrays.asList("Моцарелла", "баварские колбаски", "бекон", "лук", "огурец маринованный", "чесночный соус (основа)", "шампиньоны"), 100));
        menuItems.add(new MenuItem(0, "Цыпленок Jack", "https://i.imgur.com/gWBX3OW.png", Arrays.asList("BBQ соус (основа)", "Моцарелла", "бекон", "курица гриль", "лук", "перчик Халапеньо", "соус \"Jack Daniel's\"", "шампиньоны"), 100));
        menuItems.add(new MenuItem(0, "Цезарь", "https://i.imgur.com/pVLJH63.png", Arrays.asList("Моцарелла", "Пармезан", "без лука", "бекон", "курица гриль", "салат Айсберг", "соус Цезарь", "томати \"Черрі\"", "томатный соус (основа)"), 100));
        menuItems.add(new MenuItem(0, "4 сыра", "https://i.imgur.com/rQNdhhH.png", Arrays.asList("Дор блю", "Моцарелла", "Пармезан", "Чеддер", "сливочный соус Альфредо (основа)"), 100));
        menuItems.add(new MenuItem(0, "Итальянская", "https://i.imgur.com/8SElE4E.png", Arrays.asList("Дор блю", "Моцарелла", "вяленые томаты", "каперсы", "курица гриль", "сливочный соус Альфредо (основа)", "шампиньоны"), 100));
        menuItems.add(new MenuItem(0, "Тоскана", "https://i.imgur.com/HXUUyPg.png", Arrays.asList("Дор блю", "Моцарелла", "салями Пепперони", "чесночный соус (основа)"), 100));
        menuItems.add(new MenuItem(0, "Супер Мясная", "https://i.imgur.com/pliLJuh.png", Arrays.asList("Мит Болл", "Моцарелла", "ветчина", "говядина", "итальянские колбаски", "курица гриль", "салями Пепперони", "томатный соус (основа)"), 100));
        menuItems.add(new MenuItem(0, "Четыре сыра и Шпинат", "https://i.imgur.com/YxYTX17.png", Arrays.asList("Моцарелла", "Пармезан", "Фета", "сливочный соус Альфредо (основа)", "сливочный сыр", "соус \"Jack Daniel's\"", "шпинат"), 100));
    }

    public List<MenuItem> getItems() {
        return menuItems;
    }

    private static MenuProvider instance;

    public static MenuProvider getInstance() {
        if (instance == null)
            instance = new MenuProvider();
        return instance;
    }
}
