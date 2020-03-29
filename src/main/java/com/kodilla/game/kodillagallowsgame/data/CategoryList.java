package com.kodilla.game.kodillagallowsgame.data;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {
    List<Object> game = new ArrayList<>();

    public CategoryList() {
        game.add(new Sport());
    }
    public String getName(){

        return Sport.CATEGORY;
    }
}
