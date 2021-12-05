package com.services.impl;

import com.model.UserInformation;
import com.services.api.CardService;
import com.dao.api.CardDao;
import com.dto.CardDto;
import lombok.RequiredArgsConstructor;
import com.model.Card;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardDao cardDao;

    private final ModelMapper modelMapper;


    protected CardDao getDefaultDao() {
        return cardDao;
    }

    @Override
    @Transactional
    public void create(CardDto entity) {
        getDefaultDao().create(modelMapper.map(entity, Card.class));
    }

    @Override
    @Transactional
    public CardDto read(Long id) {
        Card card = cardDao.read(id);

        return card == null ? null : modelMapper.map(card, CardDto.class);
    }

    @Override
    @Transactional
    public void update(CardDto entity) {
        getDefaultDao().update(modelMapper.map(entity, Card.class));
    }

    @Transactional
    public CardDto readCardByNumber(String number){
        Card card = getDefaultDao().findCardByNumber(number);

        return card == null ? null : modelMapper.map(card, CardDto.class);
    }

    @Transactional
    @Override
    public void deleteCardByNumber(String number){
        getDefaultDao().deleteCardByNumber(number);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
