package com.services.impl;

import com.services.api.UserService;
import com.dao.api.UserDao;
import com.dto.UserDto;
import lombok.RequiredArgsConstructor;
import com.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    private final ModelMapper modelMapper;

    protected UserDao getDefaultDao() {
        return userDao;
    }

    @Override
    @Transactional
    public void create(UserDto entity) {
        getDefaultDao().create(modelMapper.map(entity, User.class));
    }

    @Override
    @Transactional
    public UserDto read(Long id) {
        User user = userDao.read(id);

        return user == null ? null : modelMapper.map(user, UserDto.class);
    }

    @Override
    @Transactional
    public UserDto findUserByIdByJPQL(Long id){
        return modelMapper.map(getDefaultDao().findUserByIdByJPQL(id), UserDto.class);
    }

    public UserDto readUserByName(String name){
        List<User> users = getDefaultDao().findUserByNameByJPQL(name);


        return null;
    }

    @Override
    @Transactional
    public UserDto findUserByIdByCriteria(Long id){
        return modelMapper.map(getDefaultDao().findUserByIdByCriteria(id), UserDto.class);
    }

    @Override
    @Transactional
    public UserDto findUserByIdByEntityGraph(Long id){
        return modelMapper.map(getDefaultDao().findUserByIdByEntityGraph(id), UserDto.class);
    }

    @Override
    @Transactional
    public void update(UserDto entity) {
        getDefaultDao().update(modelMapper.map(entity, User.class));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
