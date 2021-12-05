package com.services.impl;

import com.dao.api.OperationDao;
import com.dto.OperationDto;
import com.model.Operation;
import com.services.api.OperationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class OperationServiceImplTest {

    private OperationService operationService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private OperationDao operationDao;

    @BeforeEach
    void setUp() {
        modelMapper = mock(ModelMapper.class);
        operationDao = mock(OperationDao.class);

        operationService = new OperationServiceImpl(operationDao,modelMapper);
    }

    @Test
    void create() {
        OperationDto operation = new OperationDto();

        operationService.create(operation);
        Mockito.verify(operationDao, atLeastOnce()).create(modelMapper.map(operation, Operation.class));
    }

    @Test
    void getAll() {
        assertTrue(operationService.getAll().size() == 0);
        Mockito.verify(operationDao, atLeastOnce()).getAll();
    }

    @Test
    void read() {
        assertTrue(operationService.read(1l) == null);
        Mockito.verify(operationDao, atLeastOnce()).read(1l);
    }

    @Test
    void update() {
        OperationDto operation = new OperationDto();

        operationService.update(operation);
        Mockito.verify(operationDao, atLeastOnce()).update(modelMapper.map(operation, Operation.class));
    }

    @Test
    void delete() {
        operationService.delete(1l);
        Mockito.verify(operationDao, atLeastOnce()).delete(1l);
    }
}