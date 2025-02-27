package com.example.chat.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.chat.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    private final static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public Object selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    } 

    @Override
    public int updatePerson(UUID id, Person person) {
        Optional<Person> personMaybe = (Optional<Person>) selectPersonById(id);

        if (personMaybe.isPresent()) {
            int indexOfPersonToUpdate = DB.indexOf(personMaybe.get());
            if (indexOfPersonToUpdate >= 0) {
                DB.set(indexOfPersonToUpdate, new Person(id, person.getName()));
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> personMaybe = (Optional<Person>) selectPersonById(id);
        if (!personMaybe.isPresent()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return DB.isEmpty();
    }

}
