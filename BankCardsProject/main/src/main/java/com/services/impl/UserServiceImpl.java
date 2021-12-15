package com.services.impl;

<<<<<<< HEAD
import com.dto.BankAccountDto;
import com.dto.OperationDto;
import com.services.api.UserService;
=======
>>>>>>> origin
import com.dao.api.UserDao;
import com.dto.UserDto;
import com.model.User;
import com.services.api.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;
=======
<<<<<<< HEAD
import java.util.stream.Collectors;
=======
>>>>>>> origin
>>>>>>> origin

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    private final ModelMapper modelMapper;

<<<<<<< HEAD
=======
    @Override
    @Transactional
    public void create(UserDto entity) {
        userDao.create(modelMapper.map(entity, User.class));
    }

>>>>>>> origin
    @Override
    @Transactional
<<<<<<< HEAD
    public List<UserDto> getAll(){
      return userDao.getAll().stream().map(value -> modelMapper.map(value, UserDto.class)).collect(Collectors.toList());
=======
    public void create(UserDto entity) {
<<<<<<< HEAD
        userDao.create(modelMapper.map(entity, User.class));
=======
        getDefaultDao().create(modelMapper.map(entity, User.class));
>>>>>>> origin
>>>>>>> origin
    }

    @Override
    @Transactional
<<<<<<< HEAD
    public List<UserDto> getAll(){
      return userDao.getAll().stream().map(value -> modelMapper.map(value, UserDto.class)).collect(Collectors.toList());
=======
    public UserDto read(Long id) {
        User user = userDao.read(id);

        return user == null ? null : modelMapper.map(user, UserDto.class);
<<<<<<< HEAD
=======
>>>>>>> origin
    }

    @Override
    @Transactional
    public UserDto read(Long id) {
        User user = userDao.read(id);

        return user == null ? null : modelMapper.map(user, UserDto.class);
    }

    @Override
    @Transactional
    public void update(UserDto entity) {
        userDao.update(modelMapper.map(entity, User.class));
    }

    @Override
    @Transactional
<<<<<<< HEAD
    public void delete(Long id) {
        userDao.delete(id);
=======
    public UserDto findUserByIdByEntityGraph(Long id){
        return modelMapper.map(getDefaultDao().findUserByIdByEntityGraph(id), UserDto.class);
>>>>>>> origin
    }
/*
    @Transactional
    public UserDto findUserByIdByJPQL(Long id){
        return modelMapper.map(getDefaultDao().findUserByIdByJPQL(id), UserDto.class);
>>>>>>> origin
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
<<<<<<< HEAD
    public UserDto getUserByLogin(String login){
        User user = userDao.getUserByLogin(login);

        return user == null ? null : modelMapper.map(user, UserDto.class);
=======
    public void update(UserDto entity) {
        userDao.update(modelMapper.map(entity, User.class));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
>>>>>>> origin
    }
}
