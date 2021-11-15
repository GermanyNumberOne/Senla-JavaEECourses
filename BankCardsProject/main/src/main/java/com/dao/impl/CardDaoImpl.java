package com.dao.impl;

import com.annotations.Transaction;
import com.dao.DataBase;
import com.dao.api.CardDao;
import com.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class CardDaoImpl implements CardDao {
    @Autowired
    private DataBase dataBase;
    @Autowired
    private Connection connection;


    @Override
    @Transaction
    public void create(Card entity) {
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from cards where card_number='" + entity.getNumber() + "'");
            if(resultSet.next()){
                throw new Exception("card is already exists");
            }
            statement.executeUpdate("insert into cards values(" + entity.getNumber() + ", " + entity.getPassword()
            + ", " + entity.getMoney() + ", " + entity.getUser() + ")");
            statement.close();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //dataBase.getCards().add(entity);
    }

    @Override
    @Transaction
    public Card read(Long id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from cards where card_number='" + id.toString() + "'");
            if(resultSet.next()){
                Card card = new Card();
                card.setNumber(resultSet.getString("card_number"));
                card.setPassword(resultSet.getShort("password"));
                card.setMoney(resultSet.getLong("money"));
                statement.close();
                return card;
            }
            statement.close();
            throw new Exception("there are no such card");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
       // return dataBase.getCards().get(id.intValue());
    }

    @Override
    @Transaction
    public void update(Card entity) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("update cards set password=" + entity.getPassword() + ", money=" + entity.getMoney()
            + " where card_number=" + "'" + entity.getNumber() + "'" + ";");
            statement.close();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
       /* List<Card> cards = dataBase.getCards();

        int index = -1;

        for(Card card : cards){
            if(entity.equals(card)){
                index = cards.indexOf(card);
                break;
            }
        }

        if(index >= 0){
            cards.set(index, entity);
        }
        else create(entity);*/
    }

    @Override
    @Transaction
    public void delete(Long id) {
        try{
            Statement statement = connection.createStatement();
            statement.execute("delete from cards where card_number='" + id.toString() + "';");
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //dataBase.getCards().remove(id.intValue());
    }
}
