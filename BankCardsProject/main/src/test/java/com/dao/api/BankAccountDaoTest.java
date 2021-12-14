package com.dao.api;

import com.dao.impl.BankAccountDaoImpl;
import com.model.BankAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

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
    public void getAll(){
        assertThrows(NoResultException.class, () -> {
           bankAccountDao.getAll();
        });
    }

    @Test
    @Transactional
    public void read(){
        assertThrows(NoResultException.class, () -> {
            bankAccountDao.read(1l);
        });

    }

    @Test
    @Transactional
    public void update(){
        create();

        BankAccount bankAccount = bankAccountDao.getAll().get(0);
        bankAccount.setOperations(new ArrayList<>());

        bankAccountDao.update(bankAccount);

        assertTrue(bankAccountDao.getAll().size() == 1);
    }

    @Test
    @Transactional
    public void delete(){
        assertThrows(NoResultException.class, () -> {
            bankAccountDao.delete(1l);
        });
    }

}