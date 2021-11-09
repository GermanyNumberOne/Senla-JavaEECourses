package main;



import Controllers.api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import dto.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) throws JsonProcessingException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("Config", "main", "model", "dao", "Services", "Controllers");


        applicationContext.getBean(UserController.class).create(new UserDto());
        applicationContext.getBean(CardController.class).create(new CardDto());
        applicationContext.getBean(UserInfoController.class).create(new UserInformationDto());
        applicationContext.getBean(BankAccountController.class).create(new BankAccountDto());
        applicationContext.getBean(OperationController.class).create(new OperationDto());
        applicationContext.getBean(ReportController.class).create(new ReportDto());

        System.out.println(applicationContext.getBean(UserController.class).getMappedObject(1L));
        System.out.println(applicationContext.getBean(CardController.class).getMappedObject(1L));
        System.out.println(applicationContext.getBean(UserInfoController.class).getMappedObject(1L));
        System.out.println(applicationContext.getBean(BankAccountController.class).getMappedObject(1L));
        System.out.println(applicationContext.getBean(OperationController.class).getMappedObject(1L));
        System.out.println(applicationContext.getBean(ReportController.class).getMappedObject(1L));

        applicationContext.getBean(UserController.class).delete(0l);
        applicationContext.getBean(CardController.class).delete(0l);
        applicationContext.getBean(UserInfoController.class).delete(0l);
        applicationContext.getBean(BankAccountController.class).delete(0l);
        applicationContext.getBean(OperationController.class).delete(0l);
        applicationContext.getBean(ReportController.class).delete(0l);

        applicationContext.getBean(UserController.class).update(applicationContext.getBean(UserController.class).read(0l));
        applicationContext.getBean(CardController.class).update(applicationContext.getBean(CardController.class).read(0l));
        applicationContext.getBean(UserInfoController.class).update(applicationContext.getBean(UserInfoController.class).read(0l));
        applicationContext.getBean(BankAccountController.class).update(applicationContext.getBean(BankAccountController.class).read(0l));
        applicationContext.getBean(OperationController.class).update(applicationContext.getBean(OperationController.class).read(0l));
        applicationContext.getBean(ReportController.class).update(applicationContext.getBean(ReportController.class).read(0l));

    }
}
