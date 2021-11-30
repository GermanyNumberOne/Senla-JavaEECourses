package com.controllers.api;

import com.dto.CardDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CardController extends Controller<CardDto> {
    String readCardByNumber(String number) throws JsonProcessingException;
    void deleteCardByNumber(String number);
}
