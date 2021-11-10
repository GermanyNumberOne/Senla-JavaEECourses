package com.controllers;

import com.controllers.api.ReportController;
import com.services.api.ReportService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dto.ReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportControllerImpl implements ReportController {
    @Autowired
    private ReportService reportService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(String entity) throws JsonProcessingException {
        reportService.create(convertObject(entity));
    }

    @Override
    public ReportDto read(Long id) {
        return reportService.read(id);
    }

    public String getMappedObject(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(reportService.read(id));
    }

    public ReportDto convertObject(String object) throws JsonProcessingException {
        return objectMapper.readValue(object, ReportDto.class);
    }

    @Override
    public void update(String entity) throws JsonProcessingException {
        reportService.update(convertObject(entity));
    }

    @Override
    public void delete(Long id) {
        reportService.delete(id);
    }
}
