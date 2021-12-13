package com.dao.api;

import com.model.User;

public interface UserDao extends Dao<User>{
    User findUserByIdByEntityGraph(Long id);
}
