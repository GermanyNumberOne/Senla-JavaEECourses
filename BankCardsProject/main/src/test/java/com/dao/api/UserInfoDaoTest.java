package com.dao.api;

import com.dao.impl.UserInfoDaoImpl;
import com.model.UserInformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

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
        assertTrue(userInfoDao.read(1l) == null);
    }

    @Test
    @Transactional
    public void update(){
        UserInformation userInfo = new UserInformation();

        userInfoDao.update(userInfo);
    }

    @Test
    @Transactional
    public void delete(){
        userInfoDao.delete(1l);
    }

}