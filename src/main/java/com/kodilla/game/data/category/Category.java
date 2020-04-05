package com.kodilla.game.data.category;

import com.kodilla.game.data.model.Word;

public interface Category {

    Word getEasyWord();

    Word getMediumWord();

    Word getHardWord();

    String getCategoryName();

}
