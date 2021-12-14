package com.services.impl;

import com.dto.BankAccountDto;
import com.dto.OperationDto;
import com.dto.UserDto;
import com.model.User;
import com.model.UserInformation;
import com.services.api.ReportService;
import com.dao.api.ReportDao;
import com.dto.ReportDto;
import lombok.RequiredArgsConstructor;
import com.model.Report;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{
    private final ReportDao reportDao;

    private final ModelMapper modelMapper;


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
