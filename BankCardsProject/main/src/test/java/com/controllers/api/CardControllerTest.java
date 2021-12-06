package com.controllers.api;

import com.dao.api.CardDao;
import com.dao.api.UserDao;
import com.model.Card;
import com.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

class CardControllerTest extends ControllerTest {

    @Autowired
    private CardDao cardDao;

    @Test
    public void create() throws Exception {
        Card card = new Card();
        card.setNumber("123");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/cards")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(card));

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Transactional
    public void getAll() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cards")
                .contentType(MediaType.APPLICATION_JSON_VALUE);
        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void read() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cards/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }

    @Test
    public void update() throws Exception {
        Card card = new Card();
        card.setNumber("123");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/cards")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(card));

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }

    @Test
    public void delete() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/cards/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }

    @Test
    void readCardByNumber() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cards", "number")
                .contentType(MediaType.TEXT_PLAIN_VALUE)
                .param("number", "123");

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }
}