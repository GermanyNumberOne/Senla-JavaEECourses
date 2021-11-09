package Controllers;

import Controllers.api.OperationController;
import Services.api.OperationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.OperationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationControllerImpl implements OperationController {
    @Autowired
    private OperationService operationService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(OperationDto entity) {
        operationService.create(entity);
    }

    @Override
    public OperationDto read(Long id) {
        return operationService.read(id);
    }

    public String getMappedObject(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(operationService.read(id));
    }

    @Override
    public void update(OperationDto entity) {
        operationService.update(entity);
    }

    @Override
    public void delete(Long id) {
        operationService.delete(id);
    }
}
