package dao.impl;

import dao.DataBase;
import dao.api.OperationDao;
import dto.OperationDto;
import model.BankAccount;
import model.Operation;
import model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OperationDaoImpl implements OperationDao {
    @Autowired
    private DataBase dataBase;

    public void create(Operation entity) {
        dataBase.getOperations().add(entity);
    }

    @Override
    public Operation read(Long id) {
        return dataBase.getOperations().get(id.intValue());
    }

    @Override
    public void update(Operation entity) {
        List<Operation> operations = dataBase.getOperations();

        int index = -1;

        for(Operation operation : operations){
            if(entity.equals(operation)){
                index = operations.indexOf(operation);
                break;
            }
        }

        if(index >= 0){
            operations.set(index, entity);
        }
        else create(entity);
    }

    @Override
    public void delete(Long id) {
        dataBase.getOperations().remove(id.intValue());
    }
}
