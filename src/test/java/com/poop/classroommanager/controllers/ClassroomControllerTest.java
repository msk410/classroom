package com.poop.classroommanager.controllers;

import com.poop.classroommanager.models.Classroom;
import com.poop.classroommanager.repositories.ClassroomRepo;
import com.poop.classroommanager.services.ClassroomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ClassroomController.class)
public class ClassroomControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    ClassroomRepo classroomRepo;

    @MockBean
    ClassroomService classroomService;

    @Test
    public void trueEqualsTrue() throws Exception {
        MockHttpServletRequestBuilder request = post("/classroom")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"subject\": \"math\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.subject", equalTo("math") ));

        verify(this.classroomRepo).save(any(Classroom.class));

    }
    @Test
    public  void  a() throws Exception{
        Classroom c = new Classroom();
        c.setSubject("math");
        when(this.classroomRepo.findAll()).thenReturn(Collections.singleton(c));

        MockHttpServletRequestBuilder request = get("/classroom/list")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].subject", equalTo("math") ));
         //       .andExpect(jsonPath("$[0].subject", equalTo("math") ));
    }

}