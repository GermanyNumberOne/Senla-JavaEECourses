package com.senla.courses.project.dao.api;

import com.senla.courses.project.model.Card;

import javax.persistence.NoResultException;

public interface CardDao extends Dao<Card>{
    Card findCardByNumber(String number) throws NoResultException;
    void deleteCardByNumber(String number);
    void transaction(String number, Long money);
}
