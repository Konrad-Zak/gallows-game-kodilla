package com.kodilla.game.data;

import com.kodilla.game.data.category.*;


import java.util.*;

public class CategoryList {
    Map<String,Category> wordsCategoryList = new HashMap<>();

    public CategoryList() {
        wordsCategoryList.put("Sport", new Sport());
        wordsCategoryList.put("Automotive", new Automotive());
        wordsCategoryList.put("Games", new Games());
        wordsCategoryList.put("House",new House());
        wordsCategoryList.put("Life",new Life());
    }

    public Map<String,Category> getCategoryWord (){
        return new HashMap<>(wordsCategoryList);
    }
}
