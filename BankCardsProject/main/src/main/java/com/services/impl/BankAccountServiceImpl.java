package com.services.impl;

import com.services.api.BankAccountService;
import com.dao.api.BankAccountDao;
import com.dto.BankAccountDto;
import lombok.RequiredArgsConstructor;
import com.model.BankAccount;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public void create(BankAccountDto entity) {
        getDefaultDao().create(modelMapper.map(entity, BankAccount.class));
    }

    @Override
    public BankAccountDto read(Long id) {
        return modelMapper.map(getDefaultDao().read(id), BankAccountDto.class);
    }

    @Override
    public void update(BankAccountDto entity) {
        getDefaultDao().update(modelMapper.map(entity, BankAccount.class));
    }

    @Override
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
