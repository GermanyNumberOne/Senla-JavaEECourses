package com.controllers;

import com.controllers.api.BankAccountController;
import com.services.api.BankAccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dto.BankAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankAccountControllerImpl implements BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(String entity) throws JsonProcessingException {
        bankAccountService.create(convertObject(entity));
    }

    @Override
    public BankAccountDto read(Long id) {
        return bankAccountService.read(id);
    }

    public String getMappedObject(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(bankAccountService.read(id));
    }

    public BankAccountDto convertObject(String object) throws JsonProcessingException {
        return objectMapper.readValue(object, BankAccountDto.class);
    }

    @Override
    public void update(String entity) throws JsonProcessingException {
        bankAccountService.update(convertObject(entity));
    }

    @Override
    public void delete(Long id) {
        bankAccountService.delete(id);
    }
}
