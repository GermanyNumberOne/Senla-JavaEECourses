package com.services.impl;

import com.services.api.UserInfoService;
import com.dao.api.UserInfoDao;
import com.dto.UserInformationDto;
import lombok.RequiredArgsConstructor;
import com.model.UserInformation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoDao userInfoDao;

    private final ModelMapper modelMapper;

    protected UserInfoDao getDefaultDao() {
        return userInfoDao;
    }

    @Override
    @Transactional
    public void create(UserInformationDto entity) {
        getDefaultDao().create(modelMapper.map(entity, UserInformation.class));
    }

    @Override
    @Transactional
    public UserInformationDto read(Long id) {
        UserInformation userInfo = getDefaultDao().read(id);

        return userInfo == null ? null : modelMapper.map(userInfo, UserInformationDto.class);
    }

    @Override
    @Transactional
    public void update(UserInformationDto entity) {
        getDefaultDao().update(modelMapper.map(entity, UserInformation.class));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
