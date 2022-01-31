package com.senla.courses.project.services.api;

import com.senla.courses.project.dto.CardDto;
import com.senla.courses.project.dto.TransactionDto;

import javax.persistence.NoResultException;
import java.util.List;

public interface CardService extends Service<CardDto>{
    CardDto readCardByNumber(String number) throws NoResultException;

    void deleteCardByNumber(String number);

    void transaction(TransactionDto entity);

    List<CardDto> getAllUserCards(String login);
}
