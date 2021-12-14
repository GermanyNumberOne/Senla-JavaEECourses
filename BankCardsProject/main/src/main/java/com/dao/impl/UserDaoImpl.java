package com.dao.impl;


import com.dao.api.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.NoResultException;
import java.util.HashMap;
import java.util.Map;


@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void create(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        super.create(entity);
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
}
