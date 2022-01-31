package com.senla.courses.project.controllers;

import com.senla.courses.project.dto.ReportDto;
import com.senla.courses.project.services.api.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reports")
public class ReportControllerImpl {
    @Autowired
    private ReportService reportService;

    @Secured("ROLE_ADMIN")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody ReportDto entity) {
        reportService.create(entity);
        return ResponseEntity.ok().build();
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReportDto>> getAll(){
        List<ReportDto> reports = reportService.getAll();

        if(reports.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(reports);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReportDto> read(@PathVariable Long id) {
        ReportDto report = reportService.read(id);

        if(report == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(report);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody ReportDto entity) {
        reportService.update(entity);
        return ResponseEntity.ok().build();
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        reportService.delete(id);
        return ResponseEntity.ok().build();
    }
}
