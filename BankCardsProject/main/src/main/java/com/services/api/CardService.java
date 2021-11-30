package com.services.api;

import com.dto.CardDto;

public interface CardService extends Service<CardDto>{
    CardDto readCardByNumber(String number);
    void deleteCardByNumber(String number);
}
