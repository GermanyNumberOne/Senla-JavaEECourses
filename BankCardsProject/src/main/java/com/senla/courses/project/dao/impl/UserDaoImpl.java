package com.senla.courses.project.dao.impl;


import com.senla.courses.project.dao.api.UserDao;
import com.senla.courses.project.dao.comparators.UserCardsAmountComparator;
import com.senla.courses.project.dao.comparators.UserFirstnameComparator;
import com.senla.courses.project.dao.comparators.UserSurnameComparator;
import com.senla.courses.project.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.NoResultException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    public User findUserByIdByEntityGraph(Long id) {
        EntityGraph graph = entityManager.createEntityGraph("graph.User");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", graph);

        User user = entityManager.find(User.class, id, hints);

        if(user == null) throw new NoResultException("no such entity");

        return user;
    }

    @Override
    public User getUserByLogin(String login) throws NoResultException {
        return entityManager.createQuery("select user from User user where user.login = :login", User.class)
                .setParameter("login", login)
                .getSingleResult();
    }

    @Override
    public List<User> getAllSortedByFirstname(){
        return getAllSortedBy(new UserFirstnameComparator());
    }

    @Override
    public List<User> getAllSortedBySurname(){
        return getAllSortedBy(new UserSurnameComparator());
    }

    @Override
    public List<User> getAllSortedByCardsAmount(){
        return getAllSortedBy(new UserCardsAmountComparator());
    }
}
