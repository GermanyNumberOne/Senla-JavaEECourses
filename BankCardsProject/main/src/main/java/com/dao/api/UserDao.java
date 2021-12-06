package com.dao.api;

import com.model.User;
import java.util.List;

public interface UserDao extends Dao<User>{
    List<User> findUserByNameByJPQL(String name);
    User findUserByIdByEntityGraph(Long id);
    User findUserByIdByCriteria(Long id);
    User findUserByIdByJPQL(Long id);
}
