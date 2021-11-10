package com.services.impl;

import com.services.api.UserService;
import com.dao.api.UserDao;
import com.dto.UserDto;
import lombok.RequiredArgsConstructor;
import com.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    private final ModelMapper modelMapper;

    protected UserDao getDefaultDao() {
        return userDao;
    }

    @Override
    public void create(UserDto entity) {
        getDefaultDao().create(modelMapper.map(entity, User.class));
    }

    @Override
    public UserDto read(Long id) {
        return modelMapper.map(getDefaultDao().read(id), UserDto.class);
    }

    @Override
    public void update(UserDto entity) {
        getDefaultDao().update(modelMapper.map(entity, User.class));
    }

    @Override
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
