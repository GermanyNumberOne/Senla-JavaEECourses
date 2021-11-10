package com;

import com.controllers.api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dto.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) throws JsonProcessingException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class.getPackage().getName());

        UserController userController = applicationContext.getBean(UserController.class);
        userController.create("{\"id\":null,\"name\":null,\"surname\":null,\"cards\":null,\"userInfo\":null}");
        userController.create("{\"id\":null,\"name\":null,\"surname\":null,\"cards\":null,\"userInfo\":null}");
        System.out.println(userController.getMappedObject(1L));
        userController.delete(0l);
        userController.update("{\"id\":null,\"name\":null,\"surname\":null,\"cards\":null,\"userInfo\":null}");
        System.out.println(userController.getMappedObject(0L));

        System.out.println("-----------------------------------");

        CardController cardController = applicationContext.getBean(CardController.class);
        cardController.create("{\"id\":null,\"number\":null,\"password\":null,\"money\":null}");
        cardController.create("{\"id\":null,\"number\":null,\"password\":null,\"money\":null}");
        System.out.println(cardController.getMappedObject(1L));
        cardController.delete(0l);
        cardController.update("{\"id\":null,\"number\":null,\"password\":null,\"money\":null}");
        System.out.println(cardController.getMappedObject(0L));

        System.out.println("-----------------------------------");

        UserInfoController userInfoController = applicationContext.getBean(UserInfoController.class);
        userInfoController.create("{\"id\":null,\"telephoneNumber\":null,\"address\":null}");
        userInfoController.create("{\"id\":null,\"telephoneNumber\":null,\"address\":null}");
        System.out.println(userInfoController.getMappedObject(1L));
        userInfoController.delete(0l);
        userInfoController.update("{\"id\":null,\"telephoneNumber\":null,\"address\":null}");
        System.out.println(userInfoController.getMappedObject(0L));

        System.out.println("-----------------------------------");

        BankAccountController bankAccountController = applicationContext.getBean(BankAccountController.class);
        bankAccountController.create("{\"id\":null,\"cards\":null,\"operations\":null}");
        bankAccountController.create("{\"id\":null,\"cards\":null,\"operations\":null}");
        System.out.println(bankAccountController.getMappedObject(1L));
        bankAccountController.delete(0l);
        bankAccountController.update("{\"id\":null,\"cards\":null,\"operations\":null}");
        System.out.println(bankAccountController.getMappedObject(0L));

        System.out.println("-----------------------------------");

        OperationController operationController = applicationContext.getBean(OperationController.class);
        operationController.create("{\"id\":null,\"cost\":null,\"report\":null}");
        operationController.create("{\"id\":null,\"cost\":null,\"report\":null}");
        System.out.println(operationController.getMappedObject(1L));
        operationController.delete(0l);
        operationController.update("{\"id\":null,\"cost\":null,\"report\":null}");
        System.out.println(operationController.getMappedObject(0L));

        System.out.println("-----------------------------------");

        ReportController reportController = applicationContext.getBean(ReportController.class);
        reportController.create("{\"id\":null,\"isSuccess\":null,\"operationCategories\":null}");
        reportController.create("{\"id\":null,\"isSuccess\":null,\"operationCategories\":null}");
        System.out.println(reportController.getMappedObject(1L));
        reportController.delete(0l);
        reportController.update("{\"id\":null,\"isSuccess\":null,\"operationCategories\":null}");
        System.out.println(reportController.getMappedObject(0L));
    }
}
