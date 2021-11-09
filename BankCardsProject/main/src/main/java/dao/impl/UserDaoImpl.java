package dao.impl;

import dao.DataBase;
import dao.api.UserDao;
import dto.UserDto;
import model.User;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private DataBase dataBase;

    public void create(User entity) {
        dataBase.getUsers().add(entity);
    }

    @Override
    public User read(Long id) {
        return dataBase.getUsers().get(id.intValue());
    }

    @Override
    public void update(User entity) {
        List<User> users = dataBase.getUsers();
        int index = -1;


        for(User user : users){
            if(entity.equals(user)){
                index = users.indexOf(user);
                break;
            }
        }

        if(index >= 0){
            users.set(index, entity);
        }
        else create(entity);
    }

    @Override
    public void delete(Long id) {
        dataBase.getUsers().remove(id.intValue());
    }
}
