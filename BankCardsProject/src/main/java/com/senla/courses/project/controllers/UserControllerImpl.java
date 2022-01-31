package com.senla.courses.project.controllers;

import com.senla.courses.project.dto.UserDto;
import com.senla.courses.project.dto.BankAccountDto;
import com.senla.courses.project.dto.OperationDto;
import com.senla.courses.project.dto.UserFilterDto;
import com.senla.courses.project.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserControllerImpl {
    @Autowired
    private UserService userService;

    @Secured("ROLE_ADMIN")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody UserDto dto) {
        userService.create(dto);
        return ResponseEntity.ok().build();
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> getAll(@RequestBody(required = false)UserFilterDto dto){
        List<UserDto> users;

        if(dto == null) {
            users = userService.getAll();
        }
        else {
            users = userService.getAllSortedBy(dto);
        }
        if (users.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> read(@PathVariable Long id) {
        UserDto user = userService.read(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(user);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody UserDto entity) {
        userService.update(entity);
        return ResponseEntity.ok().build();
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/users-bank",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BankAccountDto> getUserBankAccount(){
        return ResponseEntity.ok(userService.getUserBankAccount(SecurityContextHolder.getContext().getAuthentication().getName()));
    }

    @GetMapping(value = "/users-operations",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OperationDto>> getUsersOperations(){
        return ResponseEntity.ok(getUserBankAccount().getBody().getOperations());
    }
}
