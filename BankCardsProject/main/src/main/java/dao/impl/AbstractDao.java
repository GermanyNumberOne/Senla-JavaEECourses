package dao.impl;

import dao.DataBase;
import dao.api.Dao;
import dto.AbstractDto;
import model.BaseEntity;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;

@Repository
public abstract class AbstractDao<T extends BaseEntity> implements Dao<T> {
    @Autowired
    private DataBase dataBase;

    @Override
    public void create(T entity){

    }

    @Override
    public T read(Long id) {
        return null;
    }

    @Override
    public void update(T newEntity) {

    }

    @Override
    public void delete(Long id) {

    }
}
