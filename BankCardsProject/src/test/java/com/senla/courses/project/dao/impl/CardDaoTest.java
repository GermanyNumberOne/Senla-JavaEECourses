package com.senla.courses.project.dao.impl;

import com.senla.courses.project.dao.api.CardDao;
import com.senla.courses.project.model.Card;
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
        assertThrows(NoResultException.class, () -> {
            cardDao.read(1l);
        });
    }

    @Test
    @Transactional
    public void update(){
        create();

        Card card = cardDao.getAll().get(0);
        card.setPassword((short)123);

        cardDao.update(card);

        assertTrue(cardDao.getAll().size() == 1);
    }

    @Test
    @Transactional
    public void delete(){
        assertThrows(NoResultException.class, () -> {
            cardDao.delete(1l);
        });
    }

    @Test
    @Transactional
    void findCardByNumber() {
        assertThrows(NoResultException.class, () -> {
            cardDao.findCardByNumber("123");
        });

    }

    @Test
    @Transactional
    void deleteCardByNumber() {
        assertThrows(NoResultException.class, () -> {
           cardDao.deleteCardByNumber("123");
        });
    }

}