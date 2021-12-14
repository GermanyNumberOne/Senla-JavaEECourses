package com.services.impl;

import com.dao.api.ReportDao;
import com.dto.ReportDto;
import com.model.Report;
import com.services.api.ReportService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD

import java.util.List;
import java.util.stream.Collectors;
=======
>>>>>>> origin

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
