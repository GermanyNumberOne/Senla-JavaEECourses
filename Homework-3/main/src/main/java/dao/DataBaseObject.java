package dao;

import Annotations.Component;
import Annotations.Value;
import dao.api.DataBase;

@Component
public class DataBaseObject implements DataBase {
    @Value("my.param.db")
    private String someText;

    public String doSomething(){
        return someText;
    }
}
