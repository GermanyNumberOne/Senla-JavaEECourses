package dao;

import java.util.List;

import lombok.Data;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Data
@Component
public class DataBase {
    @Autowired
    private List<BankAccount> bankAccounts;
    @Autowired
    private List<Card> cards;
    @Autowired
    private List<Operation> operations;
    @Autowired
    private List<Report> reports;
    @Autowired
    private List<User> users;
    @Autowired
    private List<UserInformation> usersInformation;
}
