package com.kodilla.game.data;

import com.kodilla.game.data.category.Automotive;
import com.kodilla.game.data.category.Games;
import com.kodilla.game.data.category.Sport;
import com.kodilla.game.data.category.Category;


import java.util.*;

public class CategoryList {
    Map<String,Category> wordsCategoryList = new HashMap<>();

    public CategoryList() {
        wordsCategoryList.put("Sport", new Sport());
        wordsCategoryList.put("Automotive", new Automotive());
        wordsCategoryList.put("Games", new Games());

    }

    public Map<String,Category> getCategoryWord (){
        return new HashMap<>(wordsCategoryList);
    }
}
