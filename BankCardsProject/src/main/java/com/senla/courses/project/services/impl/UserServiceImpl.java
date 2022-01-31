package com.senla.courses.project.services.impl;

import com.senla.courses.project.dto.BankAccountDto;
import com.senla.courses.project.dto.UserDto;
import com.senla.courses.project.dao.api.BankAccountDao;
import com.senla.courses.project.dao.api.UserDao;
import com.senla.courses.project.dao.comparators.UserCardsAmountComparator;
import com.senla.courses.project.dao.comparators.UserFirstnameComparator;
import com.senla.courses.project.dao.comparators.UserSurnameComparator;
import com.senla.courses.project.dto.UserFilterDto;
import com.senla.courses.project.exception.UserDoNotHavePermissionException;
import com.senla.courses.project.model.User;
import com.senla.courses.project.services.api.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    private final BankAccountDao bankAccountDao;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    public boolean isUserAllowed(Long id){
        UserDto user = getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());

        if(user.getRoles().stream().anyMatch(role -> role.getRoleName().equals("ROLE_ADMIN"))) return true;

        return user.getId().equals(id);
    }

    @Override
    @Transactional
    public void create(UserDto entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
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
        if(!isUserAllowed(id)) throw new UserDoNotHavePermissionException("Access error");

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
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public UserDto getUserByLogin(String login){
        User user = userDao.getUserByLogin(login);

        return user == null ? null : modelMapper.map(user, UserDto.class);
    }

    @Override
    @Transactional
    public BankAccountDto getUserBankAccount(String login){
        return modelMapper.map(bankAccountDao.read(getUserByLogin(login).getBankAccountId()), BankAccountDto.class);
    }

    @Override
    @Transactional
    public List<UserDto> getAllSortedBy(UserFilterDto entity){
        List<User> users = userDao.getAll();

        if(entity.isFirstname()){
            users.sort(new UserFirstnameComparator());
        }
        if(entity.isSurname()){
            users.sort(new UserSurnameComparator());
        }
        if(entity.isCardsAmount()){
            users.sort(new UserCardsAmountComparator());
        }

        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }
}
