package com.controllers.api;

import com.dto.CardDto;

public interface CardController extends Controller<CardDto> {
    CardDto readCardByNumber(String number);
    void deleteCardByNumber(String number);
}
