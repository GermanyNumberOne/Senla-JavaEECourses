package com.senla.courses.project.controllers;

import com.senla.courses.project.dto.OperationDto;
import com.senla.courses.project.services.api.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/operations")
public class OperationControllerImpl {
    @Autowired
    private OperationService operationService;

    @Secured("ROLE_ADMIN")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody OperationDto entity) {
        operationService.create(entity);
        return ResponseEntity.ok().build();
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OperationDto>> getAll(){
        List<OperationDto> operations = operationService.getAll();

        if(operations.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(operations);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OperationDto> read(@PathVariable Long id) {
        OperationDto operation = operationService.read(id);

        if(operation == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(operation);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody OperationDto entity) {
        operationService.update(entity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        operationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
