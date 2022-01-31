package com.senla.courses.project.dao.impl;

import com.senla.courses.project.dao.api.OperationCategoriesDao;
import com.senla.courses.project.model.OperationCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class OperationCategoriesDaoImpl extends AbstractDao<OperationCategory> implements OperationCategoriesDao {
    @Override
    protected Class<OperationCategory> getEntityClass() {
        return OperationCategory.class;
    }

    @Override
    public OperationCategory getCategoryByName(String name) throws NoResultException {
        return entityManager.
                createQuery("select category from OperationCategory category where category.name = :name", OperationCategory.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
