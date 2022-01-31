package com.senla.courses.project.dao.impl;

import com.senla.courses.project.dao.api.UserDao;
import com.senla.courses.project.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

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