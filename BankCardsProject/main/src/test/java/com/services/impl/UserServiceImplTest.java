package com.services.impl;

import com.dao.api.UserDao;
import com.dto.UserDto;
import com.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserDao userDao;

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