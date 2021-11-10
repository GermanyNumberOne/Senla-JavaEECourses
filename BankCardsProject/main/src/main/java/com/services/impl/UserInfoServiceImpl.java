package com.services.impl;

import com.services.api.UserInfoService;
import com.dao.api.UserInfoDao;
import com.dto.UserInformationDto;
import lombok.RequiredArgsConstructor;
import com.model.UserInformation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoDao userInfoDao;

    private final ModelMapper modelMapper;

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
