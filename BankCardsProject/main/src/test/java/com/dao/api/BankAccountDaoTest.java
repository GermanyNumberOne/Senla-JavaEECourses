package com.dao.api;

import com.dao.impl.BankAccountDaoImpl;
import com.model.BankAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {BankAccountDaoImpl.class})
class BankAccountDaoTest extends DaoTest {
    @Autowired
    private BankAccountDao bankAccountDao;

    @Test
    @Transactional
    public void create(){
        BankAccount bankAccount = new BankAccount();


        bankAccountDao.create(bankAccount);
    }

    @Test
    @Transactional
    public void read(){
        assertTrue(bankAccountDao.read(1l) == null);
    }

    @Test
    @Transactional
    public void update(){
        BankAccount bankAccount = new BankAccount();


        bankAccountDao.update(bankAccount);
    }

    @Test
    @Transactional
    public void delete(){
        bankAccountDao.delete(1l);
    }

}