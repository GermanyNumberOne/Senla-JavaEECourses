package com.senla.courses.project.dao.api;

import com.senla.courses.project.model.User;

import java.util.List;

public interface UserDao extends Dao<User>{
    User findUserByIdByEntityGraph(Long id);

    User getUserByLogin(String login);

    List<User> getAllSortedByFirstname();

    List<User> getAllSortedBySurname();

    List<User> getAllSortedByCardsAmount();
}
