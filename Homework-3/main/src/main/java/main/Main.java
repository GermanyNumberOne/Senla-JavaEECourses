package main;

import Controllers.Controller;
import injection.ApplicationContext;
import injection.DependencyInjector;

public class Main {
    public static void main(String[] args){
        ApplicationContext context = new ApplicationContext();
        DependencyInjector.run(Main.class, context);

        System.out.println(context.getBean(Controller.class).doSomething());


    }
}
