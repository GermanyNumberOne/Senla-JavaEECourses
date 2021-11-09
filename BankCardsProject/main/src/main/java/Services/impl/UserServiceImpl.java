package Services.impl;

import Services.api.UserService;
import dao.api.UserDao;
import dto.UserDto;
import dto.UserDto;
import lombok.RequiredArgsConstructor;
import model.User;
import model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserDao userDao;
    @Autowired
    private final ModelMapper modelMapper;


    protected UserDao getDefaultDao() {
        return userDao;
    }

    @Override
    public void create(UserDto entity) {
        getDefaultDao().create(modelMapper.map(entity, User.class));
    }

    @Override
    public UserDto read(Long id) {
        return modelMapper.map(getDefaultDao().read(id), UserDto.class);
    }

    @Override
    public void update(UserDto entity) {
        getDefaultDao().update(modelMapper.map(entity, User.class));
    }

    @Override
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
