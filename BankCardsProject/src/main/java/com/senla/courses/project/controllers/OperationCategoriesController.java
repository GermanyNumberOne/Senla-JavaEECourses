package com.senla.courses.project.controllers;

import com.senla.courses.project.dto.OperationCategoryDto;
import com.senla.courses.project.services.api.OperationCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operation-categories")
public class OperationCategoriesController {
    @Autowired
    private OperationCategoriesService operationCategoriesService;

    @Secured("ROLE_ADMIN")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody OperationCategoryDto dto){
        operationCategoriesService.create(dto);
        return ResponseEntity.ok().build();
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OperationCategoryDto>> getAll(){
        List<OperationCategoryDto> categories = operationCategoriesService.getAll();
        if(categories.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(categories);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OperationCategoryDto> read(@PathVariable Long id) {
        OperationCategoryDto category = operationCategoriesService.read(id);
        if (category == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return ResponseEntity.ok(category);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody OperationCategoryDto entity) {
        operationCategoriesService.update(entity);
        return ResponseEntity.ok().build();
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        operationCategoriesService.delete(id);
        return ResponseEntity.ok().build();
    }
}
