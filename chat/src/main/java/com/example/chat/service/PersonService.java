package com.example.chat.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.example.chat.dao.PersonDao;
import com.example.chat.model.Person;

@RestController
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) { // Qualifier points to the database chosen
        this.personDao = personDao;
    }

    @PostMapping
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
    
    @GetMapping("/{id}")
    public Person getPerson(UUID id) {
        return personDao.selectPersonById(id) != null ? (Person) personDao.selectPersonById(id) : null;
    }

    @PutMapping("/{id}")
    public void updatePerson(UUID id, Person person) {
        personDao.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(UUID id) {
        personDao.deletePerson(id);
    }
}
