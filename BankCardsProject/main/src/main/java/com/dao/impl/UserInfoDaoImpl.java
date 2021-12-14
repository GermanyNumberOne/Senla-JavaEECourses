package com.dao.impl;

import com.dao.api.UserInfoDao;
import com.model.UserInformation;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDaoImpl extends AbstractDao<UserInformation> implements UserInfoDao {
    @Override
    protected Class<UserInformation> getEntityClass() {
        return UserInformation.class;
    }
}
