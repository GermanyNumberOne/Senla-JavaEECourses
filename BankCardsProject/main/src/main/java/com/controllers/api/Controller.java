package com.controllers.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.dto.AbstractDto;

public interface Controller<T extends AbstractDto> {
    void create(String entity) throws JsonProcessingException;
    T read(Long id);
    String getMappedObject(Long id) throws JsonProcessingException;
    void update(String entity) throws JsonProcessingException;
    void delete(Long id);
}
