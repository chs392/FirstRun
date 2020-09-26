package com.learn.docker.firstrun.service;

import com.learn.docker.firstrun.model.Person;
import com.learn.docker.firstrun.storage.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class FirstRunService {

    private final Storage storage;

    public FirstRunService(Storage storage) {
        this.storage = storage;
    }

    public Person getPersonDetails(String id) {
        Person person = null;
        try {
            person = this.storage.getPersonDetails(id);
        } catch (Exception e) {
            log.error("Exception in FirstRunService getPersonDetails: ", e);
        }
        return person;
    }

    public String storePersonDetails(Person person) {
        String id = null;
        try {
            String tempId = UUID.randomUUID().toString();
            person.setId(tempId);
            this.storage.storePersonDetails(person);
            id = tempId;
        } catch (Exception e) {
            log.error("Exception in FirstRunService storePersonDetails: ", e);
        }
        return id;
    }
}
