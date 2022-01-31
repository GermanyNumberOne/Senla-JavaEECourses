package com.senla.courses.project.services.impl;

import com.senla.courses.project.dto.OperationDto;
import com.senla.courses.project.dto.ReportDto;
import com.senla.courses.project.dao.api.OperationCategoriesDao;
import com.senla.courses.project.dao.api.UserDao;
import com.senla.courses.project.dto.OperationCategoryDto;
import com.senla.courses.project.exception.UserDoNotHavePermissionException;
import com.senla.courses.project.model.User;
import com.senla.courses.project.services.api.OperationService;
import com.senla.courses.project.dao.api.OperationDao;
import lombok.RequiredArgsConstructor;
import com.senla.courses.project.model.Operation;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OperationServiceImpl implements OperationService {
    private final OperationDao operationDao;

    private final UserDao userDao;

    private final ModelMapper modelMapper;

    private final OperationCategoriesDao operationCategoriesDao;

    public boolean isUserAllowed(Long id){
        User user = userDao.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        if(user.getRoles().stream()
                .anyMatch(role -> role.getRoleName().equals("ROLE_ADMIN"))) return true;

        return user.getBankAccount().getOperations().stream().anyMatch(operation -> operation.getId().equals(id));
    }

    @Override
    @Transactional
    public List<OperationDto> getAll(){
        return operationDao.getAll().stream().map(value -> modelMapper.map(value, OperationDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(OperationDto entity) {
        operationDao.create(modelMapper.map(entity, Operation.class));
    }

    @Override
    @Transactional
    public OperationDto read(Long id) {
        if(!isUserAllowed(id))throw new UserDoNotHavePermissionException("Access error");
        Operation operation = operationDao.read(id);

        return operation == null ? null : modelMapper.map(operation, OperationDto.class);
    }

    @Override
    @Transactional
    public void update(OperationDto entity) {
        operationDao.update(modelMapper.map(entity, Operation.class));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if(!isUserAllowed(id))throw new UserDoNotHavePermissionException("Access error");
        operationDao.delete(id);
    }

    @Override
    @Transactional
    public void create(Long bankAccountId, Long cost, String category, Boolean isSuccess){
        OperationDto operation = new OperationDto();
        operation.setBankAccountId(bankAccountId);
        operation.setCost(cost);

        ReportDto report = new ReportDto();
        report.setIsSuccess(isSuccess);
        report.setCategories(new ArrayList<>());

        OperationCategoryDto opCategory = new OperationCategoryDto();
        opCategory.setId(operationCategoriesDao.getCategoryByName(category).getId());
        opCategory.setName(category);

        report.getCategories().add(opCategory);
        operation.setReport(report);

        operationDao.create(modelMapper.map(operation, Operation.class));
    }
}
