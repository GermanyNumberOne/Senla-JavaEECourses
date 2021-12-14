package com.dao.api;

import com.model.User;
import java.util.List;

public interface UserDao extends Dao<User>{
    User findUserByIdByEntityGraph(Long id);
}
