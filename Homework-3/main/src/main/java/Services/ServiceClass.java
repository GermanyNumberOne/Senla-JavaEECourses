package Services;

import Annotations.Autowire;
import Annotations.Component;
import Services.api.Service;
import dao.SomeDaoClass;
import dao.api.Dao;

@Component
public class ServiceClass implements Service {
    @Autowire
    private Dao dataBase;

    public String doSomething(){
        return dataBase.doSomething();
    }
}
