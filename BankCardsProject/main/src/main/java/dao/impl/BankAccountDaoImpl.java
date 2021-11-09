package dao.impl;

import java.util.List;
import dao.DataBase;
import dao.api.BankAccountDao;
import model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {
    @Autowired
    private DataBase dataBase;

    @Override
    public void create(BankAccount entity) {
        dataBase.getBankAccounts().add(entity);
    }

    @Override
    public BankAccount read(Long id) {
        return dataBase.getBankAccounts().get(id.intValue());
    }

    @Override
    public void update(BankAccount entity) {
        List<BankAccount> accounts = dataBase.getBankAccounts();
        int index = -1;

        for(BankAccount account : accounts){
            if(entity.equals(account)){
                index = accounts.indexOf(account);
                break;
            }
        }

        if(index >= 0){
            accounts.set(index, entity);
        }
        else create(entity);
    }

    @Override
    public void delete(Long id) {
        dataBase.getBankAccounts().remove(id.intValue());
    }
}
