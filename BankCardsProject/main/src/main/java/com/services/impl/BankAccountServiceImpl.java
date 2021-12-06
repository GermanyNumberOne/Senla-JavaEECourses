package com.services.impl;

import com.services.api.BankAccountService;
import com.dao.api.BankAccountDao;
import com.dto.BankAccountDto;
import lombok.RequiredArgsConstructor;
import com.model.BankAccount;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountDao bankAccountDao;

    private final ModelMapper modelMapper;

    protected ModelMapper getModelMapper(){
        return modelMapper;
    }

    protected BankAccountDao getDefaultDao() {
        return bankAccountDao;
    }

    @Override
    @Transactional
    public void create(BankAccountDto entity) {
        getDefaultDao().create(modelMapper.map(entity, BankAccount.class));
    }

    @Override
    @Transactional
    public BankAccountDto read(Long id) {
        BankAccount bankAccount = bankAccountDao.read(id);

        return bankAccount == null ? null : modelMapper.map(bankAccount, BankAccountDto.class);
    }

    @Override
    @Transactional
    public void update(BankAccountDto entity) {
        getDefaultDao().update(modelMapper.map(entity, BankAccount.class));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
