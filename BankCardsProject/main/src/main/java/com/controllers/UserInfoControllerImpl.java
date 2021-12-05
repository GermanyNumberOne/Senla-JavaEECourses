package com.controllers;

import com.dto.UserInformationDto;
import com.services.api.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users-info")
public class UserInfoControllerImpl {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody UserInformationDto entity) {
        userInfoService.create(entity);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserInformationDto>> getAll(){
        List<UserInformationDto> userInfo = userInfoService.getAll();

        if(userInfo.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(userInfo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInformationDto> read(@PathVariable Long id) {
        UserInformationDto userInfo = userInfoService.read(id);

        if(userInfo == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(userInfo);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody UserInformationDto entity) {
        userInfoService.update(entity);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userInfoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
