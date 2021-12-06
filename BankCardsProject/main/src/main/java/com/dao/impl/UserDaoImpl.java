package com.dao.impl;


import com.dao.api.UserDao;
import com.model.User;
import com.model.User_;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
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
}
