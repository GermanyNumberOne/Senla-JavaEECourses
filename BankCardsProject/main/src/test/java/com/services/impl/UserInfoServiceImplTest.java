package com.services.impl;

import com.dao.api.UserInfoDao;
import com.dto.UserInformationDto;
import com.model.User;
import com.model.UserInformation;
import com.services.api.UserInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserInfoServiceImplTest {

    @InjectMocks
    private UserInfoServiceImpl userInfoService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserInfoDao userInfoDao;

    @Test
    void create() {
        UserInformationDto userInfo = new UserInformationDto();

        userInfoService.create(userInfo);
        Mockito.verify(userInfoDao, atLeastOnce()).create(modelMapper.map(userInfo, UserInformation.class));
    }

    @Test
    void getAll() {
        assertTrue(userInfoService.getAll().size() == 0);
        Mockito.verify(userInfoDao, atLeastOnce()).getAll();
    }

    @Test
    void read() {
        assertTrue(userInfoService.read(1l) == null);
        Mockito.verify(userInfoDao, atLeastOnce()).read(1l);
    }

    @Test
    void update() {
        UserInformationDto userInfo = new UserInformationDto();

        userInfoService.update(userInfo);
        Mockito.verify(userInfoDao, atLeastOnce()).update(modelMapper.map(userInfo, UserInformation.class));
    }

    @Test
    void delete() {
        userInfoService.delete(1l);
        Mockito.verify(userInfoDao, atLeastOnce()).delete(1l);
    }
}