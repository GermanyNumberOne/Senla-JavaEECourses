package com.services.impl;

import com.services.api.CardService;
import com.dao.api.CardDao;
import com.dto.CardDto;
import lombok.RequiredArgsConstructor;
import com.model.Card;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardDao cardDao;

    private final ModelMapper modelMapper;


    protected CardDao getDefaultDao() {
        return cardDao;
    }

    @Override
    public void create(CardDto entity) {
        getDefaultDao().create(modelMapper.map(entity, Card.class));
    }

    @Override
    public CardDto read(Long id) {
        return modelMapper.map(getDefaultDao().read(id), CardDto.class);
    }

    @Override
    public void update(CardDto entity) {
        getDefaultDao().update(modelMapper.map(entity, Card.class));
    }

    @Override
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
