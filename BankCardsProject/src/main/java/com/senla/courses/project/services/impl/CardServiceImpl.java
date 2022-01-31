package com.senla.courses.project.services.impl;

import com.senla.courses.project.dto.CardDto;
import com.senla.courses.project.dao.api.CardDao;
import com.senla.courses.project.dao.api.UserDao;
import com.senla.courses.project.dto.TransactionDto;
import com.senla.courses.project.exception.UserDoNotHavePermissionException;
import com.senla.courses.project.model.Card;
import com.senla.courses.project.model.User;
import com.senla.courses.project.model.enums.OperationCategories;
import com.senla.courses.project.services.api.CardService;
import com.senla.courses.project.services.api.OperationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardDao cardDao;

    private final ModelMapper modelMapper;

    private final UserDao userDao;

    private final OperationService operationService;

    public void addUserIdToCardDto(CardDto entity){
        if(entity.getUserId() != null)return;

        entity.setUserId(userDao.
                getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId());
    }

    public boolean isUserAllowed(Long id){
        User user = userDao.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        if(user.getRoles().stream()
                .anyMatch(role -> role.getRoleName().equals("ROLE_ADMIN"))) return true;

        return userDao
                .getUserByLogin(user.getLogin())
                .getUserCards().stream().anyMatch(card -> card.getId().equals(id));
    }

    public boolean isUserAllowed(String number){
        User user = userDao.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        if(user.getRoles().stream()
                .anyMatch(role -> role.getRoleName().equals("ROLE_ADMIN"))) return true;

        return userDao
                .getUserByLogin(user.getLogin())
                .getUserCards().stream().anyMatch(card -> card.getNumber().equals(number));
    }

    @Override
    @Transactional
    public List<CardDto> getAll(){
       return cardDao.getAll().stream().map(value -> modelMapper.map(value, CardDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(CardDto entity) {
        addUserIdToCardDto(entity);

        cardDao.create(modelMapper.map(entity, Card.class));
    }

    @Override
    @Transactional
    public CardDto read(Long id) {
        if(!isUserAllowed(id))throw new UserDoNotHavePermissionException("Access error");

        Card card = cardDao.read(id);

        return card == null ? null : modelMapper.map(card, CardDto.class);
    }

    @Override
    @Transactional
    public void transaction(TransactionDto entity){
        if(!isUserAllowed(entity.getUsersCardNumber()))throw new UserDoNotHavePermissionException("Access error");

        Card recipientCard = cardDao.findCardByNumber(entity.getRecipientCardNumber());
        if(recipientCard == null) throw new NoResultException("Recipient card not found");

        Card senderCard = cardDao.findCardByNumber(entity.getUsersCardNumber());
        if(senderCard.getMoney() < entity.getMoney()) throw new RuntimeException("insufficient funds on the card");
        senderCard.setMoney(senderCard.getMoney() - entity.getMoney());
        cardDao.update(senderCard);

        recipientCard.setMoney(recipientCard.getMoney() + entity.getMoney());
        cardDao.update(recipientCard);

        operationService.create(senderCard.getUser().getBankAccount().getId(),
                entity.getMoney(), OperationCategories.TRANSACTION.name(), true);
    }

    @Override
    @Transactional
    public void update(CardDto entity) {
        if(!isUserAllowed(entity.getId()))throw new UserDoNotHavePermissionException("Access error");

        cardDao.update(modelMapper.map(entity, Card.class));
    }

    @Override
    @Transactional
    public CardDto readCardByNumber(String number) throws NoResultException {
        if(!isUserAllowed(number)) throw new UserDoNotHavePermissionException("Access error");

        Card card = cardDao.findCardByNumber(number);

        return card == null ? null : modelMapper.map(card, CardDto.class);
    }

    @Transactional
    @Override
    public void deleteCardByNumber(String number){
        if(!isUserAllowed(number))throw new UserDoNotHavePermissionException("Access error");

        cardDao.deleteCardByNumber(number);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if(!isUserAllowed(id))throw new UserDoNotHavePermissionException("Access error");

        cardDao.delete(id);
    }

    @Override
    @Transactional
    public List<CardDto> getAllUserCards(String login){
        return userDao.getUserByLogin(login).getUserCards().stream().map(card -> modelMapper.map(card, CardDto.class)).collect(Collectors.toList());
    }
}
