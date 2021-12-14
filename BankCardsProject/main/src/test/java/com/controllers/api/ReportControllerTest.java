package com.controllers.api;

import com.model.Operation;
import com.model.Report;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

class ReportControllerTest extends ControllerTest{
    @Test
    public void create() throws Exception {
        Report report = new Report();

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/reports")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(report));

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Transactional
    public void getAll() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/reports")
                .contentType(MediaType.APPLICATION_JSON_VALUE);
        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void read() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/reports/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }

    @Test
    public void update() throws Exception {
        Report report = new Report();

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/reports")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(report));

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }

    @Test
    public void delete() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/reports/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }
}