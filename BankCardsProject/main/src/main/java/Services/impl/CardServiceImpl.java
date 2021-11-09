package Services.impl;

import Services.api.CardService;
import dao.api.CardDao;
import dto.CardDto;
import dto.CardDto;
import lombok.RequiredArgsConstructor;
import model.Card;
import model.Card;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    @Autowired
    private final CardDao cardDao;

    @Autowired
    private ModelMapper modelMapper;


    protected CardDao getDefaultDao() {
        return cardDao;
    }

    @Override
    public void create(CardDto entity) {
        getDefaultDao().create(modelMapper.map(entity, Card.class));
    }

    @Override
    public CardDto read(Long id) {
        return modelMapper.map(getDefaultDao().read(id), CardDto.class);
    }

    @Override
    public void update(CardDto entity) {
        getDefaultDao().update(modelMapper.map(entity, Card.class));
    }

    @Override
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
