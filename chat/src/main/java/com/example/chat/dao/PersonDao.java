package com.example.chat.dao;
import java.util.UUID;

import com.example.chat.model.Person;

public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    Object selectPersonById(UUID id);

    int updatePerson(UUID id, Person person);

    int deletePerson(UUID id);

    boolean isEmpty();
}
