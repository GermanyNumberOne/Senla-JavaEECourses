package com.senla.courses.project.dao.impl;

import com.senla.courses.project.dao.api.BankAccountDao;
import com.senla.courses.project.model.BankAccount;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountDaoImpl extends AbstractDao<BankAccount> implements BankAccountDao {
    @Override
    protected Class<BankAccount> getEntityClass() {
        return BankAccount.class;
    }

}
