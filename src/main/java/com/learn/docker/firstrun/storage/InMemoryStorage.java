package com.learn.docker.firstrun.storage;

import com.learn.docker.firstrun.model.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Profile("inMemory")
public class InMemoryStorage implements Storage {

    private static final Map<String, Person> personMap = new HashMap<>();

    @Override
    public Person getPersonDetails(String id) {
        return InMemoryStorage.personMap.get(id);
    }

    @Override
    public void storePersonDetails(Person person) {
        InMemoryStorage.personMap.put(person.getId(), person);
    }
}
