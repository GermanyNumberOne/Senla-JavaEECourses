package com.senla.courses.project.dao.impl;

import com.senla.courses.project.dao.api.CardDao;
import com.senla.courses.project.model.Card;
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

    @Override
    public void transaction(String recipientCardNumber, Long money){
        Card card = findCardByNumber(recipientCardNumber);
        card.setMoney(card.getMoney() + money);

        update(card);
    }
}
