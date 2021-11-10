package com.dao.api;

import com.model.BaseEntity;


public interface Dao<T extends BaseEntity>{
    void create(T entity);
    T read(Long id);
    void update(T entity);
    void delete(Long id);
}
