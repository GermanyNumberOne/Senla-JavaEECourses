package com.controllers;

import com.controllers.api.OperationController;
import com.services.api.OperationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dto.OperationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationControllerImpl implements OperationController {
    @Autowired
    private OperationService operationService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(String entity) throws JsonProcessingException {
        operationService.create(convertObject(entity));
    }

    @Override
    public OperationDto read(Long id) {
        return operationService.read(id);
    }

    public String getMappedObject(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(operationService.read(id));
    }

    public OperationDto convertObject(String object) throws JsonProcessingException {
        return objectMapper.readValue(object, OperationDto.class);
    }

    @Override
    public void update(String entity) throws JsonProcessingException {
        operationService.update(convertObject(entity));
    }

    @Override
    public void delete(Long id) {
        operationService.delete(id);
    }
}
