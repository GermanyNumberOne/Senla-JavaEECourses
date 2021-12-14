package com.dao.impl;

import com.dao.api.BankAccountDao;
import com.model.BankAccount;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountDaoImpl extends AbstractDao<BankAccount> implements BankAccountDao {
    @Override
    protected Class<BankAccount> getEntityClass() {
        return BankAccount.class;
    }

}
