package com.controllers.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.dto.AbstractDto;

public interface Controller<T extends AbstractDto> {
    void create(T entity);
    T read(Long id);
    String getMappedObject(Long id) throws JsonProcessingException;
    void update(T entity);
    void delete(Long id);
}
