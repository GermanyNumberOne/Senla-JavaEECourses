package com.dao.impl;

import com.dao.api.BankAccountDao;
import com.model.BankAccount;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BankAccountDaoImpl extends AbstractDao<BankAccount> implements BankAccountDao {
    @Override
    protected Class<BankAccount> getEntityClass() {
        return BankAccount.class;
    }
}
