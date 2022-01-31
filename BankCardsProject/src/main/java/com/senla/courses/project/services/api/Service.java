package com.senla.courses.project.services.api;


import com.senla.courses.project.dto.AbstractDto;

import java.util.List;

public interface Service<T extends AbstractDto> {
    void create(T entity);
    T read(Long id);
    void update(T entity);
    void delete(Long id);
    List<T> getAll();
}
