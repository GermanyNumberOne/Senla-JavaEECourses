package com.senla.courses.project.dao.impl;

import com.senla.courses.project.dao.api.OperationDao;
import com.senla.courses.project.model.Operation;
import org.springframework.stereotype.Repository;


@Repository
public class OperationDaoImpl extends AbstractDao<Operation> implements OperationDao {
    @Override
    protected Class<Operation> getEntityClass() {
        return Operation.class;
    }

}
