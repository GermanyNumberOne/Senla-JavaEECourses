package com.dao.api;

import com.dao.impl.UserDaoImpl;
import com.model.BankAccount;
import com.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {UserDaoImpl.class})
class UserDaoTest extends DaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    @Transactional
    public void create(){
        User user = new User();
        user.setFirstname("Harry");

        userDao.create(user);
    }

    @Test
    @Transactional
    public void read(){
        assertThrows(NoResultException.class, () -> {
            userDao.read(1l);
        });
    }

    @Test
    @Transactional
    public void update(){
        create();

        User user = userDao.getAll().get(0);
        user.setFirstname("hua");

        userDao.update(user);

        assertTrue(userDao.getAll().size() == 1);
    }

    @Test
    @Transactional
    public void delete(){
        assertThrows(NoResultException.class, () -> {
            userDao.delete(1l);
        });
    }

    @Test
    @Transactional
    void findUserByIdByEntityGraph() {
        assertThrows(NoResultException.class, () -> {
            userDao.findUserByIdByEntityGraph(1l);
        });
    }

}