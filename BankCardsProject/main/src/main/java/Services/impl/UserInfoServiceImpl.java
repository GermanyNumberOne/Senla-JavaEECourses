package Services.impl;

import Services.api.UserInfoService;
import dao.api.UserDao;
import dao.api.UserInfoDao;
import dto.UserInformationDto;
import dto.UserInformationDto;
import lombok.RequiredArgsConstructor;
import model.UserInformation;
import model.UserInformation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private final UserInfoDao userInfoDao;
    @Autowired
    private ModelMapper modelMapper;


    protected UserInfoDao getDefaultDao() {
        return userInfoDao;
    }

    @Override
    public void create(UserInformationDto entity) {
        getDefaultDao().create(modelMapper.map(entity, UserInformation.class));
    }

    @Override
    public UserInformationDto read(Long id) {
        return modelMapper.map(getDefaultDao().read(id), UserInformationDto.class);
    }

    @Override
    public void update(UserInformationDto entity) {
        getDefaultDao().update(modelMapper.map(entity, UserInformation.class));
    }

    @Override
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
