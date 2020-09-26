package com.learn.docker.firstrun.storage;

import com.learn.docker.firstrun.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Profile("postgresDB")
@Component
public class PostgresStorage implements Storage {

    private final JdbcTemplate jdbcTemplate;

    public PostgresStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Person getPersonDetails(String id) {
        List<Map<String, Object>> persons = this.jdbcTemplate.queryForList("select * from person where id = ?", new Object[] {id});
        if (persons.size() > 0) {
            Person person = new Person();
            person.setId(persons.get(0).get("id").toString());
            person.setFirstName(persons.get(0).get("firstname").toString());
            person.setLastName(persons.get(0).get("lastname").toString());
            return person;
        } else {
            return null;
        }
    }
       // this.jdbcTemplate.execute("INSERT INTO person (id, firstname, lastname) VALUES ('" + person.getId() + "','" + person.getFirstName() + "','" + person.getLastName() + "')");

    @Override
    public void storePersonDetails(Person person) {
        this.jdbcTemplate.update("INSERT INTO person (id, firstname, lastname) VALUES (?,?,?)", new Object[]{person.getId(), person.getFirstName(), person.getLastName()});
    }
}
