package com.dao.impl;

import com.dao.api.CardDao;
import com.model.Card;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class CardDaoImpl extends AbstractDao<Card> implements CardDao {
    @Override
    protected Class<Card> getEntityClass() {
        return Card.class;
    }

    public Card findCardByNumber(String number){
        return entityManager.createQuery("select c from Card c where c.number = :number", Card.class)
                .setParameter("number", number).getSingleResult();
    }

    public void deleteCardByNumber(String number){
        entityManager.createQuery("delete from Card c where c.number = :number").setParameter("number", number).executeUpdate();
    }
}
