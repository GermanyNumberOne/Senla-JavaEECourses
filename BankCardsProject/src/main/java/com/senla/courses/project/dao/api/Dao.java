package com.senla.courses.project.dao.api;

import com.senla.courses.project.model.BaseEntity;

import java.util.Comparator;
import java.util.List;


public interface Dao<T extends BaseEntity>{
    void create(T entity);
    T read(Long id);
    void update(T entity);
    void delete(Long id);
    List<T> getAll();
    List<T> getAllSortedBy(Comparator<T> comparator);
}
