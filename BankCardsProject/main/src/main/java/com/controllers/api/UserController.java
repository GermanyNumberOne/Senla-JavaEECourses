package com.controllers.api;

import com.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.User;

import java.util.List;

public interface UserController extends Controller<UserDto>{
    UserDto readUserByName(String name);
    String findUserByIdByJPQL(Long id) throws JsonProcessingException;
    String findUserByIdByCriteria(Long id) throws JsonProcessingException;
    String findUserByIdByEntityGraph(Long id) throws JsonProcessingException;
    List<UserDto> getAll();
}
