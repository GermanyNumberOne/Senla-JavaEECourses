package com.senla.courses.project.services.impl;

import com.senla.courses.project.dto.ReportDto;
import com.senla.courses.project.dao.api.ReportDao;
import com.senla.courses.project.model.Report;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReportServiceImplTest {

    @InjectMocks
    private ReportServiceImpl reportService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ReportDao reportDao;

    @Test
    void create() {
        ReportDto report = new ReportDto();

        reportService.create(report);
        Mockito.verify(reportDao, atLeastOnce()).create(modelMapper.map(report, Report.class));
    }

    @Test
    void getAll() {
        assertTrue(reportService.getAll().size() == 0);
        Mockito.verify(reportDao, atLeastOnce()).getAll();
    }

    @Test
    void read() {
        assertTrue(reportService.read(1l) == null);
        Mockito.verify(reportDao, atLeastOnce()).read(1l);
    }

    @Test
    void update() {
        ReportDto report = new ReportDto();

        reportService.update(report);
        Mockito.verify(reportDao, atLeastOnce()).update(modelMapper.map(report, Report.class));
    }

    @Test
    void delete() {
        reportService.delete(1l);
        Mockito.verify(reportDao, atLeastOnce()).delete(1l);
    }
}