package com.services.impl;

import com.dto.CardDto;
import com.dto.OperationDto;
import com.model.Card;
import com.model.UserInformation;
import com.services.api.BankAccountService;
import com.dao.api.BankAccountDao;
import com.dto.BankAccountDto;
import lombok.RequiredArgsConstructor;
import com.model.BankAccount;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountDao bankAccountDao;

    private final ModelMapper modelMapper;


    @Override
    @Transactional
    public List<BankAccountDto> getAll(){
        return bankAccountDao.getAll().stream().map(value -> modelMapper.map(value, BankAccountDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(BankAccountDto entity) {
        bankAccountDao.create(modelMapper.map(entity, BankAccount.class));
    }

    @Override
    public BankAccountDto read(Long id) {
        BankAccount bankAccount = bankAccountDao.read(id);

        return bankAccount == null ? null : modelMapper.map(bankAccount, BankAccountDto.class);
    }

    @Override
    @Transactional
    public void update(BankAccountDto entity) {
        bankAccountDao.update(modelMapper.map(entity, BankAccount.class));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bankAccountDao.delete(id);
    }
}
