package com.dao.api;

import com.model.Card;

import javax.persistence.NoResultException;

public interface CardDao extends Dao<Card>{
    Card findCardByNumber(String number) throws NoResultException;
    void deleteCardByNumber(String number);
}
