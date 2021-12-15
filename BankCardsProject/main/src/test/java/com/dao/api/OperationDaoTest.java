package com.dao.api;

import com.dao.impl.BankAccountDaoImpl;
import com.dao.impl.OperationDaoImpl;
import com.dto.OperationDto;
import com.model.BankAccount;
import com.model.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {OperationDaoImpl.class, BankAccountDaoImpl.class})
class OperationDaoTest extends DaoTest {
    @Autowired
    private OperationDao operationDao;

    @Test
    @Transactional
    public void create(){
        Operation operation = new Operation();
        operation.setCost(123l);

        operationDao.create(operation);
    }

    @Test
    @Transactional
    public void read(){
        assertThrows(NoResultException.class, () -> {
            operationDao.read(1l);
        });
    }

    @Test
    @Transactional
    public void update(){
        create();

        Operation operation = operationDao.getAll().get(0);
        operation.setCost(123l);

        operationDao.update(operation);

        assertTrue(operationDao.getAll().size() == 1);
    }

    @Test
    @Transactional
    public void delete(){
        assertThrows(NoResultException.class, () -> {
            operationDao.delete(1l);
        });
    }

}