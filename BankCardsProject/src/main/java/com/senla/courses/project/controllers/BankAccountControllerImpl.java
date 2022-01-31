package com.senla.courses.project.controllers;

import com.senla.courses.project.dto.BankAccountDto;
import com.senla.courses.project.services.api.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;


@RestController
@RequestMapping(path = "/bank-accounts")
public class BankAccountControllerImpl {
    @Autowired
    private BankAccountService bankAccountService;

    @Secured("ROLE_ADMIN")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody BankAccountDto dto) {
        bankAccountService.create(dto);
        return ResponseEntity.ok().build();
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BankAccountDto>> getAll(){
        List<BankAccountDto> bankAccounts = bankAccountService.getAll();

        if(bankAccounts.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(bankAccounts);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BankAccountDto> read(@PathVariable Long id) {
        BankAccountDto bankAccount = bankAccountService.read(id);

        if(bankAccount == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(bankAccount);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody BankAccountDto entity) {
        bankAccountService.update(entity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        bankAccountService.delete(id);
        return ResponseEntity.ok().build();
    }
}
