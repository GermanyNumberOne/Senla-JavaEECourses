package com.senla.courses.project.services.api;

import com.senla.courses.project.dto.BankAccountDto;
import com.senla.courses.project.dto.UserDto;
import com.senla.courses.project.dto.UserFilterDto;

import java.util.List;

public interface UserService extends Service<UserDto>{
   UserDto getUserByLogin(String login);
   BankAccountDto getUserBankAccount(String login);
   List<UserDto> getAllSortedBy(UserFilterDto entity);
}
