package com.controllers;

import com.controllers.api.UserInfoController;
import com.services.api.UserInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dto.UserInformationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoControllerImpl implements UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(String entity) throws JsonProcessingException {
        userInfoService.create(convertObject(entity));
    }

    @Override
    public UserInformationDto read(Long id) {
        return userInfoService.read(id);
    }

    public String getMappedObject(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(userInfoService.read(id));
    }

    public UserInformationDto convertObject(String object) throws JsonProcessingException {
        return objectMapper.readValue(object, UserInformationDto.class);
    }

    @Override
    public void update(String entity) throws JsonProcessingException {
        userInfoService.update(convertObject(entity));
    }

    @Override
    public void delete(Long id) {
        userInfoService.delete(id);
    }
}
