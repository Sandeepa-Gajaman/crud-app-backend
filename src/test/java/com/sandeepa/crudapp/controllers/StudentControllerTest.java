package com.sandeepa.crudapp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mvc;
    @Test
    void canGetStudentDetails() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/student/details").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void canSearchStudents() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/student/search?keyword=G").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void canGetStudentById() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/student/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}