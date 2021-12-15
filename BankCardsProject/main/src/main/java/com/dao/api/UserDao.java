package com.dao.api;

import com.model.User;

import javax.persistence.NoResultException;
import java.util.List;

public interface UserDao extends Dao<User>{
    User findUserByIdByEntityGraph(Long id);
    User getUserByLogin(String login);
}
