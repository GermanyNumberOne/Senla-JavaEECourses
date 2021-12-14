package com.services.impl;

import com.dto.BankAccountDto;
import com.dto.OperationDto;
import com.model.Operation;
import com.model.UserInformation;
import com.services.api.CardService;
import com.dao.api.CardDao;
import com.dto.CardDto;
import lombok.RequiredArgsConstructor;
import com.model.Card;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardDao cardDao;

    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public List<CardDto> getAll(){
       return cardDao.getAll().stream().map(value -> modelMapper.map(value, CardDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(CardDto entity) {
        cardDao.create(modelMapper.map(entity, Card.class));
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
        cardDao.update(modelMapper.map(entity, Card.class));
    }

    @Transactional
    public CardDto readCardByNumber(String number) throws NoResultException {
        Card card = cardDao.findCardByNumber(number);

        return card == null ? null : modelMapper.map(card, CardDto.class);
    }

    @Transactional
    @Override
    public void deleteCardByNumber(String number){
        cardDao.deleteCardByNumber(number);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cardDao.delete(id);
    }
}
