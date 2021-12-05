package com.controllers;

import com.dto.OperationDto;
import com.dto.ReportDto;
import com.services.api.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/operations")
//@RequiredArgsConstructor
public class OperationControllerImpl {
    @Autowired
    private OperationService operationService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody OperationDto entity) {
        operationService.create(entity);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OperationDto>> getAll(){
        List<OperationDto> operations = operationService.getAll();

        if(operations.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(operations);
    }


    @GetMapping("/{id}")
    public ResponseEntity<OperationDto> read(@PathVariable Long id) {
        OperationDto operation = operationService.read(id);

        if(operation == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(operation);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody OperationDto entity) {
        operationService.update(entity);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        operationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
