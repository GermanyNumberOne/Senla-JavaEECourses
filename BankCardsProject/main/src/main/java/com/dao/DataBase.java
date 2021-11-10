package com.dao;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import com.model.*;
import org.springframework.stereotype.Component;

@Data
@Component
public class DataBase {

    private List<BankAccount> bankAccounts = new ArrayList<>();

    private List<Card> cards = new ArrayList<>();

    private List<Operation> operations = new ArrayList<>();

    private List<Report> reports = new ArrayList<>();

    private List<User> users = new ArrayList<>();

    private List<UserInformation> usersInformation = new ArrayList<>();
}
