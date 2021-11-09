package Controllers;

import Controllers.api.ReportController;
import Services.api.ReportService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportControllerImpl implements ReportController {
    @Autowired
    private ReportService reportService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(ReportDto entity) {
        reportService.create(entity);
    }

    @Override
    public ReportDto read(Long id) {
        return reportService.read(id);
    }

    public String getMappedObject(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(reportService.read(id));
    }


    @Override
    public void update(ReportDto entity) {
        reportService.update(entity);
    }

    @Override
    public void delete(Long id) {
        reportService.delete(id);
    }
}
