package com.controllers.api;

import com.dao.api.CardDao;
import com.dao.api.OperationDao;
import com.model.Card;
import com.model.Operation;
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

class OperationControllerTest extends ControllerTest{
    @Test
    public void create() throws Exception {
        Operation operation = new Operation();

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/operations")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(operation));

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Transactional
    public void getAll() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/operations")
                .contentType(MediaType.APPLICATION_JSON_VALUE);
        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void read() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/operations/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }

    @Test
    public void update() throws Exception {
        Operation operation = new Operation();

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/operations")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(operation));

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }

    @Test
    public void delete() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/operations/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }
}