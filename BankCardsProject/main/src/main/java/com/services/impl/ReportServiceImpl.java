package com.services.impl;

import com.services.api.ReportService;
import com.dao.api.ReportDao;
import com.dto.ReportDto;
import lombok.RequiredArgsConstructor;
import com.model.Report;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{
    private final ReportDao reportDao;

    private final ModelMapper modelMapper;


    protected ReportDao getDefaultDao() {
        return reportDao;
    }

    @Override
    public void create(ReportDto entity) {
        getDefaultDao().create(modelMapper.map(entity, Report.class));
    }

    @Override
    public ReportDto read(Long id) {
        return modelMapper.map(getDefaultDao().read(id), ReportDto.class);
    }

    @Override
    public void update(ReportDto entity) {
        getDefaultDao().update(modelMapper.map(entity, Report.class));
    }

    @Override
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
