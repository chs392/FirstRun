package com.learn.docker.firstrun.storage;

import com.learn.docker.firstrun.model.Person;

public interface Storage {
    Person getPersonDetails(String id);

    void storePersonDetails(Person person);
}
