package com.services.impl;

import com.services.api.ReportService;
import com.dao.api.ReportDao;
import com.dto.ReportDto;
import lombok.RequiredArgsConstructor;
import com.model.Report;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{
    private final ReportDao reportDao;

    private final ModelMapper modelMapper;

    protected ReportDao getDefaultDao() {
        return reportDao;
    }

    @Override
    @Transactional
    public void create(ReportDto entity) {
        getDefaultDao().create(modelMapper.map(entity, Report.class));
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
        getDefaultDao().update(modelMapper.map(entity, Report.class));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
