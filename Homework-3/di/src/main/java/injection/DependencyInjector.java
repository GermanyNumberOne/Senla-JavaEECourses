package injection;


import injection.exceptions.InjectionException;

public class DependencyInjector {
    public static void run(Class<?> startClass, ApplicationContext applicationContext){
        try {
            ClassScanner scanner = new ClassScanner();
            ObjectFactory factory = new ObjectFactory();
            applicationContext.setFactory(factory);
            applicationContext.createContext(scanner.findClasses(startClass));
        } catch (IllegalAccessException e){
            throw new InjectionException("Message", e);
        }
    }
}
