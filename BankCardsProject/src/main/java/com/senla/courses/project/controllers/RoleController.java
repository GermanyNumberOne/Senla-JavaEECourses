package com.senla.courses.project.controllers;

import com.senla.courses.project.dto.RoleDto;
import com.senla.courses.project.services.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Secured("ROLE_ADMIN")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody RoleDto dto){
        roleService.create(dto);
        return ResponseEntity.ok().build();
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoleDto>> getAll(){
        List<RoleDto> roles = roleService.getAll();
        if(roles.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(roles);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDto> read(@PathVariable Long id) {
        RoleDto role = roleService.read(id);
        if (role == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return ResponseEntity.ok(role);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody RoleDto entity) {
        roleService.update(entity);
        return ResponseEntity.ok().build();
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }
}
