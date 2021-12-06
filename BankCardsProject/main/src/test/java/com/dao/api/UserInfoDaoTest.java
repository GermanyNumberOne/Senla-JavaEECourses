package com.dao.api;

import com.dao.impl.UserInfoDaoImpl;
import com.model.BankAccount;
import com.model.UserInformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {UserInfoDaoImpl.class})
class UserInfoDaoTest extends DaoTest {

    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    @Transactional
    public void create(){
        UserInformation userInfo = new UserInformation();

        userInfoDao.create(userInfo);
    }

    @Test
    @Transactional
    public void read(){
        assertThrows(NoResultException.class, () -> {
            userInfoDao.read(1l);
        });
    }

    @Test
    @Transactional
    public void update(){
        create();

        UserInformation userInformation = userInfoDao.getAll().get(0);
        userInformation.setAddress("ger");

        userInfoDao.update(userInformation);

        assertTrue(userInfoDao.getAll().size() == 1);
    }

    @Test
    @Transactional
    public void delete(){
        assertThrows(NoResultException.class, () -> {
            userInfoDao.delete(1l);
        });
    }

}