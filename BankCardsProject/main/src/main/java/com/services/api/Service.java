package com.services.api;


import com.dto.AbstractDto;

public interface Service<T extends AbstractDto> {
    void create(T entity);
    T read(Long id);
    void update(T entity);
    void delete(Long id);
}
