package com.controllers.api;

import com.dao.api.BankAccountDao;
import com.dto.BankAccountDto;
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

import java.util.ArrayList;


class BankAccountControllerTest extends ControllerTest{
    @Autowired
    private BankAccountDao bankAccountDao;

    @Test
    public void create() throws Exception {
        BankAccountDto bankAccount = new BankAccountDto();
        bankAccount.setOperations(new ArrayList<>());
        bankAccount.setCards(new ArrayList<>());

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/bank-accounts")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(bankAccount));

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getAll() throws Exception {
       MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bank-accounts")
               .contentType(MediaType.APPLICATION_JSON_VALUE);
       ResultActions result = mvc.perform(requestBuilder);
       MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
               .andDo(MockMvcResultHandlers.print())
               .andReturn();
    }

    @Test
    public void read() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bank-accounts/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }

    @Test
    public void update() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/bank-accounts")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(new BankAccountDto()));

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }

    @Test
    public void delete() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/bank-accounts/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }
}