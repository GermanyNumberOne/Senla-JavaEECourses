package com.dao.api;

import com.dao.impl.CardDaoImpl;
import com.model.Card;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {CardDaoImpl.class})
class CardDaoTest extends DaoTest {
    @Autowired
    private CardDao cardDao;

    @Test
    @Transactional
    public void create(){
        Card card = new Card();
        card.setNumber("1234");

        cardDao.create(card);
    }

    @Test
    @Transactional
    public void read(){
        assertTrue(cardDao.read(1l) == null);
    }

    @Test
    @Transactional
    public void update(){
        Card card = new Card();
        card.setNumber("1234");

        cardDao.update(card);
    }

    @Test
    @Transactional
    public void delete(){
        cardDao.delete(1l);
    }

    @Test
    void findCardByNumber() {
        assertThrows(NoResultException.class, () -> {
            cardDao.findCardByNumber("123");
        });

    }

    @Test
    void deleteCardByNumber() {
        cardDao.deleteCardByNumber("123");
    }

}