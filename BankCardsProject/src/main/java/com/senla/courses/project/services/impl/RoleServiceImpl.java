package com.senla.courses.project.services.impl;

import com.senla.courses.project.services.api.RoleService;
import com.senla.courses.project.dao.api.RoleDao;
import com.senla.courses.project.dto.RoleDto;
import com.senla.courses.project.model.Role;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    private final ModelMapper modelMapper;

    @Override
    public void create(RoleDto entity) {
        roleDao.create(modelMapper.map(entity, Role.class));
    }

    @Override
    public RoleDto read(Long id) {
        Role role = roleDao.read(id);

        return role == null ? null : modelMapper.map(role, RoleDto.class);
    }

    @Override
    public void update(RoleDto entity) {
        roleDao.update(modelMapper.map(entity, Role.class));
    }

    @Override
    public void delete(Long id) {
        roleDao.delete(id);
    }

    @Override
    public List<RoleDto> getAll() {
        return roleDao.getAll().stream().map(role -> modelMapper.map(role, RoleDto.class)).collect(Collectors.toList());
    }
}
