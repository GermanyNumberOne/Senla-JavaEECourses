package com.senla.courses.project.services.impl;

import com.senla.courses.project.dto.ReportDto;
import com.senla.courses.project.dao.api.UserDao;
import com.senla.courses.project.exception.UserDoNotHavePermissionException;
import com.senla.courses.project.model.User;
import com.senla.courses.project.services.api.ReportService;
import com.senla.courses.project.dao.api.ReportDao;
import lombok.RequiredArgsConstructor;
import com.senla.courses.project.model.Report;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{
    private final ReportDao reportDao;

    private final UserDao userDao;

    private final ModelMapper modelMapper;

    public boolean isUserAllowed(Long id){
        User user = userDao.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        if(user.getRoles().stream()
                .anyMatch(role -> role.getRoleName().equals("ROLE_ADMIN"))) return true;

        return user.getBankAccount().getOperations().stream()
                .anyMatch(operation -> operation.getReport().getId().equals(id));
    }

    @Override
    @Transactional
    public List<ReportDto> getAll(){
        return reportDao.getAll().stream().map(value -> modelMapper.map(value, ReportDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(ReportDto entity) {
        reportDao.create(modelMapper.map(entity, Report.class));
    }

    @Override
    @Transactional
    public ReportDto read(Long id) {
        if(!isUserAllowed(id))throw new UserDoNotHavePermissionException("Access error");
        Report report = reportDao.read(id);

        return report == null ? null : modelMapper.map(report, ReportDto.class);
    }

    @Override
    @Transactional
    public void update(ReportDto entity) {
        reportDao.update(modelMapper.map(entity, Report.class));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        reportDao.delete(id);
    }
}
