package com.services.api;

import com.dto.UserDto;

import java.util.List;

public interface UserService extends Service<UserDto>{
   UserDto getUserByLogin(String login);
}
