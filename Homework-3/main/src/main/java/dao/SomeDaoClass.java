package dao;

import Annotations.Component;
import Annotations.Value;
import Services.ServiceClass;
import Services.api.Service;
import dao.api.Dao;

@Component
public class SomeDaoClass implements Dao{
    @Value("my.param.db")
    private String someText;

    public String doSomething(){
        return someText;
    }
}
