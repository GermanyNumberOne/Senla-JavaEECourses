package Services.impl;

import Services.api.ReportService;
import dao.api.ReportDao;
import dto.ReportDto;
import dto.ReportDto;
import lombok.RequiredArgsConstructor;
import model.Report;
import model.Report;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{
    @Autowired
    private final ReportDao reportDao;
    @Autowired
    private ModelMapper modelMapper;


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
