package com.services.api;

import com.dto.UserDto;

public interface UserService extends Service<UserDto>{
    UserDto readUserByName(String name);
    UserDto findUserByIdByJPQL(Long id);
    UserDto findUserByIdByCriteria(Long id);
    UserDto findUserByIdByEntityGraph(Long id);
}
