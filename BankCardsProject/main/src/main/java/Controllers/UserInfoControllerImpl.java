package Controllers;

import Controllers.api.UserInfoController;
import Services.api.UserInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UserInformationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoControllerImpl implements UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(UserInformationDto entity) {
        userInfoService.create(entity);
    }

    @Override
    public UserInformationDto read(Long id) {
        return userInfoService.read(id);
    }

    public String getMappedObject(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(userInfoService.read(id));
    }

    @Override
    public void update(UserInformationDto entity) {
        userInfoService.update(entity);
    }

    @Override
    public void delete(Long id) {
        userInfoService.delete(id);
    }
}
