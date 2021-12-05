package com.dao.api;

import com.dto.UserDto;
import com.model.BaseEntity;

import java.util.List;


public interface Dao<T extends BaseEntity>{
    void create(T entity);
    T read(Long id);
    void update(T entity);
    void delete(Long id);
    List<T> getAll();
}
