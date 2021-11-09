package Services.impl;

import Services.api.BankAccountService;
import dao.api.BankAccountDao;
import dto.AbstractDto;
import dto.BankAccountDto;
import lombok.RequiredArgsConstructor;
import model.BankAccount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private final BankAccountDao bankAccountDao;
    @Autowired
    private ModelMapper modelMapper;


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
