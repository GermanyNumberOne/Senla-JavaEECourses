package com.dao.impl;

import com.dao.api.Dao;
import com.model.BaseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

@Component
public abstract class AbstractDao<T extends BaseEntity> implements Dao<T> {
    @PersistenceContext
    protected EntityManager entityManager;

    protected abstract Class<T> getEntityClass();

    private final Logger logger = Logger.getLogger(AbstractDao.class.getName());

    public List<T> getAll(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
        Root<T> root = cq.from(getEntityClass());
        CriteriaQuery<T> all = cq.select(root);

        TypedQuery<T> allQuery = entityManager.createQuery(all);
        List<T> list = allQuery.getResultList();
        if(list.isEmpty()){
            throw new NoResultException("there are no entities");
        }
        return list;
    }

    @Override
    public void create(T entity) {
        if(!entityManager.contains(entity)){
            entityManager.persist(entity);
            entityManager.flush();

            logger.info("entity has been created");
        }
    }

    @Override
    public T read(Long id){
        T object = entityManager.find(getEntityClass(), id);

        if(object == null){
            logger.info(getEntityClass().getName() + "Dao: read method: no such entity");
            throw new NoResultException("no such entity");
        }

       return object;
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
        entityManager.flush();
        logger.info("entity has been updated");
    }

    @Override
    public void delete(Long id) {
        T object = entityManager.find(getEntityClass(), id);

        if(object == null){
            logger.info(getEntityClass().getName() + "Dao" + ": delete method: no such entity");
            throw new NoResultException("no such entity");
        }

        entityManager.remove(object);
        entityManager.flush();
        logger.info("entity has been deleted");
    }
}
