package com.dao.impl;

import com.dao.api.CardDao;
import com.model.Card;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class CardDaoImpl extends AbstractDao<Card> implements CardDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Card> getEntityClass() {
        return Card.class;
    }

    @Transactional
    public Card findCardByNumber(String number){
        return entityManager.createQuery("select c from Card c where c.number = :number", Card.class)
                .setParameter("number", number).getSingleResult();
    }
}
