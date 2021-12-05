package com.services.impl;

import com.dao.api.UserDao;
import com.dto.UserDto;
import com.model.User;
import com.services.api.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    private UserService userService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        modelMapper = mock(ModelMapper.class);
        userDao = mock(UserDao.class);

        userService = new UserServiceImpl(userDao,modelMapper);
    }

    @Test
    void create() {
        UserDto user = new UserDto();

        userService.create(user);
        Mockito.verify(userDao, atLeastOnce()).create(modelMapper.map(user, User.class));
    }

    @Test
    void getAll() {
        assertTrue(userService.getAll().size() == 0);
        Mockito.verify(userDao, atLeastOnce()).getAll();
    }

    @Test
    void read() {
        assertTrue(userService.read(1l) == null);
        Mockito.verify(userDao, atLeastOnce()).read(1l);
    }

    @Test
    void update() {
        UserDto user = new UserDto();

        userService.update(user);
        Mockito.verify(userDao, atLeastOnce()).update(modelMapper.map(user, User.class));
    }

    @Test
    void delete() {
        userService.delete(1l);
        Mockito.verify(userDao, atLeastOnce()).delete(1l);
    }
}