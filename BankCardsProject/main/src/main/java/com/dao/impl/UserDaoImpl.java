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

    public List<User> findUserByNameByJPQL(String name){
        Query query = entityManager.createQuery("select u from User u where u.firstname = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }


    public User findUserByIdByJPQL(Long id){
        return entityManager.createQuery("SELECT user FROM User user JOIN FETCH user.userCards cards" +
                    " JOIN FETCH user.userInfo info" +
                    " JOIN FETCH user.bankAccount" +
                    " where user.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public User findUserByIdByCriteria(Long id){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        root.fetch(User_.userCards, JoinType.INNER);
        root.fetch(User_.userInfo, JoinType.INNER);
        root.fetch(User_.bankAccount, JoinType.INNER);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public User findUserByIdByEntityGraph(Long id){
        EntityGraph graph = entityManager.createEntityGraph("graph.User");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", graph);

        return entityManager.find(User.class, id, hints);
    }
}
