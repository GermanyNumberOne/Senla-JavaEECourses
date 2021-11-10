package com.dao.impl;

import com.dao.DataBase;
import com.dao.api.UserInfoDao;
import com.model.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
    @Autowired
    private DataBase dataBase;

    public void create(UserInformation entity) {
        dataBase.getUsersInformation().add(entity);
    }

    @Override
    public UserInformation read(Long id) {
        return dataBase.getUsersInformation().get(id.intValue());
    }

    @Override
    public void update(UserInformation entity) {
        List<UserInformation> usersInformation = dataBase.getUsersInformation();

        int index = -1;

        for(UserInformation information : usersInformation){
            if(entity.equals(information)){
                index = usersInformation.indexOf(usersInformation);
                break;
            }
        }

        if(index >= 0){
            usersInformation.set(index, entity);
        }
        else create(entity);
    }

    @Override
    public void delete(Long id) {
        dataBase.getUsersInformation().remove(id.intValue());
    }
}
