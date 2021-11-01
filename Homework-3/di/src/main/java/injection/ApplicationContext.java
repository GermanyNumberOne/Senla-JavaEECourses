package injection;

import Annotations.Autowire;
import Annotations.Component;
import Annotations.Value;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class ApplicationContext {
    private final Map<Class<?>, Object> context;
    private final Map<Class<?>, Class<?>> classInterfaceMap;
    private ObjectFactory factory;

    public ApplicationContext(){
        this.context = new HashMap<>();
        this.classInterfaceMap = new HashMap<>();
    }

    public void setFactory(ObjectFactory factory) {
        this.factory = factory;
    }

    public void createContext(Set<Class<?>> classes) throws IllegalAccessException {
        for(Class<?> someClass : classes){
            if(!someClass.isAnnotationPresent(Component.class)){
                continue;
            }

            Class<?>[] interfaces = someClass.getInterfaces();

            if(interfaces.length == 0){
                classInterfaceMap.put(someClass, someClass);
                continue;
            }

            for(Class<?> interfaceKey : interfaces){
                if(!classInterfaceMap.containsValue(interfaceKey)){
                    classInterfaceMap.put(someClass, interfaceKey);
                }
            }
        }
        fillContext();
    }

    private void fillContext() throws IllegalAccessException {
        for(Class<?> someClass : classInterfaceMap.keySet()){
            Object bean = factory.createBean(someClass);
            context.put(someClass, bean);
            injectDependencies(someClass, bean);
        }
    }

    private void injectDependencies(Class<?> someClass, Object bean) throws IllegalAccessException {
        Field[] declaredFields = someClass.getDeclaredFields();

        for (Field field : declaredFields){

            if(field.isAnnotationPresent(Value.class)){
                Object object = injectPropertiesValue((field.getAnnotation(Value.class)).value());
                field.setAccessible(true);
                field.set(bean, object);
            }


            if(!field.isAnnotationPresent(Autowire.class)){
                continue;
            }

            Object object = this.getBean(field.getType());

            if(object == null){
                object = factory.createBean(field.getType());
            }

            field.setAccessible(true);
            field.set(bean, object);
            injectDependencies(object.getClass(), object);
        }
    }

    private <T> T injectPropertiesValue(String value){
        ResourceBundle rb = ResourceBundle.getBundle("application");

        Object bean = rb.getObject(value);

        return (T) bean;
    }

    public <T> T getBean(Class<T> type){
        Set<Map.Entry<Class<?>, Class<?>>> classSet = classInterfaceMap.entrySet()
                .stream().filter(entry -> type.equals(entry.getValue()))
                .collect(Collectors.toSet());

        if(classSet.size() != 1) {
            //throw new InjectionException("Getting bean error");
            return null;
        }

        Class<?> someClass = classSet.stream()
                .findFirst()
                .get()
                .getKey();

        if(context.containsKey(someClass)){
            return (T) context.get(someClass);
        }

        Object bean = factory.createBean(someClass);
        context.put(someClass, bean);

        return (T) bean;
    }
}
