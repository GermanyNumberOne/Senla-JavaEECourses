package com.senla.courses.project.services.impl;

import com.senla.courses.project.dto.OperationCategoryDto;
import com.senla.courses.project.model.OperationCategory;
import com.senla.courses.project.services.api.OperationCategoriesService;
import com.senla.courses.project.dao.api.OperationCategoriesDao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OperationCategoriesServiceImpl implements OperationCategoriesService {
    private final OperationCategoriesDao operationCategoriesDao;

    private final ModelMapper modelMapper;

    @Override
    public void create(OperationCategoryDto entity) {
        operationCategoriesDao.create(modelMapper.map(entity, OperationCategory.class));
    }

    @Override
    public OperationCategoryDto read(Long id) {
        OperationCategory operationCategory = operationCategoriesDao.read(id);

        return operationCategory == null ? null : modelMapper.map(operationCategory, OperationCategoryDto.class);
    }

    @Override
    public void update(OperationCategoryDto entity) {
        operationCategoriesDao.update(modelMapper.map(entity, OperationCategory.class));
    }

    public OperationCategoryDto getCategoryByName(String name){
        return modelMapper.map(operationCategoriesDao.getCategoryByName(name), OperationCategoryDto.class);
    }

    @Override
    public void delete(Long id) {
        operationCategoriesDao.delete(id);
    }

    @Override
    public List<OperationCategoryDto> getAll() {
        return operationCategoriesDao.getAll().stream().map(role -> modelMapper.map(role, OperationCategoryDto.class)).collect(Collectors.toList());
    }
}
