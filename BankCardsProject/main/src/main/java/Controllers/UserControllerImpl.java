package Controllers;

import Controllers.api.UserController;
import Services.api.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UserDto;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(UserDto entity) {
        userService.create(entity);
    }

    @Override
    public UserDto read(Long id) {
        return userService.read(id);
    }

    public String getMappedObject(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(userService.read(id));
    }

    @Override
    public void update(UserDto entity) {
        userService.update(entity);
    }

    @Override
    public void delete(Long id) {
        userService.delete(id);
    }
}
