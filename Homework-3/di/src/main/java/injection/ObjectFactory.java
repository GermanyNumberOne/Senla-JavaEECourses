package injection;

import injection.exceptions.InjectionException;

import java.lang.reflect.InvocationTargetException;

public class ObjectFactory {

    public <T> T createBean(Class<T> someClass){
        try {
            return someClass.getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new InjectionException("Bean creation failed: ");
        }
    }
}
