package com;

public class Application {
    /*public static void main(String[] args) throws JsonProcessingException{
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class.getPackage().getName());
        applicationContext.registerShutdownHook();

        UserController userController = applicationContext.getBean(UserController.class);
        CardController cardController = applicationContext.getBean(CardController.class);
        UserInfoController userInfoController = applicationContext.getBean(UserInfoController.class);
        BankAccountController bankAccountController = applicationContext.getBean(BankAccountController.class);

        bankAccountController.create("{\"id\":\"2\",\"cards\":null,\"operations\":null}");
        cardController.create("{\"id\":\"1\",\"number\":\"8825\",\"password\":\"123\",\"money\":\"20000\",\"userId\":\"71\"}");
        userInfoController.create("{\"id\":\"1\",\"telephoneNumber\":null,\"address\":null,\"userId\":\"71\"}");
        userController.create("{\"id\":\"71\",\"firstname\":\"Sam\",\"surname\":null,\"userCards\":\"8825\",\"userInfo\":\"1\"}");




        System.out.println("EntityGraph : " + userController.findUserByIdByEntityGraph(70L));
        System.out.println("JPQL : " + userController.findUserByIdByJPQL(70L));
        System.out.println("Criteria" + userController.findUserByIdByCriteria(70L));


        userController.create("{\"id\":\"70\",\"firstname\":\"Sam\",\"surname\":null,\"userCards\":null,\"userInfo\":null}");
        System.out.println("JPQL : " + userController.findUserByIdByJPQL(70L));
        System.out.println("Criteria" + userController.findUserByIdByCriteria(70L));
        userController.create("{\"id\":\"71\",\"firstname\":\"Cheaf\",\"surname\":null,\"userCards\":null,\"userInfo\":null}");

        System.out.println("EntityGraph : " + userController.findUserByIdByEntityGraph(70L));
        System.out.println("JPQL : " + userController.findUserByIdByJPQL(70L));
        userController.delete(71l);
        userController.update("{\"id\":\"70\",\"firstname\":null,\"surname\":null,\"userCards\":null,\"userInfo\":null}");
        System.out.println("Criteria" + userController.findUserByIdByCriteria(70L));

        System.out.println("-----------------------------------");

        CardController cardController = applicationContext.getBean(CardController.class);
        cardController.create("{\"id\":\"1\",\"number\":\"8825\",\"password\":\"123\",\"money\":\"20000\"}");
        cardController.create("{\"id\":\"2\",\"number\":\"6284\",\"password\":\"123\",\"money\":\"20000\"}");
        System.out.println(cardController.readCardByNumber("6284"));
        cardController.deleteCardByNumber("8825");
        cardController.update("{\"id\":\"2\",\"number\":\"6284\",\"password\":\"223\",\"money\":null}");
        System.out.println(cardController.getMappedObject(2L));

        System.out.println("-----------------------------------");

        UserInfoController userInfoController = applicationContext.getBean(UserInfoController.class);
        userInfoController.create("{\"id\":\"1\",\"telephoneNumber\":null,\"address\":null}");
        userInfoController.create("{\"id\":\"2\",\"telephoneNumber\":null,\"address\":null}");
        System.out.println(userInfoController.getMappedObject(2L));
        userInfoController.delete(1l);
        userInfoController.update("{\"id\":\"2\",\"telephoneNumber\":null,\"address\":null}");
        System.out.println(userInfoController.getMappedObject(0L));

        System.out.println("-----------------------------------");

        BankAccountController bankAccountController = applicationContext.getBean(BankAccountController.class);
        bankAccountController.create("{\"id\":\"1\",\"cards\":null,\"operations\":null}");
        bankAccountController.create("{\"id\":\"2\",\"cards\":null,\"operations\":null}");
        System.out.println(bankAccountController.getMappedObject(1L));
        bankAccountController.delete(2l);
        bankAccountController.update("{\"id\":\"1\",\"cards\":null,\"operations\":null}");
        System.out.println(bankAccountController.getMappedObject(1L));

        System.out.println("-----------------------------------");

        OperationController operationController = applicationContext.getBean(OperationController.class);
        operationController.create("{\"id\":\"1\",\"cost\":null,\"report\":null}");
        operationController.create("{\"id\":\"2\",\"cost\":null,\"report\":null}");
        System.out.println(operationController.getMappedObject(1L));
        operationController.delete(2l);
        operationController.update("{\"id\":\"1\",\"cost\":null,\"report\":null}");
        System.out.println(operationController.getMappedObject(1L));

        System.out.println("-----------------------------------");

        ReportController reportController = applicationContext.getBean(ReportController.class);
        reportController.create("{\"id\":\"1\",\"isSuccess\":null,\"operationCategories\":null}");
        reportController.create("{\"id\":\"2\",\"isSuccess\":null,\"operationCategories\":null}");
        System.out.println(reportController.getMappedObject(1L));
        reportController.delete(2l);
        reportController.update("{\"id\":\"1\",\"isSuccess\":null,\"operationCategories\":null}");
        System.out.println(reportController.getMappedObject(1L));

        

    }*/
}
