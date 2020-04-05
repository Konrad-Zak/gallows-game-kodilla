package com.kodilla.game.kodillagallowsgame.data.category;

import com.kodilla.game.kodillagallowsgame.data.model.Word;

public interface Category {

    Word getEasyWord();

    Word getMediumWord();

    Word getHardWord();

    String getCategoryName();
}
