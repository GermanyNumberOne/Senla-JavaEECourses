package com.dao.api;

import com.dao.impl.UserDaoImpl;
import com.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

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
        assertTrue(userDao.read(1l) == null);
    }

    @Test
    @Transactional
    public void update(){
        User user = new User();
        user.setFirstname("Harry");
        user.setSurname("Pitter");

        userDao.update(user);
    }

    @Test
    @Transactional
    public void delete(){
        userDao.delete(1l);
    }

    @Test
    void findUserByIdByEntityGraph() {
        assertNull(userDao.findUserByIdByEntityGraph(1l));
    }

}