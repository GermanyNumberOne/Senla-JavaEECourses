package com.controllers;

import com.dto.CardDto;
import com.services.api.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/cards")
public class CardControllerImpl {
    @Autowired
    private CardService cardService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody CardDto entity) {
        cardService.create(entity);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CardDto>> getAll(){
        List<CardDto> cards = cardService.getAll();

        if(cards.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(cards);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CardDto> read(@PathVariable Long id) {
        CardDto card = cardService.read(id);

        if(card == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(card);
    }
/*
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCardByNumber(@RequestBody String number){
        cardService.deleteCardByNumber(number);
        return ResponseEntity.ok().build();
    }
*/
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<CardDto> readCardByNumber(String number){
        CardDto card = cardService.readCardByNumber(number);

        return card == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : ResponseEntity.ok(card);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody CardDto entity) {
        cardService.update(entity);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cardService.delete(id);
        return ResponseEntity.ok().build();
    }

}
