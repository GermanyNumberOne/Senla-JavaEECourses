package com.dao.impl;

import com.dao.api.OperationDao;
import com.model.Operation;
import org.springframework.stereotype.Repository;


@Repository
public class OperationDaoImpl extends AbstractDao<Operation> implements OperationDao {

    @Override
    protected Class<Operation> getEntityClass() {
        return Operation.class;
    }
}
