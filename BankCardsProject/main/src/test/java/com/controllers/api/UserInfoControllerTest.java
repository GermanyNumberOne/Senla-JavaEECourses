package com.controllers.api;

import com.model.User;
import com.model.UserInformation;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

class UserInfoControllerTest extends ControllerTest{
    @Test
    public void create() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users-info")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(new UserInformation()));

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Transactional
    public void getAll() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users-info")
                .contentType(MediaType.APPLICATION_JSON_VALUE);
        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void read() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users-info/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }

    @Test
    public void update() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users-info")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(new User()));

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }

    @Test
    public void delete() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users-info/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        ResultActions result = mvc.perform(requestBuilder);
        MvcResult mvcResult = result.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo((MockMvcResultHandlers.print()))
                .andReturn();
    }
}