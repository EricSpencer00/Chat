package com.example.chat.api;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.chat.model.Person;


@WebMvcTest(PersonController.class)
public class PersonControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonController personController;

    @Test
    public void testGetAllPersons() throws Exception {
        Person person = new Person(UUID.randomUUID(), "John Doe");
        when(personController.getPerson(person.getId())).thenReturn(person);

        Object id = person.getId();
        mockMvc.perform(get("/{id}" + id))
            .andExpect(status().isOk())
            .andExpect(content().json(person.toString()));
        mockMvc.perform(get("/{id}" + person.getId()))
            .andExpect(status().isOk())
            .andExpect(content().json(person.toString()));
    }

    @Test
    public void testAddPerson() throws Exception {
        Person person = new Person(UUID.randomUUID(), "John Doe");
        RequestBuilder request = get("/{id}").contentType("application/json").content(person.toString());

        mockMvc.perform(request)
            .andExpect(status().isOk());
    }

    
}
