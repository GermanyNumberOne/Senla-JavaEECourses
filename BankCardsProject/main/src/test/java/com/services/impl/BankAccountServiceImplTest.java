package com.services.impl;

import com.dao.api.BankAccountDao;
import com.dao.impl.BankAccountDaoImpl;
import com.dto.BankAccountDto;
import com.model.BankAccount;
import com.model.Operation;
import com.services.api.BankAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BankAccountServiceImplTest {

    @Mock
    private ModelMapper modelMapper;


    @Mock
    private BankAccountDao bankAccountDao;


    @InjectMocks
    private BankAccountServiceImpl bankAccountService;

    @Test
    void create() {
        BankAccountDto bankAccount = new BankAccountDto();

        bankAccountService.create(bankAccount);
        Mockito.verify(bankAccountDao, atLeastOnce()).create(modelMapper.map(bankAccount, BankAccount.class));
    }

    @Test
    void getAll() {
        assertTrue(bankAccountService.getAll().size() == 0);
        Mockito.verify(bankAccountDao, atLeastOnce()).getAll();
    }

    @Test
    void read() {
        assertTrue(bankAccountService.read(1l) == null);
        Mockito.verify(bankAccountDao, atLeastOnce()).read(1l);
    }

    @Test
    void update() {
        BankAccountDto bankAccount = new BankAccountDto();

        bankAccountService.update(bankAccount);
        Mockito.verify(bankAccountDao, atLeastOnce()).update(modelMapper.map(bankAccount, BankAccount.class));
    }

    @Test
    void delete() {
        bankAccountService.delete(1l);
        Mockito.verify(bankAccountDao, atLeastOnce()).delete(1l);
    }
}