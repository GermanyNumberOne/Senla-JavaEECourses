package com.controllers;

import com.controllers.api.CardController;
import com.services.api.CardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dto.CardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CardControllerImpl implements CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(String entity) throws JsonProcessingException {
        cardService.create(convertObject(entity));
    }

    @Override
    public CardDto read(Long id) {
        return cardService.read(id);
    }

    public String getMappedObject(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(cardService.read(id));
    }

    public CardDto convertObject(String object) throws JsonProcessingException {
        return objectMapper.readValue(object, CardDto.class);
    }

    @Override
    public void update(String entity) throws JsonProcessingException {
        cardService.update(convertObject(entity));
    }

    public void deleteCardByNumber(String number){
        cardService.deleteCardByNumber(number);
    }

    public String readCardByNumber(String number) throws JsonProcessingException {
        return objectMapper.writeValueAsString(cardService.readCardByNumber(number));
    }

    @Override
    public void delete(Long id) {
        cardService.delete(id);
    }
}
