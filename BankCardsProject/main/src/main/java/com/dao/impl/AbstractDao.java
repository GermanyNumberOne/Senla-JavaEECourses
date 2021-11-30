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
    protected EntityManager entityManager;

    protected abstract Class<T> getEntityClass();

    private final Logger logger = Logger.getLogger(AbstractDao.class.getName());

    @Override
    public void create(T entity) {
        if(entityManager.find(getEntityClass(), entity.getId()) == null){
            entityManager.persist(entity);
            entityManager.flush();
            logger.info("entity " + getEntityClass().getSimpleName() + " has been created");
        }
        else{
            logger.info("entity " + getEntityClass().getSimpleName() + " has not been created");
        }
    }

    @Override
    public T read(Long id) {
       return entityManager.find(getEntityClass(), id);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
        //entityManager.refresh(entityManager.merge(entity));
        /*if(entityManager.find(getEntityClass(), entity.getId()) != null){
            entityManager.remove(entityManager.find(getEntityClass(), entity.getId()));
            entityManager.flush();
            create(entity);
        }*/
        entityManager.flush();
        logger.info("entity " + getEntityClass().getSimpleName() + " has been updated");
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(getEntityClass(), id));
        entityManager.flush();
        logger.info("entity has been deleted");
    }
}
