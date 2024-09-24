package com.example.back_end_task;

import back_end_task.api.controllers.ClientController;
import back_end_task.api.services.ClientService;
import back_end_task.model.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ClientController.class)
public class Tests {

    @Mock
    private MockMvc mockMvc;

    @MockBean
    private ClientService studentService;

    //In this case this is some dummy data
    private List<Client> clientList = null;
    private Client client = null;
    private String studentJsonString = null;

    @Before
    public void setUp() throws JsonProcessingException {
//        this.clientList = Arrays.asList(new Student(1, Master, firstName1, className1), new Student(2, Miss, firstName2, className2), new Student(3, Miss, firstName3, className3)));
        this.client = new Client(1,);
        this.studentJsonString = new ObjectMapper().writeValueAsString(client);
    }


    @Test
    public void test_findByID(){
        when(studentService.getStudentByNameAndClassTest(eq(name), eq(clazz))).thenReturn(studentList);
        mockMvc
                .perform(get("/student/getStudentByNameAndClassTest/{name}/{clazz}",name, clazz))
                .andExpect(status().isOk());
    }