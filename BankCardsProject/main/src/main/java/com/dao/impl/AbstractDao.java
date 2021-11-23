package com.dao.impl;

import com.dao.api.Dao;
import com.model.BaseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

@Component
public abstract class AbstractDao<T extends BaseEntity> implements Dao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    protected abstract Class<T> getEntityClass();

    private final Logger logger = Logger.getLogger(AbstractDao.class.getName());

    @Override
    @Transactional
    public void create(T entity) {
        if(!entityManager.contains(entity)){
            entityManager.persist(entity);
            entityManager.flush();
        }

        logger.info("entity created");
    }

    @Override
    @Transactional
    public T read(Long id) {
       return entityManager.find(getEntityClass(), id);
    }

    @Override
    @Transactional
    public void update(T entity) {
        entityManager.merge(entity);
        entityManager.flush();
        logger.info("entity updated");
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.remove(entityManager.find(getEntityClass(), id));
        entityManager.flush();
    }
}
