package Controllers;

import Controllers.api.CardController;
import Services.api.CardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.CardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CardControllerImpl implements CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(CardDto entity) {
        cardService.create(entity);
    }

    @Override
    public CardDto read(Long id) {
        return cardService.read(id);
    }

    public String getMappedObject(Long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(cardService.read(id));
    }

    @Override
    public void update(CardDto entity) {
        cardService.update(entity);
    }

    @Override
    public void delete(Long id) {
        cardService.delete(id);
    }
}
