package com.senla.courses.project.services.impl;

import com.senla.courses.project.dto.BankAccountDto;
import com.senla.courses.project.dto.UserDto;
import com.senla.courses.project.exception.UserDoNotHavePermissionException;
import com.senla.courses.project.services.api.BankAccountService;
import com.senla.courses.project.dao.api.BankAccountDao;
import com.senla.courses.project.services.api.UserService;
import lombok.RequiredArgsConstructor;
import com.senla.courses.project.model.BankAccount;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountDao bankAccountDao;

    private final ModelMapper modelMapper;

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    public boolean isUserAllowed(Long id){
        UserDto user = userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        if(user.getRoles().stream()
                .anyMatch(role -> role.getRoleName().equals("ROLE_ADMIN"))) return true;

        return user.getBankAccountId().equals(id);
    }

    @Override
    @Transactional
    public List<BankAccountDto> getAll(){
        return bankAccountDao.getAll().stream().map(value -> modelMapper.map(value, BankAccountDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(BankAccountDto entity) {
        if(entity.getUser() != null){
            entity.getUser().setPassword(passwordEncoder.encode(entity.getUser().getPassword()));
        }
        bankAccountDao.create(modelMapper.map(entity, BankAccount.class));
    }

    @Override
    @Transactional
    public BankAccountDto read(Long id) {
        //if(!isUserAllowed(id))throw new UserDoNotHavePermissionException("Access error");
        System.out.println("skdjjkfdghdfjkfmn vxcmnvbxmncxbmxcbm");
        BankAccount bankAccount = bankAccountDao.read(id);
        bankAccount.getUser().getFirstname();
        return null;
        //return bankAccount == null ? null : modelMapper.map(bankAccount, BankAccountDto.class);
    }

    @Override
    @Transactional
    public void update(BankAccountDto entity) {
        if(!isUserAllowed(entity.getId()))throw new UserDoNotHavePermissionException("Access error");
        bankAccountDao.update(modelMapper.map(entity, BankAccount.class));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if(!isUserAllowed(id))throw new UserDoNotHavePermissionException("Access error");
        bankAccountDao.delete(id);
    }
}
