package dao.impl;

import dao.DataBase;
import dao.api.CardDao;
import model.BankAccount;
import model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardDaoImpl implements CardDao {
    @Autowired
    private DataBase dataBase;

    public void create(Card entity) {
        dataBase.getCards().add(entity);
    }

    @Override
    public Card read(Long id) {
        return dataBase.getCards().get(id.intValue());
    }

    @Override
    public void update(Card entity) {
        List<Card> cards = dataBase.getCards();

        int index = -1;

        for(Card card : cards){
            if(entity.equals(cards)){
                index = cards.indexOf(cards);
                break;
            }
        }

        if(index >= 0){
            cards.set(index, entity);
        }
        else create(entity);
    }

    @Override
    public void delete(Long id) {
        dataBase.getCards().remove(id.intValue());
    }
}
