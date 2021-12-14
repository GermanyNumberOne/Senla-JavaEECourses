package com.services.impl;

import com.dao.api.UserInfoDao;
import com.dto.UserInformationDto;
import com.model.UserInformation;
import com.services.api.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD

import java.util.List;
import java.util.stream.Collectors;
=======
>>>>>>> origin

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
<<<<<<< HEAD
    public List<UserInformationDto> getAll(){
        return userInfoDao.getAll().stream().map(value -> modelMapper.map(value, UserInformationDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
=======
>>>>>>> origin
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
