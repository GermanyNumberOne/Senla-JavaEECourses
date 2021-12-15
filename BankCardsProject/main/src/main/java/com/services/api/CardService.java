package com.services.api;

import com.dto.CardDto;

import javax.persistence.NoResultException;

public interface CardService extends Service<CardDto>{
    CardDto readCardByNumber(String number) throws NoResultException;
    void deleteCardByNumber(String number);
}
