package com.example.chat.api;

import com.example.chat.model.Person;
import com.example.chat.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class PersonController {
    
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(Person person) {
        personService.addPerson(person);
    }

    @GetMapping("/{id}")
    public Person getPerson(UUID id) {
        return personService.getPerson(id).orElse(null);
    }
    
    @PutMapping("/{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person person) {
        personService.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }
}
