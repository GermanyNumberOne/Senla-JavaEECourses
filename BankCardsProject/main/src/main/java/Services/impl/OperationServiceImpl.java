package Services.impl;

import Services.api.OperationService;
import dao.api.OperationDao;
import dto.OperationDto;
import dto.OperationDto;
import lombok.RequiredArgsConstructor;
import model.Operation;
import model.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {
    @Autowired
    private final OperationDao operationDao;
    @Autowired
    private ModelMapper modelMapper;

    protected OperationDao getDefaultDao() {
        return operationDao;
    }

    @Override
    public void create(OperationDto entity) {
        getDefaultDao().create(modelMapper.map(entity, Operation.class));
    }

    @Override
    public OperationDto read(Long id) {
        return modelMapper.map(getDefaultDao().read(id), OperationDto.class);
    }

    @Override
    public void update(OperationDto entity) {
        getDefaultDao().update(modelMapper.map(entity, Operation.class));
    }

    @Override
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
