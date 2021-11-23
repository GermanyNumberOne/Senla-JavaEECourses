package com.services.impl;

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
        return modelMapper.map(getDefaultDao().read(id), CardDto.class);
    }

    @Override
    @Transactional
    public void update(CardDto entity) {
        getDefaultDao().update(modelMapper.map(entity, Card.class));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
