package com.dao.impl;

import com.dao.api.CardDao;
import com.model.Card;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class CardDaoImpl extends AbstractDao<Card> implements CardDao {
    @Override
    protected Class<Card> getEntityClass() {
        return Card.class;
    }

    public Card findCardByNumber(String number) throws NoResultException {
        return entityManager.createQuery("select c from Card c where c.number = :number", Card.class)
                .setParameter("number", number)
                .getSingleResult();
    }

    public void deleteCardByNumber(String number) throws NoResultException {
        Card card = findCardByNumber(number);

        entityManager.createQuery("delete from Card c where c.number = :number")
                .setParameter("number", number)
                .executeUpdate();
    }
}
