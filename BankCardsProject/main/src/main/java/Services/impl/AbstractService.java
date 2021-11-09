package Services.impl;

import Services.api.Service;
import dao.api.Dao;
import dto.AbstractDto;
import model.BaseEntity;
import org.modelmapper.ModelMapper;


public abstract class AbstractService<T extends AbstractDto, D extends Dao> implements Service<T> {
    protected abstract D getDefaultDao();

    private ModelMapper modelMapper;

    @Override
    public void create(T entity) {
        getDefaultDao().create(modelMapper.map(entity, BaseEntity.class));
    }

    @Override
    public T read(Long id) {
        return (T) modelMapper.map(getDefaultDao().read(id), AbstractDto.class);
    }

    @Override
    public void update(T entity) {
        getDefaultDao().update(modelMapper.map(entity, BaseEntity.class));
    }

    @Override
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
