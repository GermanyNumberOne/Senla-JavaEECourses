package Controllers;

import Controllers.api.BankAccountController;
import Services.api.BankAccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.BankAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankAccountControllerImpl implements BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(BankAccountDto entity) {
        bankAccountService.create(entity);
    }

    @Override
    public BankAccountDto read(Long id) {
        return bankAccountService.read(id);
    }

    public String getMappedObject(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(bankAccountService.read(id));
    }

    @Override
    public void update(BankAccountDto entity) {
        bankAccountService.update(entity);
    }

    @Override
    public void delete(Long id) {
        bankAccountService.delete(id);
    }
}
