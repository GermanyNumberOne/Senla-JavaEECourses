package com.controllers;

import com.controllers.api.UserController;
import com.services.api.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(String entity) throws JsonProcessingException {
        userService.create(convertObject(entity));
    }

    @Override
    public UserDto read(Long id) {
        return userService.read(id);
    }

    public String getMappedObject(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(userService.read(id));
    }

    public UserDto convertObject(String object) throws JsonProcessingException {
        return objectMapper.readValue(object, UserDto.class);
    }

    @Override
    public void update(String entity) throws JsonProcessingException {
        userService.update(convertObject(entity));
    }

    @Override
    public void delete(Long id) {
        userService.delete(id);
    }

    public String findUserByIdByJPQL(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(userService.findUserByIdByJPQL(id));
    }

    public String findUserByIdByCriteria(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(userService.findUserByIdByCriteria(id));
    }

    public String findUserByIdByEntityGraph(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(userService.findUserByIdByEntityGraph(id));
    }

     public UserDto readUserByName(String name){
        return userService.readUserByName(name);
    }

}
