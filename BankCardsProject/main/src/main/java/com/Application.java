package com;

import com.controllers.api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dto.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void Run() throws JsonProcessingException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class.getPackage().getName());
        ObjectMapper objectMapper = applicationContext.getBean(ObjectMapper.class);

        UserController userController = applicationContext.getBean(UserController.class);
        CardController cardController = applicationContext.getBean(CardController.class);
        UserInfoController userInfoController = applicationContext.getBean(UserInfoController.class);
        BankAccountController bankAccountController = applicationContext.getBean(BankAccountController.class);
        OperationController operationController = applicationContext.getBean(OperationController.class);
        ReportController reportController = applicationContext.getBean(ReportController.class);

        userController.create(objectMapper.writeValueAsString(new UserDto()));
        cardController.create(objectMapper.writeValueAsString(new CardDto()));
        userInfoController.create(objectMapper.writeValueAsString(new UserInformationDto()));
        bankAccountController.create(objectMapper.writeValueAsString(new BankAccountDto()));
        operationController.create(objectMapper.writeValueAsString(new OperationDto()));
        reportController.create(objectMapper.writeValueAsString(new ReportDto()));

        userController.create(objectMapper.writeValueAsString(new UserDto()));
        cardController.create(objectMapper.writeValueAsString(new CardDto()));
        userInfoController.create(objectMapper.writeValueAsString(new UserInformationDto()));
        bankAccountController.create(objectMapper.writeValueAsString(new BankAccountDto()));
        operationController.create(objectMapper.writeValueAsString(new OperationDto()));
        reportController.create(objectMapper.writeValueAsString(new ReportDto()));


        System.out.println("-----------------------------------");
        System.out.println(userController.getMappedObject(1L));
        System.out.println(cardController.getMappedObject(1L));
        System.out.println(userInfoController.getMappedObject(1L));
        System.out.println(bankAccountController.getMappedObject(1L));
        System.out.println(operationController.getMappedObject(1L));
        System.out.println(reportController.getMappedObject(1L));
        System.out.println("-----------------------------------");

        userController.delete(0l);
        cardController.delete(0l);
        userInfoController.delete(0l);
        bankAccountController.delete(0l);
        operationController.delete(0l);
        reportController.delete(0l);

        userController.update(userController.read(0L));
        cardController.update(cardController.read(0L));
        userInfoController.update(userInfoController.read(0L));
        bankAccountController.update(bankAccountController.read(0L));
        operationController.update(operationController.read(0L));
        reportController.update(reportController.read(0L));

        System.out.println(userController.getMappedObject(0L));
        System.out.println(cardController.getMappedObject(0L));
        System.out.println(userInfoController.getMappedObject(0L));
        System.out.println(bankAccountController.getMappedObject(0L));
        System.out.println(operationController.getMappedObject(0L));
        System.out.println(reportController.getMappedObject(0L));

    }
}
