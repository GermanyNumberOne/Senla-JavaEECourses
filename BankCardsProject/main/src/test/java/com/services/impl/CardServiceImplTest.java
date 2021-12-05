package com.services.impl;

import com.dao.api.CardDao;
import com.dto.CardDto;
import com.model.Card;
import com.services.api.CardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CardServiceImplTest {

    private CardService cardService;

    @Mock
    private CardDao cardDao;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        modelMapper = mock(ModelMapper.class);
        cardDao = mock(CardDao.class);

        cardService = new CardServiceImpl(cardDao,modelMapper);
    }

    @Test
    void getAll() {
        assertTrue(cardService.getAll().size() == 0);
        Mockito.verify(cardDao, atLeastOnce()).getAll();
    }

    @Test
    void create() {
        CardDto card = new CardDto();

        cardService.create(card);
        Mockito.verify(cardDao, atLeastOnce()).create(modelMapper.map(card, Card.class));
    }

    @Test
    void read() {
        assertTrue(cardService.read(1l) == null);
        Mockito.verify(cardDao, atLeastOnce()).read(1l);
    }

    @Test
    void update() {
        CardDto card = new CardDto();

        cardService.update(card);
        Mockito.verify(cardDao, atLeastOnce()).update(modelMapper.map(card, Card.class));
    }

    @Test
    void readCardByNumber() {
        assertTrue(cardService.readCardByNumber("123") == null);
        Mockito.verify(cardDao, atLeastOnce()).findCardByNumber("123");
    }

    @Test
    void deleteCardByNumber() {
        cardService.deleteCardByNumber("123");
        Mockito.verify(cardDao).deleteCardByNumber("123");
    }

    @Test
    void delete() {
        cardService.delete(1l);
        Mockito.verify(cardDao, times(1)).delete(1l);
    }
}