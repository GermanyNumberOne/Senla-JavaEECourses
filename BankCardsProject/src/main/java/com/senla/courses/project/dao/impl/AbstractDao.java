package com.senla.courses.project.dao.impl;

import com.senla.courses.project.dao.api.Dao;
import com.senla.courses.project.model.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Comparator;
import java.util.List;

@Component
@Slf4j
public abstract class AbstractDao<T extends BaseEntity> implements Dao<T> {
    @PersistenceContext
    protected EntityManager entityManager;

    protected abstract Class<T> getEntityClass();

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
            if (!entityManager.contains(entity)) {
                entityManager.persist(entity);
                entityManager.flush();

                log.info("entity has been created");
            }
    }

    @Override
    public T read(Long id){
        T object = entityManager.find(getEntityClass(), id);

        if(object == null){
            log.info("There are no entity with that id");
            throw new NoResultException("no such entity");
        }

       return object;
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
        entityManager.flush();
        log.info("entity has been updated");
    }

    @Override
    public void delete(Long id) {
        T object = entityManager.find(getEntityClass(), id);

        if(object == null){
            log.info("There are no entity with that id");
            throw new NoResultException("no such entity");
        }

        entityManager.remove(object);
        entityManager.flush();
        log.info("Entity has been deleted");
    }

    @Override
    public List<T> getAllSortedBy(Comparator<T> comparator){
        List<T> toSort = getAll();

        toSort.sort(comparator);

        return toSort;
    }
}
