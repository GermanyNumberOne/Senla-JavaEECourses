package com.services.impl;

import com.dto.BankAccountDto;
import com.dto.OperationDto;
import com.services.api.UserService;
import com.dao.api.UserDao;
import com.dto.UserDto;
import lombok.RequiredArgsConstructor;
import com.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void create(UserDto entity) {
        userDao.create(modelMapper.map(entity, User.class));
    }

    @Override
    @Transactional
    public List<UserDto> getAll(){
      return userDao.getAll().stream().map(value -> modelMapper.map(value, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDto read(Long id) {
        User user = userDao.read(id);

        return user == null ? null : modelMapper.map(user, UserDto.class);
    }
/*
    @Transactional
    public UserDto findUserByIdByJPQL(Long id){
        return modelMapper.map(getDefaultDao().findUserByIdByJPQL(id), UserDto.class);
    }


    @Transactional
    public UserDto findUserByIdByCriteria(Long id){
        return modelMapper.map(getDefaultDao().findUserByIdByCriteria(id), UserDto.class);
    }

    @Transactional
    public UserDto findUserByIdByEntityGraph(Long id){
        return modelMapper.map(getDefaultDao().findUserByIdByEntityGraph(id), UserDto.class);
    }
*/
    @Override
    @Transactional
    public void update(UserDto entity) {
        userDao.update(modelMapper.map(entity, User.class));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }
}
