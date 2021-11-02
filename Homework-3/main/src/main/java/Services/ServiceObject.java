package Services;

import Annotations.Autowire;
import Annotations.Component;
import Services.api.Service;
import dao.api.DataBase;

@Component
public class ServiceObject implements Service {
    @Autowire
    private DataBase dataBase;

    public String doSomething(){
        return dataBase.doSomething();
    }
}
