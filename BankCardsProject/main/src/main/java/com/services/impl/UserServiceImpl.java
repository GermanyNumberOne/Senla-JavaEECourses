package com.services.impl;

import com.dao.api.UserDao;
import com.dto.UserDto;
import com.model.User;
import com.services.api.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;
=======
>>>>>>> origin

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
<<<<<<< HEAD
    public List<UserDto> getAll(){
      return userDao.getAll().stream().map(value -> modelMapper.map(value, UserDto.class)).collect(Collectors.toList());
=======
    public void create(UserDto entity) {
        getDefaultDao().create(modelMapper.map(entity, User.class));
>>>>>>> origin
    }

    @Override
    @Transactional
    public UserDto read(Long id) {
        User user = userDao.read(id);

        return user == null ? null : modelMapper.map(user, UserDto.class);
<<<<<<< HEAD
=======
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
>>>>>>> origin
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
