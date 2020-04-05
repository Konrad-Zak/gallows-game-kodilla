package com.kodilla.game.kodillagallowsgame.data;

import com.kodilla.game.kodillagallowsgame.data.category.Category;
import com.kodilla.game.kodillagallowsgame.data.category.Sport;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {
    List<Category> game = new ArrayList<>();

    public CategoryList() {
        game.add(new Sport());
    }
    public Category getName(){

        return game.get(0);
    }
}
