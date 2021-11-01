package Controllers;

import Annotations.Autowire;
import Annotations.Component;
import Services.ServiceClass;
import Services.api.Service;

@Component
public class Controller {
    @Autowire
    private Service service;

    public String doSomething(){
        return service.doSomething();
    }

}
