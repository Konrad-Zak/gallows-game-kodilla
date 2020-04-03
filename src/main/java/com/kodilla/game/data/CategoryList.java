package com.kodilla.game.data;

import com.kodilla.game.data.category.Automotive;
import com.kodilla.game.data.category.Sport;
import com.kodilla.game.data.category.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {
    List<Category> wordsCategoryList = new ArrayList<>();

    public CategoryList() {
        wordsCategoryList.add(new Sport());
        wordsCategoryList.add(new Automotive());

    }
    public Category getName(){

        return wordsCategoryList.get(0);
    }

    public List<Category> getCategoryWord (){
        return new ArrayList<>(wordsCategoryList);
    }
}
