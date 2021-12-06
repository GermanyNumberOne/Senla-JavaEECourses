package com;

import com.controllers.api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) throws JsonProcessingException{
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class.getPackage().getName());
        applicationContext.registerShutdownHook();

        try {

            BankAccountController bankAccountController = applicationContext.getBean(BankAccountController.class);
            bankAccountController.create("{\"id\":\"1\"" +
                    ",\"users\":[{\"id\":\"1\",\"firstname\":\"Jack\",\"surname\":\"Smith\",\"userCards\":null,\"userInfo\":null}]" +
                    ",\"operations\":null}");
            bankAccountController.create("{\"id\":\"2\",\"users\":null,\"operations\":null}");
            System.out.println(bankAccountController.getMappedObject(1L));
            bankAccountController.delete(2l);
            System.out.println(bankAccountController.getMappedObject(1L));

            System.out.println("-----------------------------------");


            UserController userController = applicationContext.getBean(UserController.class);
            userController.create("{\"id\":\"1\",\"firstname\":\"Jack\",\"surname\":null,\"userCards\":null,\"userInfo\":null,\"bankAccountId\":\"1\"}");
            userController.create("{\"id\":\"2\",\"firstname\":\"John\",\"surname\":null,\"userCards\":null,\"userInfo\":null}");
            System.out.println(userController.getMappedObject(1L));
            userController.delete(2l);
            userController.update("{\"id\":\"1\",\"firstname\":\"Jack\",\"surname\":\"Smith\",\"userCards\":null,\"userInfo\":null,\"bankAccountId\":\"1\"}");
            System.out.println(userController.getMappedObject(1L));

            System.out.println("-----------------------------------");

            CardController cardController = applicationContext.getBean(CardController.class);
            cardController.create("{\"id\":\"1\",\"number\":\"8825\",\"password\":\"123\",\"money\":\"20000\",\"userId\":\"1\"}");
            cardController.create("{\"id\":\"2\",\"number\":\"6284\",\"password\":\"123\",\"money\":\"20000\"}");
            System.out.println(cardController.readCardByNumber("8825"));
            cardController.deleteCardByNumber("6284");
            cardController.update("{\"id\":\"1\",\"number\":\"8825\",\"password\":\"234\",\"money\":\"20000\",\"userId\":\"1\"}");
            System.out.println(cardController.readCardByNumber("8825"));

            System.out.println("-----------------------------------");

            UserInfoController userInfoController = applicationContext.getBean(UserInfoController.class);
            userInfoController.create("{\"id\":\"1\",\"telephoneNumber\":null,\"address\":null,\"userId\":\"1\"}");
            userInfoController.create("{\"id\":\"3\",\"telephoneNumber\":null,\"address\":null}");
            System.out.println(userInfoController.getMappedObject(1L));
            userInfoController.delete(3l);
            userInfoController.update("{\"id\":\"1\",\"telephoneNumber\":\"123\",\"address\":null,\"userId\":\"1\"}");
            System.out.println(userInfoController.getMappedObject(1L));

            System.out.println("-----------------------------------");

            System.out.println("User JPQL: " + userController.findUserByIdByJPQL(1l));
            System.out.println("User Criteria: " + userController.findUserByIdByCriteria(1l));
            System.out.println("User Entity Graph: " + userController.findUserByIdByEntityGraph(1l));
        }
        catch (Exception e){
            e.printStackTrace();
        }


/*
        OperationController operationController = applicationContext.getBean(OperationController.class);
        operationController.create("{\"id\":\"1\",\"cost\":null,\"report\":{\"id\":\"1\",\"isSuccess\":null,\"operationId\":\"1\",\"operationCategories\":null}}");
        operationController.create("{\"id\":\"2\",\"cost\":null,\"report\":{\"id\":\"2\",\"isSuccess\":null,\"operationCategories\":null}}");
        System.out.println(operationController.getMappedObject(1L));
        operationController.delete(2l);
        operationController.update("{\"id\":\"1\",\"cost\":null,\"report\":null}");
        System.out.println(operationController.getMappedObject(1L));

        System.out.println("-----------------------------------");

        ReportController reportController = applicationContext.getBean(ReportController.class);
        reportController.create("{\"id\":\"1\",\"isSuccess\":null,\"operationId\":\"1\",\"operationCategories\":null}");
        reportController.create("{\"id\":\"2\",\"isSuccess\":null,\"operationCategories\":null}");
        System.out.println(reportController.getMappedObject(1L));
        reportController.delete(2l);
        reportController.update("{\"id\":\"1\",\"isSuccess\":null,\"operationCategories\":null}");
        System.out.println(reportController.getMappedObject(1L));

        */
    }
}
