package Controllers;

import Annotations.Autowire;
import Annotations.Component;
import Controllers.api.Controller;
import Services.api.Service;

@Component
public class ControllerObject implements Controller {
    @Autowire
    private Service service;

    public String doSomething(){
        return service.doSomething();
    }

}
