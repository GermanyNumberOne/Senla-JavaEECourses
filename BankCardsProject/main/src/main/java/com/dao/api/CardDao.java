package com.dao.api;

import com.model.Card;

public interface CardDao extends Dao<Card>{
    Card findCardByNumber(String number);
    void deleteCardByNumber(String number);
}
